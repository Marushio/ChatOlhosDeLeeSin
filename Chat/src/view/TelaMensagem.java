/*
 * 
 */

package view;

//import static java.util.Collections.list;
//import java.util.Date;
import controller.AtualizarMensagens;
import controller.Mensagem;
import controller.TelaMensagemController;
import controller.Usuario;
import java.awt.event.ActionEvent;


import java.util.Timer;
//import java.util.TimerTask;
//import javax.swing.JFrame;


//import javax.swing.JPanel;
////import javax.swing.JScrollPane;

/**
 *
 * @author a132067x
 */
public class TelaMensagem extends javax.swing.JPanel {
   // private int delay = 2000;
   // private int interval = 1000;       
    Timer timer;
    TelaMensagemController telaControlrer;
    Mensagem mensagem;
    MeuMessenger meuMessenger;
    public TelaMensagem(MeuMessenger meuMessenger) {
        this.meuMessenger= meuMessenger;
        mensagem = new Mensagem();
        timer=new Timer();
        telaControlrer = new TelaMensagemController();
        initComponents();
        Thread atualizar = new Thread ( new AtualizarMensagens(this));
        atualizar.start();
        /*timer.scheduleAtFixedRate(new TimerTask(){    
        
        public void run(){
            atualizarMensagensTrocadas();
           }
         },delay,interval);
         */      
          
    } 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfTexto = new javax.swing.JTextField();
        btEnviar = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();
        spMensagem = new javax.swing.JScrollPane();
        taMensagem = new javax.swing.JTextArea();

        tfTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTextoKeyPressed(evt);
            }
        });

        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        lbTitulo.setText("Tela de Mensagem");

        taMensagem.setEditable(false);
        taMensagem.setColumns(20);
        taMensagem.setRows(5);
        spMensagem.setViewportView(taMensagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                            .addComponent(tfTexto))
                        .addGap(13, 13, 13)
                        .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(lbTitulo)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed

        telaControlrer.btEnviar(meuMessenger.getUsuario(),tfTexto.getText());
        this.atualizarMensagensTrocadas();
        tfTexto.setText("");
    }//GEN-LAST:event_btEnviarActionPerformed

    private void tfTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTextoKeyPressed
        if (evt.getKeyChar() == '\n') {
            btEnviarActionPerformed(new ActionEvent(this, 0, ""));
        }
    }//GEN-LAST:event_tfTextoKeyPressed
    
    public void atualizarMensagensTrocadas(){
        taMensagem.setText(telaControlrer.atualizarMensagensTrocadas());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnviar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JScrollPane spMensagem;
    private javax.swing.JTextArea taMensagem;
    private javax.swing.JTextField tfTexto;
    // End of variables declaration//GEN-END:variables

   
}
