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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    
    public static void main(String args[]){
        System.out.println("Servidor arriba");
        try{
            ServerSocket server = new ServerSocket(4420);
            Socket client = server.accept();
            System.out.println("El cliente ha recibido una conexion");
            BufferedReader input = new BufferedReader (new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            String userInput;
            
            while((userInput=input.readLine())!=null){
                System.out.println("Mensaje: "+output);
                StringBuilder ab = new StringBuilder(userInput);
                output.write(ab.reverse().toString());
                output.flush();
                if("FIN".equalsIgnoreCase(userInput)){
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
