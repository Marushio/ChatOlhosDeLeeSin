package controller;

import javax.swing.JOptionPane;
import model.MensagemDAO;
import view.TelaMensagem;

public class TelaMensagemController {
    MensagemDAO mensagemDAO;
    public TelaMensagemController() {
         mensagemDAO = new MensagemDAO();
    }
    
    
    public void btEnviar(Usuario usuario,String texto){
          String nick = usuario.getLogin(); 
        try{
                   
          TelaMensagem.Mensagem mensagem = new TelaMensagem.Mensagem();
          mensagem.setDate(new java.sql.Date(new java.util.Date().getTime()));
          mensagem.setTexto(texto);
          mensagem.setUsuario(MeuMessenger.usuario);
          
          mensagemDAO.Inserir(mensagem);
          this.atualizarMensagensTrocadas();
        }
        
        catch(Exception e){
            String alerta = "Não foi possivel enviar a sua mensagem.\nProblema com a conexão";
            JOptionPane.showMessageDialog(null, alerta);
        }
}

}
