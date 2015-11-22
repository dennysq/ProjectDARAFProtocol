/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.socket;

/**
 *
 * @author RAUL
 */
import java.net.ServerSocket;
import java.net.Socket;


public class Test {
    
    public static void main(String args[]){
        System.out.println("Servidor arriba");
        try{
            ServerSocket server = new ServerSocket(4420);
            while(true){
                Socket client = server.accept();
                new SocketSession(client).start();
                System.out.println("El cliente ha recibido una conexion");
                
            }         
            
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
