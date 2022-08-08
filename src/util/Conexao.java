/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nickerson
 */
public class Conexao {
    
    public static Connection getConnection(){
        
        Connection conn=null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            // conexão com SERVIDOR
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aulas", 
                    "root", "");
            
        } catch (Exception e){
          
            e.printStackTrace();
            conn = null;
            
        } 
        return conn;
    }
}
