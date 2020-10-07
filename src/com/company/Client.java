package com.company;

import java.io.*;
import java.net.Socket;

public class Client {


    public void client(){
    //String serverName = "10.111.176.36"; // 10.111.176.36
    String serverName = "94.18.243.144";
    int port = Integer.parseInt("48880");

    try {
        System.out.println("Connecting to " + serverName + " på port " + port);
        Socket client = new Socket(serverName, port);


        System.out.println("Connected til " + client.getRemoteSocketAddress());
        OutputStream toServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(toServer);

        out.writeUTF("Hello fra " + client.getLocalSocketAddress());
        InputStream inFromServer = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);

        System.out.println("Server :" + in.readUTF());
        client.close();

    }
    catch (IOException e) {
        e.printStackTrace();
    }

}
}