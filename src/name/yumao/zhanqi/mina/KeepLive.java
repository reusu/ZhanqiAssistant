package name.yumao.zhanqi.mina;

import org.apache.mina.core.session.IoSession;

public class KeepLive implements Runnable { 
    private IoSession session; 
    public KeepLive(IoSession session) { 
        this.session = session; 
    } 
    public void run() { 
    	while(true){
	    	session.write("bb:cc:00:00:00:00:00:00:00:00:59:27".replaceAll(":", ""));
	    	try {
	    		Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	} 
    }
}