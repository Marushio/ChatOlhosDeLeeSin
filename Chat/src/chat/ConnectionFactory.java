/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author a1320769
 */
public class ConnectionFactory {
    static Connection getFirebirdConnection() {
        
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.29:5432/chat2","postgres","");
        }catch(Exception e){
           e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados");
        }
        return connection;
    }
    
}
    

