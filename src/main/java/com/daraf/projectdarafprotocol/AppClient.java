/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol;

import com.daraf.projectdarafprotocol.clienteapp.MensajeRQ;
import com.daraf.projectdarafprotocol.clienteapp.MensajeRS;
import com.sun.xml.internal.ws.resources.SenderMessages;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennys
 */
public class AppClient {

    private Socket socket;
    //private MensajeRQ messageRQ;
    //private MensajeRS messageRS;
    private PrintWriter output;
    private BufferedReader input;
    public static final String IPADDRESS = "127.0.0.1";
    public static final int PORT = 4001;

    public AppClient() {
//        socket = new Socket(IPADDRESS, PORT);
//        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        output = new PrintWriter(socket.getOutputStream(), true);
    }

    public MensajeRS sendRequest(MensajeRQ mensajeRQ) {

        String response = null;
        int attemps = 0;
        try {
            socket = new Socket(IPADDRESS, PORT);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            do {

                output.write(mensajeRQ.asTexto());
                output.flush();
                response = input.readLine();
                if (response != null) {
                    break;
                }
            } while (attemps <= 5);

            output.write("FIN");
            output.flush();
            socket.close();
            if (response != null) {
                MensajeRS mensajeRS = new MensajeRS();
                if (mensajeRS.build(response)) {
                    return mensajeRS;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AppClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
