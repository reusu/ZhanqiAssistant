package name.yumao.zhanqi.vo.response;

import java.io.Serializable;

public class LoginResponseDataVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5088200005287204154L;
	private String avatar;
	private String gid;
	private String ip;
	private String mute;
	private String nickname;
	private String permission;
	private String sex;
	private String uid;
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMute() {
		return mute;
	}
	public void setMute(String mute) {
		this.mute = mute;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
}
