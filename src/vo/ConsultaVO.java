/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import control.Data;
import control.Relogio;


//classe criada para a relacao dos 
/**
 *
 * @author matha
 */
public class ConsultaVO {
   
    private String nomePaciente;
    private String nomeDentista;
    private Relogio hora;
    private Data data;

    
    public ConsultaVO(){
    
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
     * @return the nomeDentista
     */
    public String getNomeDentista() {
        return nomeDentista;
    }

    /**
     * @param nomeDentista the nomeDentista to set
     */
    public void setNomeDentista(String nomeDentista) {
        this.nomeDentista = nomeDentista;
    }

    /**
     * @return the hora
     */
    public Relogio getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Relogio hora) {
        this.hora = hora;
    }

    /**
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Data data) {
        this.data = data;
    }
    
    
}
