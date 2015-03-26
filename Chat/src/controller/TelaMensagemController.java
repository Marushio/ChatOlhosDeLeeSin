package controller;

import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import model.MensagemDAO;
import view.TelaMensagem;

public class TelaMensagemController {
    MensagemDAO mensagemDAO;
    Mensagem mensagem;
    public TelaMensagemController() {
         
         mensagemDAO = new MensagemDAO();
    }
    
    
    public void btEnviar(Usuario usuario,String texto){
          mensagem = new Mensagem();
          mensagem.setDate(new java.sql.Date(new java.util.Date().getTime()));
          mensagem.setTexto(texto);
          mensagem.setUsuario(usuario);
        try{
          mensagemDAO.inserir(mensagem);
        }   
        catch(Exception e){
            String alerta = "Não foi possivel enviar a sua mensagem.\nProblema com a conexão";
            JOptionPane.showMessageDialog(null, alerta);
        }
    }
    public String atualizarMensagensTrocadas(){       
        try{   
           List mensagens = mensagemDAO.obterMensagens();         
           String corpoMensagens="";
           Iterator i = mensagens.iterator();
           while(i.hasNext()){
               Mensagem msg = (Mensagem) i.next();
                corpoMensagens += "\n" + msg.getUsuario().getLogin()+": " + msg.getTexto();
           }
           return corpoMensagens;
           
        }
        catch(Exception e){
            
            return "Não foi possivel atualizar.\n Problema com a conexão";
        }
       
      
    }
}
