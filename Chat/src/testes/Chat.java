package testes;
/**
 *
 * @author a1320548
 */
public class Chat {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        TesteUsuarioDAO testeUsuarioDAO = new TesteUsuarioDAO();
        TesteMensagemDAO1 teste1 = new TesteMensagemDAO1();
        TesteMensagemDAO2 teste2 = new TesteMensagemDAO2();
        System.out.println("Teste de inserção de usuário.");
        testeUsuarioDAO.TesteUsuarioDAOInserir();
        System.out.println("Teste de recuperação de usuário.");
        testeUsuarioDAO.TesteUsuarioDAOObter();
        System.out.print("Teste de envio de mensagem.");
        System.out.print("\nTeste de envio de mensagem composta.");
        
    }
}
