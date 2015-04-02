/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
* CREATE TABLE usuario(
*   login varchar(20) PRIMARY KEY,
*   senha varchar(20) NOT NULL
* )
* 
* CREATE TABLE mensagem (
*   data date,
*   texto varchar(50),
*   nick varchar(20)
* )
   
select * from mensagem
insert into mensagem values('2001-01-01','testee','Marushio');

 *
 * @author a1320769
 */
public class ConnectionFactory {
    
    private static Connection con;

    private ConnectionFactory() {
        if(con == null){
            try {            
                String url="jdbc:mysql://192.168.1.28:3306/chat";
                String usuario="root";            
                //String url="jdbc:postgresql://localhost:5432/chat";
                //String usuario="postgres";
                String senha="";            
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(url,usuario,senha);            
            }
            catch(Exception e){
               e.printStackTrace();
               JOptionPane.showMessageDialog(null,"Erro ao conectar com o banco de dados");
            }
        }
        
    }
    
    public static Connection getFirebirdConnection() {        
        return con;
    }
    
}
    

