/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;
import controller.TelaNickController;
import controller.Usuario;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.UsuarioDAO;

/**
 *
 * @author a132067x
 */
public class TelaNick extends javax.swing.JPanel {

    
    TelaNickController telaNickControl;
   
    MeuMessenger meuMessenger;
    
    public TelaNick(MeuMessenger meuMessenger) {
        initComponents();
        
        this.meuMessenger=meuMessenger;
        telaNickControl = new TelaNickController();
        
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        btLogar = new javax.swing.JButton();
        tfNick = new javax.swing.JTextField();
        lbNick = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();
        NovoUsuario = new javax.swing.JButton();

        lbTitulo.setText("Tela de Login");

        btLogar.setText("Logar");
        btLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogarActionPerformed(evt);
            }
        });

        tfNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNickActionPerformed(evt);
            }
        });
        tfNick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNickKeyPressed(evt);
            }
        });

        lbNick.setText("Nick.:");

        jLabel1.setText("Senha:");

        pfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfSenhaKeyPressed(evt);
            }
        });

        NovoUsuario.setText("NovoUsuario");
        NovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNick)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(NovoUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btLogar))
                            .addComponent(tfNick, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pfSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(lbTitulo)))
                .addGap(114, 126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbNick))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLogar)
                    .addComponent(NovoUsuario))
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogarActionPerformed
        
       
       
       System.out.println("FOI AQUI 1");
       try{
            Usuario usuario;
            usuario=telaNickControl.logar(tfNick.getText(),pfSenha.getText());
            if(usuario!=null){
                meuMessenger.setUsuario(usuario);
                Container janela = this.getParent();
                janela.remove(this); 
                janela.revalidate();
                janela.repaint();
        }
         tfNick.setText("");
         pfSenha.setText("");
       // telaMensagem.show(true);
       }catch(NullPointerException e){
               System.out.println("nao FOI AQUI 2");
                 }
                 
        
    }//GEN-LAST:event_btLogarActionPerformed
 
    private void tfNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNickActionPerformed

    private void NovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoUsuarioActionPerformed
        JFrame newuser = new NewUser();
        newuser.show();
    }//GEN-LAST:event_NovoUsuarioActionPerformed

    private void tfNickKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNickKeyPressed
        if (evt.getKeyChar() == '\n') {
            btLogarActionPerformed(new ActionEvent(this, 0, ""));
        }
    }//GEN-LAST:event_tfNickKeyPressed

    private void pfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfSenhaKeyPressed
        
           if (evt.getKeyChar() == '\n') {
            btLogarActionPerformed(new ActionEvent(this, 0, ""));
        }
    
    }//GEN-LAST:event_pfSenhaKeyPressed
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NovoUsuario;
    private javax.swing.JButton btLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbNick;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfNick;
    // End of variables declaration//GEN-END:variables

    

   
   
}
