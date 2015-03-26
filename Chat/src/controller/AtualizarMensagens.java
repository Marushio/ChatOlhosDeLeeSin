/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import view.TelaMensagem;

/**
 *
 * @author a1320726
 */
public class AtualizarMensagens implements Runnable{
    private TelaMensagem tela;

    public AtualizarMensagens(TelaMensagem tela) {
        this.tela = tela;
    }

    public void run() {
        try{
            while(true){
                tela.atualizarMensagensTrocadas();
                Thread.sleep(2000);
            }
        }catch(InterruptedException e){
            
        }
        
    }
    
}
