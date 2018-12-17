/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DentistaDAO;
import java.io.IOException;
import vo.DentistaVO;

/**
 *
 * @author matha
 */
public class DentistaControl implements CrudControl {

    private int cro;
    private String nomeCompleto;
    private String endereco;
    private String telefone;
    private String especialidade;

    public DentistaControl() {
    }

    /**
     * @return the cro
     */
    public int getCro() {
        return cro;
    }

    /**
     * @param cro the cro to set
     */
    public void setCro(int cro) {
        this.cro = cro;
    }

    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     * @param nomeCompleto the nomeCompleto to set
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void cadastrar(String cro, String nomeCompleto, String endereco, String telefone, String especialidade) throws IOException, ClassNotFoundException, ValidacaoException {

        this.validarCamposObrigatorios(cro, nomeCompleto, endereco, telefone, especialidade);
        
        DentistaVO dentistaVO = new DentistaVO();

        dentistaVO.setCro(Integer.parseInt(cro));
        dentistaVO.setNomeCompleto(nomeCompleto);
        dentistaVO.setEndereco(endereco);
        dentistaVO.setEspecialidade(especialidade);
        dentistaVO.setTelefone(telefone);

        DentistaDAO dentistaDAO = new DentistaDAO(dentistaVO);

        dentistaDAO.cadastrar();

    }


    private void validarCamposObrigatorios(String cro, String nomeCompleto, String endereco, String telefone, String especialidade) throws ValidacaoException {
        
        try{
            int cCro = Integer.parseInt(cro);
        }catch(NumberFormatException nfe){
            throw new ValidacaoException("Digite um valor para o Cro.");
        }
        
        if(nomeCompleto.isEmpty())
            throw new ValidacaoException("Digite um nome.");
        if(endereco.isEmpty())
            throw new ValidacaoException("Digite um endereco.");
        if(telefone.isEmpty())
            throw new ValidacaoException("Digite um valor para telefone.");
        if(especialidade.isEmpty())
            throw new ValidacaoException("Digite uma especialidade.");
            
        
    }

}
