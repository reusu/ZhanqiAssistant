package name.yumao.zhanqi.vo.response;

import java.io.Serializable;
import java.util.List;

public class LoginResponseVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3245127178206437182L;
	private String cmdid;
	//loginresp
	private List<LoginResponseDataVo> data;
	private String nickname;
	private String result;
	public String getCmdid() {
		return cmdid;
	}
	public void setCmdid(String cmdid) {
		this.cmdid = cmdid;
	}
	public List<LoginResponseDataVo> getData() {
		return data;
	}
	public void setData(List<LoginResponseDataVo> data) {
		this.data = data;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
