package tk.mybatis.springboot.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public static final int port = 1234;
    public static final String host = "106.15.58.63";

    public static String sentData(String inputStr) {
        String output = "";
        System.out.println("Client Start...");
        Socket socket = null;
        try {
            socket = new Socket(host,port);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println(inputStr);

            String ret = input.readLine();
            System.out.println("server response: " + ret);
            output=ret;

            out.close();
            input.close();
        } catch (Exception e) {
            System.out.println("client exception:" + e.getMessage());
            output = "wrong";
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    socket = null;
                    System.out.println("client finally exception:" + e.getMessage());
                    output = "finally wrong";
                }
            }
        }
        return output;
    }
}
