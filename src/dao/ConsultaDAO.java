/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.Data;
import control.Relogio;
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
import vo.ConsultaVO;

/**
 *
 * @author matha
 */
public class ConsultaDAO implements CrudDAO{

    ObjectOutputStream oos;
    private ConsultaVO consultaVO;
    
    public ConsultaDAO(){
    }
    
    public ConsultaDAO(ConsultaVO consultaVO){
        this.consultaVO = consultaVO;
    }
    @Override
    public ArrayList<ConsultaVO> buscar(String nomeDentista) throws IOException {
        ArrayList<ConsultaVO> lista = new ArrayList<>();
           
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("consulta.txt"))) {
                while (true) {
                    
                    lista.add((ConsultaVO) ois.readObject());
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ConsultaVO buscar(Data data, Relogio hora) throws IOException, ClassNotFoundException {
        ConsultaVO consultaVO = new ConsultaVO();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("consulta.txt"))) {
                while (true) {
                   consultaVO = ((ConsultaVO) ois.readObject());
                   if(data.equals(consultaVO.getData()) && hora.equals(consultaVO.getHora())){
                   } else {
                       return consultaVO;
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
        ArrayList<ConsultaVO> lista = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("consulta.txt"))) {
                while (true) {
                    lista.add((ConsultaVO) ois.readObject());
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            }
            
            lista.add(consultaVO);
            
            try{
                if(oos == null){
                    oos = new ObjectOutputStream(new FileOutputStream("consulta.txt"));
                }
                
                    oos.writeObject(lista);
                    System.out.println("Escrita feita com sucesso.");
            }catch(EOFException x){
                //jdialog
            }
    }
    
}
