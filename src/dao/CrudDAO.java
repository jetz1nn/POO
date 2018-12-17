package dao;

import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author matha
 */
public interface CrudDAO {
        
    public void cadastrar() throws IOException, ClassNotFoundException;
    
    public ArrayList buscar() throws IOException;
    
        
}
