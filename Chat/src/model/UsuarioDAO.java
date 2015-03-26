/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.Usuario;
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
        Usuario user = new Usuario();
        Connection con = ConnectionFactory.getFirebirdConnection();
        ResultSet rs = null;
        PreparedStatement psmt = null;
        String sql;
        try{
            psmt = con.prepareStatement("select * from usuario where login = '"+login+"'");
            rs = psmt.executeQuery();
            while(rs.next()) { 
            user.setLogin(rs.getString("login"));
            user.setSenha(rs.getString("senha"));
            }
        }finally{
            psmt.close();
            rs.close();
            con.close();
       }
    return user;
    }  
}
