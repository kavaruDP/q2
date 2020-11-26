package ru.geekbrains.q2.netAppConsol;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientConsol {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8190;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public EchoClientConsol() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prepareConsol();
    }

    private void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        System.out.println(strFromServer);
                        System.out.println("\n");
                        //System.out.println("->");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepareConsol() {
        Scanner sc = new Scanner(System.in);
        System.out.println("->: ");

        //Ожидаем ввода в консоль
        while (true) {

            String msgInput = sc.nextLine();

            // Если введен текст
            if (!msgInput.trim().isEmpty()) {
                // И получен признак завершения работы то закрываем консоль
                if (msgInput.trim().equalsIgnoreCase("/end")) {
                    closeConnection();
                    sc.close();
                    break;
                }
                // в противном случае отправляем сообщение на сервер и ждем дальше
                try {
                    out.writeUTF(msgInput);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // в противном случае просто ждем дальше
        }
    }

    public static void main(String[] args) {
        new EchoClientConsol();
    }
}
