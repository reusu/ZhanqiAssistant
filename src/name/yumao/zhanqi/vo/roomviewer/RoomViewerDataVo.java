package name.yumao.zhanqi.vo.roomviewer;

import java.io.Serializable;

public class RoomViewerDataVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5181733512859947779L;
	private String uid;
	private String gid;
	private String sid;
	private String timestamp;
	private RoomViewerDataPropVo prop;
	private String canPM;
	private String isFollow;
	private RoomViewerDataRtVo rt;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public RoomViewerDataPropVo getProp() {
		return prop;
	}
	public void setProp(RoomViewerDataPropVo prop) {
		this.prop = prop;
	}
	public String getCanPM() {
		return canPM;
	}
	public void setCanPM(String canPM) {
		this.canPM = canPM;
	}
	public String getIsFollow() {
		return isFollow;
	}
	public void setIsFollow(String isFollow) {
		this.isFollow = isFollow;
	}
	public RoomViewerDataRtVo getRt() {
		return rt;
	}
	public void setRt(RoomViewerDataRtVo rt) {
		this.rt = rt;
	}
	
}
