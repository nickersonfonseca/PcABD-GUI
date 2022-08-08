/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class conexao {
    
    public static Connection getConnection(){
        
        Connection conexao = null;
        try {
          Class.forName("com.mysql.jdbc.Driver");
          conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro",
                  "root","");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conexao;
    }
}
