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
    public TelaNewUserController() {
    }
    
    public void cadastrarNovoUsuario(String login, String senha) throws Exception{ 
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(usuarioDAO.obterUsuario(login).getLogin().matches(login))
            JOptionPane.showMessageDialog(null, "Usuario ja cadastrado");
        else{
            try{
                Usuario usuario = new Usuario();
                usuario.setLogin(login);
                usuario.setSenha(senha);
                usuarioDAO.InserirUsuario(usuario);                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario no Banco");
            }
        }        
    }
}
