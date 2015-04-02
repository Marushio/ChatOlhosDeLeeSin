package controller;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author DiógenesGalileu
 */
public class Servidor {
    public static void main (String args[]) throws IOException{
        ServerSocket servidor = new ServerSocket(32770);
        System.out.println("Porta 12345 aberta!");        
        
    }
}
