/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @DiogenesGalileu
 */
public class Teste1 {

    /**Caso de teste 1**/
    /*Criar um objeto do tipo mensagem, escrevê-la no banco de dados usando o metodo
    MensagemDAO.InserirNovaMensagem(). Utilizar o método MensagemDAO.ObterMensagens
    para obter um eco da mensagem e compara-la com o objeto mensagem que foi enviado
    Resultado esperado: Uma mensagem identica a enviada.*/
    public Teste1() {
        Mensagem mensagem = new Mensagem();
        
        Usuario user2 = new Usuario();
      
        
       // user2.setLogin("Maru");
        //user2.setSenha("123");
        
        mensagem.setDate(Date.valueOf("2015-02-12"));
        mensagem.setTexto("Mensagem de teste");
        mensagem.setNick("Tester");
        
        MensagemDAO mensagemDAO = new MensagemDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            System.out.println("foi ate aqui1 ");
            user2 = usuarioDAO.obterUsuario("Maru");
            System.out.println("foi ate aqui 2");
            System.out.println(user2.getLogin());
            
            
        } catch ( NullPointerException e) {
            
            JOptionPane.showMessageDialog(null," cadastro dse user");
        
        } catch ( Exception ex) {
            
            JOptionPane.showMessageDialog(null," cadastro dse user");
        }
        try {
            List mensagens = mensagemDAO.ObterMensagens();
            String historicoMensagens = new String();
            Iterator i = mensagens.iterator();
            while(i.hasNext()){
                Mensagem texto = (Mensagem) i.next();
                historicoMensagens += "\n" + texto.getNick() + " " + texto.getDate() + ": " + texto.getTexto();
            }
            System.out.println(historicoMensagens);
        } catch (Exception ex) {
            Logger.getLogger(Teste1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha ao receber mensagem");
        }
    }    
}