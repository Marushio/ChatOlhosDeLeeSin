/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.Container;
import javax.swing.JOptionPane;
import model.UsuarioDAO;
import view.MeuMessenger;

/**
 *
 * @author a1320726
 */
public class TelaNickController {
    MeuMessenger meuMessenger;
    UsuarioDAO usuarioDAO;

    public TelaNickController() {
        this.meuMessenger = meuMessenger;
        usuarioDAO=new UsuarioDAO();
    }
    
    public Usuario logar(String login,String senha){      
        Usuario user=null;
        
       // boolean teste=false;
        try{
            
            user = usuarioDAO.obterUsuario(login);
           
            if(!user.getSenha().equals(senha))
            throw new Exception();
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null,"Login Inexistente ou senha errados","Erro",0);
            
   
        }
        return user;
    }
    
}
