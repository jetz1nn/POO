/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ConsultaDAO;
import java.io.IOException;
import java.util.ArrayList;
import vo.ConsultaVO;

/**
 *
 * @author matha
 */
public class ConsultaControl implements CrudControl {
    
    private String nomePaciente;
    private String nomeDentista;
    private Relogio hora;
    private Data data;
    
    public ConsultaControl(){
    }
    
    public ArrayList buscar(String nomeDentista) {
        
    }
    
    
    
    public void cadastrar(String nomePaciente, String nomeDentista, String hora, String data) throws IOException, ClassNotFoundException, ValidacaoException{
        this.validarCamposObrigatorios(nomePaciente, nomeDentista, hora, data);
        Data date = new Data();
        Relogio horario = new Relogio();
        date.setAno(Integer.parseInt(data.substring(6)));
        date.setDia(Integer.parseInt(data.substring(0,2)));
        date.setMes(Integer.parseInt(data.substring(3,5)));
        horario.setHora(Integer.parseInt(hora.substring(0,2)));
        horario.setMinutos(Integer.parseInt(hora.substring(3)));
        
        ConsultaVO consultaVO = new ConsultaVO();
        consultaVO.setNomeDentista(nomeDentista);
        consultaVO.setData(date);
        consultaVO.setNomePaciente(nomePaciente);
        consultaVO.setHora(horario);
        
        ConsultaDAO consultaDAO = new ConsultaDAO(consultaVO);
        consultaDAO.cadastrar();
        
    }
    
    public void validarCamposObrigatorios(String nomePaciente, String nomeDentista, String hora, String data) throws ValidacaoException{
        try{
            int hour = Integer.parseInt(hora.substring(0, 2));
            int minuto = Integer.parseInt(hora.substring(3));
            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(3,5));
            int ano = Integer.parseInt(data.substring(6,10));
            
            if (ano != 2018 || ano < 2018)
                throw new ValidacaoException("Digite um ano válido, nao temos maquina do tempo.");
            if (dia > 31 && dia < 1) 
                throw new ValidacaoException("Digite um dia valido.");
            if (mes > 12 && mes < 1)
                throw new ValidacaoException("Digite um mes valido.");
            if (hour >23 || hour < 0)
                throw new ValidacaoException("Digite um horario na forma HH:MM");
            if (minuto > 59 || minuto < 0)
                throw new ValidacaoException("Digite um horario na forma HH:MM");

        }catch(NumberFormatException nfe){
            
        }
        
            if(nomePaciente.isEmpty())
                throw new ValidacaoException("Selecione um paciente.");
            if(nomeDentista.isEmpty())
                throw new ValidacaoException("Selecione um dentista.");
            if(hora.isEmpty())
                throw new ValidacaoException("Digite um horario no formato HH:MM.");
            if(data.isEmpty())
                throw new ValidacaoException("Digite uma data no formato DD/MM/YYYY");
                
    }
}
