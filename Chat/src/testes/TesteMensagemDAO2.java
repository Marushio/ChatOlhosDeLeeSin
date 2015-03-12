/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testes;

import chat.Mensagem;
import chat.MensagemDAO;
import chat.Usuario;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author a1320548
 */
public class TesteMensagemDAO2 {

    public TesteMensagemDAO2() {
        /**Caso de teste 2**/
        /*Criar mais de um objeto do tipo mensagem, escrevê-la no banco de dados usando o método 
        MensagemDAO.InserirNovaMensagem(). Utilizar o método MensagemDAO.ObterMensagens
        para obter um eco das mensagens e compara-la com o objeto mensagem que foi enviado e se elas estão na ordem correta.
        Resultado esperado: Uma mensagem identica a enviada.*/
        Mensagem mensagem = new Mensagem();
        Usuario usuario= new Usuario();
        mensagem.setDate(Date.valueOf("2015-02-12"));
        mensagem.setTexto("Mensagem de teste");
        usuario.setLogin("Tester");
        
        mensagem.setUsuario(usuario);      
        MensagemDAO mensagemDAO = new MensagemDAO();
        
        try {
            mensagemDAO.Inserir(mensagem);
            mensagemDAO.Inserir(mensagem);
        } catch (Exception e) {
            System.out.println("Falha ao inserir mensagem.");
        }
        
        try {
            List mensagens = mensagemDAO.ObterMensagens();
            String historicoMensagens = new String();
            Iterator i = mensagens.iterator();
            while(i.hasNext()){
                Mensagem texto = (Mensagem) i.next();
               historicoMensagens += "\n" + texto.getUsuario().getLogin()+ " " + texto.getDate() + ": " + texto.getTexto();
            }
            System.out.println(historicoMensagens);
        } catch (Exception ex) {
            Logger.getLogger(TesteMensagemDAO1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha ao receber mensagem");
        }      
    }
}
