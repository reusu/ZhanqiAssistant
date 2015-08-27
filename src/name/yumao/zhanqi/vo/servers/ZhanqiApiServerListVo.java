package name.yumao.zhanqi.vo.servers;

import java.io.Serializable;

public class ZhanqiApiServerListVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8943393686156234515L;
	private String ip;
	private String port;
	private String chatroom_id;
	private String 	id;
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
	public String getChatroom_id() {
		return chatroom_id;
	}
	public void setChatroom_id(String chatroom_id) {
		this.chatroom_id = chatroom_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
