/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

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
    public void Inserir(Mensagem mensagem)throws Exception{
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
            psmt.setString(3, mensagem.getNick());
            psmt.execute();            
        }
        finally{
            psmt.close();
            con.close();
        }
    }    
    public ArrayList ObterMensagens()throws Exception{
        Connection con = ConnectionFactory.getFirebirdConnection();
        ResultSet rs = null;
        PreparedStatement psmt = null;
        String sql = "select * from Mensagem";
        ArrayList mensagens = new ArrayList(); 
        
        try{
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            Mensagem mensagem = null;
            while(rs.next()){
                mensagem =  new Mensagem();
                mensagem.setDate(rs.getDate("data"));
                mensagem.setNick(rs.getString("nick"));
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
