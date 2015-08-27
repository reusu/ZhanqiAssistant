package name.yumao.zhanqi.vo.request;

import java.io.Serializable;

public class ZhanqiGetUCRequestVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5972953600550131496L;
	private String vod;
	private String cmdid;
	private String roomid;
	public String getVod() {
		return vod;
	}
	public void setVod(String vod) {
		this.vod = vod;
	}
	public String getCmdid() {
		return cmdid;
	}
	public void setCmdid(String cmdid) {
		this.cmdid = cmdid;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
}
