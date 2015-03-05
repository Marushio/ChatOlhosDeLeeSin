/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author a1320726
 */
public class UsuarioDAO {
     public void InserirUsuario(Usuario user)throws Exception{
        Connection con = ConnectionFactory.getFirebirdConnection();
        PreparedStatement psmt = null;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("insert into usuario(login,senha)");
            sql.append("values(?,?)");
            psmt = con.prepareStatement(sql.toString());
            
            psmt.setString(1,user.getLogin());
            psmt.setString(2, user.getSenha());
            
            psmt.execute();            
        }
        finally{
            psmt.close();
            con.close();
        }
    }  
     public Usuario obterUsuario(String login)throws Exception{
       System.out.println("FOII");
        Usuario user=new Usuario();
        Connection con = ConnectionFactory.getFirebirdConnection();
        ResultSet rs = null;
        PreparedStatement psmt = null;
        StringBuffer sql = new StringBuffer();
        sql.append("select * from usuario");
        sql.append("where login = ? ");
        System.out.println(login);
        psmt.setString(1, login);
       
        
        
        try{
            psmt = con.prepareStatement(sql.toString());
            rs = psmt.executeQuery(); 
            user.setLogin(rs.getString("login"));
            user.setSenha(rs.getString("Senha"));
        }finally{
            psmt.close();
            rs.close();
            con.close();
       }
    return user;
    }  
}
