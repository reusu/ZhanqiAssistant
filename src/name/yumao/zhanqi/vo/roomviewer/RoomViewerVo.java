package name.yumao.zhanqi.vo.roomviewer;

import java.io.Serializable;

public class RoomViewerVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7749721127860452825L;
	private String code ;
	private String message;
	private RoomViewerDataVo data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public RoomViewerDataVo getData() {
		return data;
	}
	public void setData(RoomViewerDataVo data) {
		this.data = data;
	}
	
}
