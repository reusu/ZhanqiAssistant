package name.teemo.api.vo.live.zhanqi;

import java.io.Serializable;

public class ZhanqiApiFlashvarsVo implements Serializable{
	private static final long serialVersionUID = 6021126099165912756L;
	private String Servers;
	private String cdns;
	private String Status;
	private String RoomId;
	private boolean ComLayer;
	private String VideoTitle;
	private String WebHost;
	private String VideoType;
	private String GameId;
	private String SgsGift;
	private String CityCtrl;
	private String logoPos;
	public String getServers() {
		return Servers;
	}
	public void setServers(String servers) {
		Servers = servers;
	}
	public String getCdns() {
		return cdns;
	}
	public void setCdns(String cdns) {
		this.cdns = cdns;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getRoomId() {
		return RoomId;
	}
	public void setRoomId(String roomId) {
		RoomId = roomId;
	}
	public boolean isComLayer() {
		return ComLayer;
	}
	public void setComLayer(boolean comLayer) {
		ComLayer = comLayer;
	}
	public String getVideoTitle() {
		return VideoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		VideoTitle = videoTitle;
	}
	public String getWebHost() {
		return WebHost;
	}
	public void setWebHost(String webHost) {
		WebHost = webHost;
	}
	public String getVideoType() {
		return VideoType;
	}
	public void setVideoType(String videoType) {
		VideoType = videoType;
	}
	public String getGameId() {
		return GameId;
	}
	public void setGameId(String gameId) {
		GameId = gameId;
	}
	public String getSgsGift() {
		return SgsGift;
	}
	public void setSgsGift(String sgsGift) {
		SgsGift = sgsGift;
	}
	public String getCityCtrl() {
		return CityCtrl;
	}
	public void setCityCtrl(String cityCtrl) {
		CityCtrl = cityCtrl;
	}
	public String getLogoPos() {
		return logoPos;
	}
	public void setLogoPos(String logoPos) {
		this.logoPos = logoPos;
	}
	
}
