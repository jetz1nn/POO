package dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.PacienteVO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matha
 */
public class PacienteDAO implements CrudDAO{

    private PacienteVO pacienteVO;
    private ObjectOutputStream oos;
    public PacienteDAO(){
    }
    
    public PacienteDAO(PacienteVO pacienteVO) {
        this.pacienteVO = pacienteVO;
    }
@Override
    public ArrayList<PacienteVO> buscar() throws IOException {
        ArrayList<PacienteVO> lista = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("paciente.txt"))) {
                while (true) {
                    lista.add((PacienteVO) ois.readObject());
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public PacienteVO buscar(String nome) throws IOException, ClassNotFoundException {
        PacienteVO pacienteVO = new PacienteVO();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("paciente.txt"))) {
                while (true) {
                   pacienteVO = ((PacienteVO) ois.readObject());
                   if(nome == pacienteVO.getNome()){
                       return pacienteVO;
                    }
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            }
        //se chegar aqui retornara nada
        return null;
    }

    @Override
    public void cadastrar() throws IOException, ClassNotFoundException {
        ArrayList<PacienteVO> lista = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("paciente.txt"))) {
                while (true) {
                    lista.add((PacienteVO) ois.readObject());
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            }
            
            lista.add(pacienteVO);
            
            try{
                if(oos == null){
                    oos = new ObjectOutputStream(new FileOutputStream("paciente.txt"));
                }
                
                    oos.writeObject(lista);
                    System.out.println("Escrita feita com sucesso.");
            }catch(EOFException x){
                //jdialog
            }
    }
}
