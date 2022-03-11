package com.xiaoqu;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 自定义服务器
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8080);// 监听指定端口
            System.out.println("server is running...");
            while (true){
                Socket socket = ss.accept();
                System.out.println("connected from" + socket.getRemoteSocketAddress());
                Thread thread = new MyThread(socket);
                thread.start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{
    Socket socket;

    public MyThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream inputStream = this.socket.getInputStream()){
            try(final OutputStream outputStream = this.socket.getOutputStream()){
                handle(inputStream,outputStream);
            }
        } catch (Exception e){
            try {
                this.socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("client disconnected.");
        }
    }

    public void handle(InputStream inputStream,OutputStream outputStream){
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream,StandardCharsets.UTF_8));

        try {
            //读取HTTP请求
            boolean requestOk = false;
            String s = reader.readLine();
            if (s.startsWith("GET / HTTP/1.")) {
                requestOk = true;
            }
            for (;;){
                String header = reader.readLine();
                if (header.isEmpty()){
                    break;
                }
                System.out.println(header);
            }
            System.out.println(requestOk ? "Response OK" : "Response Error");

            if (!requestOk){
                //发送错误响应：
                writer.write("HTTP/1.0 404 Not Found\r\n");
                writer.write("Content-Length: 0\r\n");
                writer.write("\r\n");
                writer.flush();
            } else {
                //发送成功响应

                //读取html文件，转换为字符串
                BufferedReader br = new BufferedReader(new FileReader("http/html/a.html"));
                StringBuilder data = new StringBuilder();
                String line = null;
                while ((line=br.readLine())!=null){
                    data.append(line);
                }
                br.close();
                int length = data.toString().getBytes(StandardCharsets.UTF_8).length;
                writer.write("HTTP/1.1 200 OK\r\n");
                writer.write("Connection: keep-alive\r\n");
                writer.write("Content-Type: text/html\r\n");
                writer.write("\r\n"); // 空行标识Header和Body分隔
                writer.write(data.toString());
                writer.flush();


            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}



