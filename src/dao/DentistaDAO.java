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
import vo.DentistaVO;
import vo.DentistaVO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matha
 */
public class DentistaDAO implements CrudDAO{

    private DentistaVO dentistaVO;
    ObjectOutputStream oos;

    public DentistaDAO(DentistaVO dentistaVO){
        this.dentistaVO = dentistaVO;
    }
    
    public DentistaDAO(){
    }
    
    
    @Override
    public ArrayList<DentistaVO> buscar() throws IOException {
        ArrayList<DentistaVO> lista = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dentista.txt"))) {
                while (true) {
                    lista.add((DentistaVO) ois.readObject());
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(DentistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public DentistaVO buscar(int cro) throws IOException, ClassNotFoundException {
        DentistaVO dentistaVO = new DentistaVO();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dentista.txt"))) {
                while (true) {
                   dentistaVO = ((DentistaVO) ois.readObject());
                   if(cro == dentistaVO.getCro()){
                       return dentistaVO;
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
        ArrayList<DentistaVO> lista = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dentista.txt"))) {
                while (true) {
                    lista.add((DentistaVO) ois.readObject());
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            }
            
            lista.add(dentistaVO);
            
            try{
                if(oos == null){
                    oos = new ObjectOutputStream(new FileOutputStream("dentista.txt"));
                }
                
                    oos.writeObject(lista);
                    System.out.println("Escrita feita com sucesso.");
            }catch(EOFException x){
                //jdialog
            }
    }

}

