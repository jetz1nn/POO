/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PacienteDAO;
import java.io.IOException;
import java.util.Date;
import vo.PacienteVO;

/**
 *
 * @author matha
 */
public class PacienteControl implements CrudControl {

    private String nome;
    private Data dataNasc;
    private String sexo;
    private String endereco;
    private String telefone;
    private String formaPagamento;

    public PacienteControl(){
    }
    
    public void cadastrar(String nome, String dataNasc, String sexo, String endereco, String telefone, String formaPagamento) throws ValidacaoException, IOException, ClassNotFoundException {
        
        this.validarCamposObrigatorios(nome, dataNasc, sexo, endereco, telefone, formaPagamento);
        
        Data date = new Data();
        date.setAno(Integer.parseInt(dataNasc.substring(6, 10)));
        date.setDia(Integer.parseInt(dataNasc.substring(0,2)));
        date.setMes(Integer.parseInt(dataNasc.substring(3,5)));
        
        PacienteVO pacienteVO = new PacienteVO();
        
        pacienteVO.setDataNasc(date);
        pacienteVO.setSexo(sexo);
        pacienteVO.setNome(nome);
        pacienteVO.setTelefone(telefone);
        pacienteVO.setFormaPagamento(formaPagamento);
        pacienteVO.setEndereco(endereco);
        
        PacienteDAO pacienteDAO = new PacienteDAO(pacienteVO);
        
        pacienteDAO.cadastrar();
        
        
        
    }
    
    private void validarCamposObrigatorios(String nome, String dataNasc, String sexo, String endereco, String telefone, String formaPagamento) throws ValidacaoException{
        try {

                int dia = Integer.parseInt(dataNasc.substring(0, 2));
                int mes = Integer.parseInt(dataNasc.substring(3,5));
                int ano = Integer.parseInt(dataNasc.substring(6,10));
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
            if (dataNasc.isEmpty())
                throw new ValidacaoException("Digite uma data.");
            if (endereco.isEmpty())
                throw new ValidacaoException("Digite um endereco.");
            if (telefone.isEmpty())
                throw new ValidacaoException("Digite um telefone.");
            if (formaPagamento.isEmpty())
                throw new ValidacaoException("Selecione uma forma de pagamento.");
            
                
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataNasc
     */
    
    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the dataNasc
     */
    public Data getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(Data dataNasc) {
        this.dataNasc = dataNasc;
    }

   

 
    

}
