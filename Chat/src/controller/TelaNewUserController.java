/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.swing.JOptionPane;
import model.UsuarioDAO;

/**
 *
 * @author a132067x
 */
public class TelaNewUserController {
    UsuarioDAO usuarioDAO;
    Usuario  usuario;
    
    public TelaNewUserController() {
        usuarioDAO = new UsuarioDAO();
        usuario=new Usuario();
    }
    
    public boolean cadastrarNovoUsuario(String login, String senha){ 
        usuario.setLogin(login);
        usuario.setSenha(senha);
       
        
        try{
           usuarioDAO.InserirUsuario(usuario);
           JOptionPane.showMessageDialog(null,"Usuario cadastrado com sucesso!","Usuario cadastrado",1);
           return true;
        }catch(Exception e){
                     JOptionPane.showMessageDialog(null,"Usuario ja cadastrado, Tente outro","Erro",0); 
                     return false;
        }
        
            
    }
}
