package name.yumao.zhanqi.vo.response;

import java.io.Serializable;

public class ContentGiftVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1262909154189830118L;
	private String cmdid;
	private ContentGiftDataVo data;
	public String getCmdid() {
		return cmdid;
	}
	public void setCmdid(String cmdid) {
		this.cmdid = cmdid;
	}
	public ContentGiftDataVo getData() {
		return data;
	}
	public void setData(ContentGiftDataVo data) {
		this.data = data;
	}
	
}
