import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

public class chatSocket extends Thread {
	Socket socket;

	public chatSocket(Socket s) {
		this.socket = s;
	}
	public void out(String out) {
		try {
			socket.getOutputStream().write(out.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
			//Writer writer=new OutputStreamWriter(socket.getOutputStream());
			//PrintWriter  bw=new PrintWriter (new OutputStreamWriter(socket.getOutputStream()) );
			//BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
				try {
					BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
				
					String line=null;
					while((line=br.readLine())!=null) {
						ChatManager.getChatmanager().publish(this, line);
					}
					
					br.close();
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
	
	}
	
}
