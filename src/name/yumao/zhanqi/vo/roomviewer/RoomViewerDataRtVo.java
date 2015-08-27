package name.yumao.zhanqi.vo.roomviewer;

import java.io.Serializable;

public class RoomViewerDataRtVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8706460506010537870L;
	private String init;
	private String session;
	private String redis;
	private String all;
	public String getInit() {
		return init;
	}
	public void setInit(String init) {
		this.init = init;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getRedis() {
		return redis;
	}
	public void setRedis(String redis) {
		this.redis = redis;
	}
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	
}
