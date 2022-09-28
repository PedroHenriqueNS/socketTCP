package com.mycompany.sockettcp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pedro
 */
public class Servidor {
    
    static ServerSocket serverSocket;
    static Socket clientSocket;
    
    public Servidor() {
        try {
            serverSocket = new ServerSocket(9600);
            System.out.println("Criando o Server Socket...");
        } catch (Exception e) {
            System.out.println("Não foi criado o Server Socket.\nCódigo do erro: " + e);
        }
    }
    
    public static Pessoa receive(Socket socket) throws Exception {
        InputStream in;
        byte[] buffer = new byte[1024];
        Pessoa pessoa;
        try {
            in = socket.getInputStream();
            in.read(buffer);
            final ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            final ObjectInputStream ois = new ObjectInputStream(bais);
            Object returned = ois.readObject();
            pessoa = (Pessoa) returned;
            return pessoa;
            
        } catch (IOException e) {
            System.out.println("Excecao no InputStream: " + e);
        }
        return null;
    }
    
    public static void main(String args[]) throws Exception {
        new Servidor();
        Pessoa pessoa;
        
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                if (clientSocket.isConnected()) {
                    pessoa = receive(clientSocket);
                    System.out.println(pessoa);
                }
            } catch (IOException e) {
                System.out.println("Conexão mal sucedida.\nCódigo do erro: " + e);
            }
        }
    }
}
