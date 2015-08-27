package name.yumao.zhanqi.vo.response;

import java.io.Serializable;

public class ContentVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1662452897937324408L;
	private String cmdid;
	//chatmessage
	private String chatid;
	private String content;
	private String fromid;
	private String fromname;
	private String fromuid;
	private String intotallist;
	private String inweeklist;
	private String ip;
	private String level;
	private String permission;
	private String rank;
	private String showmedal;
	private String speakinroom;
	private Object style;
	private String time;
	private String toid;
	private String usexuanzi;
	
	public Object getStyle() {
		return style;
	}
	public void setStyle(Object style) {
		this.style = style;
	}
	public String getCmdid() {
		return cmdid;
	}
	public void setCmdid(String cmdid) {
		this.cmdid = cmdid;
	}
	public String getChatid() {
		return chatid;
	}
	public void setChatid(String chatid) {
		this.chatid = chatid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFromid() {
		return fromid;
	}
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}
	public String getFromname() {
		return fromname;
	}
	public void setFromname(String fromname) {
		this.fromname = fromname;
	}
	public String getFromuid() {
		return fromuid;
	}
	public void setFromuid(String fromuid) {
		this.fromuid = fromuid;
	}
	public String getIntotallist() {
		return intotallist;
	}
	public void setIntotallist(String intotallist) {
		this.intotallist = intotallist;
	}
	public String getInweeklist() {
		return inweeklist;
	}
	public void setInweeklist(String inweeklist) {
		this.inweeklist = inweeklist;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getShowmedal() {
		return showmedal;
	}
	public void setShowmedal(String showmedal) {
		this.showmedal = showmedal;
	}
	public String getSpeakinroom() {
		return speakinroom;
	}
	public void setSpeakinroom(String speakinroom) {
		this.speakinroom = speakinroom;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	public String getUsexuanzi() {
		return usexuanzi;
	}
	public void setUsexuanzi(String usexuanzi) {
		this.usexuanzi = usexuanzi;
	}
	
}
