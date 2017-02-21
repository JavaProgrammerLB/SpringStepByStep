package com.yitianyigexiangfa.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liubei on 2017/2/21.
 */
public abstract class JavaSocketServer {
    public void server(int portNumber)throws IOException{
        ServerSocket serverSocket = new ServerSocket(portNumber);//1
        Socket clientSocket = serverSocket.accept();             //2
        BufferedReader in = new BufferedReader(                     //3
                new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        while ((request = in.readLine()) != null) {                 //4
            if ("Done".equals(request)) {                         //5
                break;
            }
        }
        response = processRequest(request);                        //6
        out.println(response);                                    //7
    }                                                        //8
    protected abstract String processRequest(String request);
}
