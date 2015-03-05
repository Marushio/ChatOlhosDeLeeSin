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
        mensagem.setDate(Date.valueOf("2015-03-01"));
        mensagem.setTexto("MOla mundo");
        mensagem.setNick("maru");
        MensagemDAO mensagemDAO = new MensagemDAO();
        try {
            mensagemDAO.Inserir(mensagem);
        } catch (Exception ex) {
            Logger.getLogger(Teste1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Falha no envio de mensagem");
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
