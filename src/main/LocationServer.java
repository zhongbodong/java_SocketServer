package main;

import java.net.ServerSocket;
import java.net.Socket;

public class LocationServer {

    private ServerSocket serverSocket;
    private int port = 4600;

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Start,Port:" + port);
            System.out.println("Waiting Client Connecting...");

            while(true) {
                //方法会产生阻塞，直到某个Socket连接，返回请求连接的Socket
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client Connected!IP:" + clientSocket.getRemoteSocketAddress());

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //打印jdk的位数
        String bit = System.getProperty("sun.arch.data.model");
        System.out.println("JDK位数=" + bit);

        LocationServer server = new LocationServer();
        server.start();

		/*SqlHelper sqlHelper=new  SqlHelper();
		//sqlHelper.getSqlDriver();
		//sqlHelper.getConnection();
		int value=sqlHelper.Insert("");
		if (value>0)
		{
			System.out.println("插入数据成功");
		}
		else{
			System.out.println("插入数据失败");
		}*/

    }
}
