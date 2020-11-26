package ru.geekbrains.q2.netAppConsol;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerConsol {

        public static void main(String[] args) {
            Socket socket = null;
            try (ServerSocket serverSocket = new ServerSocket(8190)) {
                System.out.println("Сервер запущен, ожидаем подключения...");
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");

                Scanner sc = new Scanner(System.in);
                System.out.println("->: ");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    String str = in.readUTF();
                    if (str.equals("/end")) {
                        break;
                    }
                    out.writeUTF("Эхо: " + str);
                    String msgInput = sc.nextLine();
                    // Если введен текст
                    if (!msgInput.trim().isEmpty()) {
                        // И получен признак завершения работы то закрываем консоль
                        if (msgInput.trim().equalsIgnoreCase("/end")) {
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
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
