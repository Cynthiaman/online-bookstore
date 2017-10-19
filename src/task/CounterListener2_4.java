package task;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CounterListener2_4 implements HttpSessionListener{
	private static long onlineNumber=0;
	public static long getOnlineNumber(){
		return onlineNumber;
	}
	public void sessionCreated(HttpSessionEvent se){
		onlineNumber++;
	}
	
	public void sessionDestroyed(HttpSessionEvent se){
		onlineNumber--;
	}

}
