/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import vo.ControleProcedimentoVO;
import java.io.*;

/**
 *
 * @author matha
 */
public class ControleProcedimentoDAO {
    private ObjectOutputStream oos;
    private ControleProcedimentoVO controleprocedimentoVO;

    public ControleProcedimentoDAO(ControleProcedimentoVO controleprocedimentoVO) {
        this.controleprocedimentoVO = controleprocedimentoVO;
    }

    public ControleProcedimentoDAO() {
    }

    public ArrayList<ControleProcedimentoVO> buscar() throws IOException, ClassNotFoundException {
        ArrayList<ControleProcedimentoVO> lista = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("controleprocedimento.txt"))) {
                while (true) {
                    lista.add((ControleProcedimentoVO) ois.readObject());
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            }
        return lista;
    }

    public ControleProcedimentoVO buscar(int codigo) throws IOException, ClassNotFoundException {
        ControleProcedimentoVO controleprocedimentoVO = new ControleProcedimentoVO();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("controleprocedimento.txt"))) {
                while (true) {
                   controleprocedimentoVO = ((ControleProcedimentoVO) ois.readObject());
                   if(codigo == controleprocedimentoVO.getCodigo()){
                       return controleprocedimentoVO;
                   }
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            }
        //se chegar aqui retornara nada
        return null;
    }

    public void cadastrar() throws IOException, ClassNotFoundException {
        ArrayList<ControleProcedimentoVO> lista = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("controleprocedimento.txt"))) {
                while (true) {
                    lista.add((ControleProcedimentoVO) ois.readObject());
                }
            }catch (FileNotFoundException | EOFException e){
                System.out.println(e.getMessage());
            }
            
            lista.add(controleprocedimentoVO);
            
            try{
                if(oos == null){
                    oos = new ObjectOutputStream(new FileOutputStream("controleprocedimento.txt"));
                }
                
                    oos.writeObject(lista);
                    System.out.println("Escrita feita com sucesso.");
            }catch(EOFException x){
                
            }
    }

}
