import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class SocketListener extends Thread {
	@Override
	public void run() {
		Socket so;
		try {
			ServerSocket socket=new ServerSocket(1238);
			while (true) {
				so=socket.accept();
				chatSocket sc=new chatSocket(so);
				sc.start();
				ChatManager.getChatmanager().add(sc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
