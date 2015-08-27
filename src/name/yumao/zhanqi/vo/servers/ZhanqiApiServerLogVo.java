package name.yumao.zhanqi.vo.servers;

import java.io.Serializable;

public class ZhanqiApiServerLogVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2208558102448584140L;
	private String ip;
	private String port;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
}
