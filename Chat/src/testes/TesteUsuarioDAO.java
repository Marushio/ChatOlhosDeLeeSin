package testes;

import controller.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UsuarioDAO;

/**
 * @author a1320548
 * Testa a inserção de um usuário
 */
public class TesteUsuarioDAO {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
    public TesteUsuarioDAO() {        
    }
    
    public void TesteUsuarioDAOInserir(){
        usuario.setLogin("Tester");
        usuario.setSenha("1234");
        try {
            usuarioDAO.InserirUsuario(usuario);
            System.out.println("Usuario inserido com sucesso/n");
        }
        catch (Exception ex) {
            System.out.println("O usuário não pode ser criado por causa do erro" + ex);
        }
    }
    
    public void TesteUsuarioDAOObter(){
        try {
            System.out.println("Usuario recuperado: " + usuarioDAO.obterUsuario("Tester"));
        }
        catch (Exception ex) {
            System.out.println("O usuário não pode ser recuperado por causa do erro" + ex);
        }        
    }

}
