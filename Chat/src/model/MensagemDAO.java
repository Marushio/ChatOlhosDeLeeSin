/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.Mensagem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author a1320726
 */
public class MensagemDAO {
    private UsuarioDAO usuarioDAO;
    public void inserir(Mensagem mensagem)throws Exception{
        Connection con = ConnectionFactory.getFirebirdConnection();
        PreparedStatement psmt = null;
        try{
            
            StringBuffer sql = new StringBuffer();
            sql.append("insert into mensagem (data, texto, nick)");
            sql.append("values(?,?,?)");
            psmt = con.prepareStatement(sql.toString());
            Date dataSQL = new Date(mensagem.getDate().getTime());
            psmt.setDate(1, dataSQL);
            psmt.setString(2, mensagem.getTexto());
            psmt.setString(3, mensagem.getUsuario().getLogin());
            psmt.execute();            
        }
        finally{
            psmt.close();
            con.close();
        }
    }    
    public ArrayList obterMensagens()throws Exception{
        Connection con = ConnectionFactory.getFirebirdConnection();
        ResultSet rs = null;
        PreparedStatement psmt = null;
        String sql = "select * from Mensagem";
        ArrayList mensagens = new ArrayList(); 
        usuarioDAO = new UsuarioDAO();
        try{
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            Mensagem mensagem = null;
            while(rs.next()){
                mensagem =  new Mensagem();
                mensagem.setDate(rs.getDate("data"));
                try{
                    mensagem.setUsuario(usuarioDAO.obterUsuario(rs.getString("nick")));
                }catch(Exception e){
                    System.out.println("Erro ao buscar usuaario");
                }
                mensagem.setTexto(rs.getString("texto"));
                mensagens.add(mensagem);
            }
        }finally{
            psmt.close();
            rs.close();
            con.close();
       }
    return mensagens;
    }        
    
}
