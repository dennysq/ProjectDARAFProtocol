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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SocketSession  extends Thread{

    private static Integer global=0;
    private PrintWriter output;
    private BufferedReader input;
    private Socket socket;
    
    private Integer id;
    
    public SocketSession(Socket socket) throws IOException{
               
        this.id=SocketSession.global++;    
        this.socket=socket;  
        input = new BufferedReader (new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
    }
            
    @Override
    public void run() {
        try{
            
            String userInput;
            
            while((userInput=input.readLine())!=null){
                System.out.println("Hilo: "+this.id+" Mensaje recibido: "+userInput);
                StringBuilder ab = new StringBuilder(userInput);
                output.write(ab.reverse().toString());
                output.flush();
                if("FIN".equalsIgnoreCase(userInput)){
                    break;
                }
                
            }
            socket.close();
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        } 
    }
    
}