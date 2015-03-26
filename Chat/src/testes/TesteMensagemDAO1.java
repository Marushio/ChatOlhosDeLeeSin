package testes;

import controller.Mensagem;
import controller.Usuario;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.MensagemDAO;

/**
 * @DiogenesGalileu
 */
public class TesteMensagemDAO1 {

    /**Caso de teste 1**/
    /*Criar um objeto do tipo mensagem, escrevê-la no banco de dados usando o metodo MensagemDAO.InserirNovaMensagem().
    Utilizar o método MensagemDAO.ObterMensagens para obter um eco da mensagem e compara-la com o objeto mensagem que foi enviado.
    Resultado esperado: Uma mensagem identica a enviada.*/
    public TesteMensagemDAO1() {
        Mensagem mensagem = new Mensagem();
        Usuario usuario= new Usuario();
        TesteUsuarioDAO testeUsuarioDAO = new TesteUsuarioDAO();
         
        mensagem.setDate(Date.valueOf("2015-02-12"));
        mensagem.setTexto("Mensagem de teste");
        usuario.setLogin("Tester");
        MensagemDAO mensagemDAO = new MensagemDAO();
        
        try {
            mensagemDAO.inserir(mensagem);
        } catch (Exception e) {
            System.out.println("Falha ao inserir mensagem.");
        }
        
        try {
            List mensagens = mensagemDAO.obterMensagens();
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