/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ControleProcedimentoDAO;
import java.io.IOException;
import java.util.ArrayList;
import vo.ControleProcedimentoVO;

/**
 *
 * @author matha
 */
public class ControleProcedimentoControl implements CrudControl {

    private int codigo;
    private String nomePaciente;
    private int cro;
    private double valor;
    private Data data;

    public ArrayList<ControleProcedimentoVO> buscar() throws IOException, ClassNotFoundException {

        ControleProcedimentoDAO ControleProcedimentoDAO = new ControleProcedimentoDAO();
        return ControleProcedimentoDAO.buscar();
    }

    public ControleProcedimentoVO buscar(int codigo) throws IOException, ClassNotFoundException {
        ControleProcedimentoDAO ControleProcedimentoDAO = new ControleProcedimentoDAO();
        return ControleProcedimentoDAO.buscar(codigo);
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nomePaciente
     */
    public String getNomePaciente() {
        return nomePaciente;
    }

    /**
     * @param nomePaciente the nomePaciente to set
     */
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void cadastrar(String codigo, String nome, String cro, String data, String valor) throws IOException, ClassNotFoundException, ValidacaoException {

        this.validarCamposObrigatorios(codigo, nome, cro, data, valor);
        
        Data date = new Data();
        date.setAno(Integer.parseInt(data.substring(6, 10)));
        date.setDia(Integer.parseInt(data.substring(0,2)));
        date.setMes(Integer.parseInt(data.substring(3,5)));
        ControleProcedimentoVO controleprocedimentoVO = new ControleProcedimentoVO();

        controleprocedimentoVO.setCodigo(Integer.parseInt(codigo));
        controleprocedimentoVO.setCro(Integer.parseInt(cro));
        controleprocedimentoVO.setNome(nome);
        controleprocedimentoVO.setData(date);
        controleprocedimentoVO.setValor(Double.parseDouble(valor));

        ControleProcedimentoDAO controleprocedimentoDAO = new ControleProcedimentoDAO(controleprocedimentoVO);
        
        controleprocedimentoDAO.cadastrar();
    }

    private void validarCamposObrigatorios(String codigo, String nome, String valor, String data, String val) throws ValidacaoException {
        
        if (codigo.isEmpty()) {
            throw new ValidacaoException("Digite alguma coisa.");
        }
        
        try {
                int cod = Integer.parseInt(codigo);
                double value = Double.parseDouble(val);
                int dia = Integer.parseInt(data.substring(0, 2));
                int mes = Integer.parseInt(data.substring(3,5));
                int ano = Integer.parseInt(data.substring(6,10));
                if (ano > 2018)
                    throw new ValidacaoException("Nao passamos de 2018.");
                if (dia > 31 && dia < 1) 
                    throw new ValidacaoException("Digite um dia valido.");
                else if (mes > 12 && mes < 1)
                    throw new ValidacaoException("Digite um mes valido.");
                
            } catch (NumberFormatException e) {
                throw new ValidacaoException("Digite numeros validos.");
            }
        
                if (nome.isEmpty())
                    throw new ValidacaoException("Digite um nome.");
                if (val.isEmpty())
                    throw new ValidacaoException("Digite um valor.");
                
    }

}
