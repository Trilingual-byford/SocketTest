import java.awt.Container;
import java.util.Vector;

import org.w3c.dom.css.CSSCharsetRule;

public class ChatManager{
	Vector<chatSocket> ve=new Vector<chatSocket>();
	private ChatManager(){}
	private static final ChatManager chatmanager=new ChatManager();

	public static ChatManager getChatmanager() {
		return chatmanager;
	}
	public void add(chatSocket cs){
		ve.add(cs);
	}
	public void publish(chatSocket cs,String out){
		for(int i=0;i<ve.size();i++){
		 chatSocket currentchatsocket=ve.get(i);
		 if(!currentchatsocket.equals(cs)) {
			 currentchatsocket.out(out);
		 }
		 
		}
		
	}
	


}
