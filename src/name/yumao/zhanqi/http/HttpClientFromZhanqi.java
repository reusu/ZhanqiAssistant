package name.yumao.zhanqi.http;


import name.yumao.zhanqi.utils.ServerUtils;
import name.yumao.zhanqi.vo.roomviewer.RoomViewerVo;
import name.yumao.zhanqi.vo.servers.ZhanqiApiServerVo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import sun.misc.BASE64Decoder;

public class HttpClientFromZhanqi {
	public static String QueryZhanqiRoomNum(String roomName){
		String roomNum = "";
		try{
			HttpGet get = new HttpGet("http://api.teemo.name/live/zhanqiApi.do?room="+roomName);
			get.setHeader("User-Agent", "ZhanqiAssistant");
			HttpResponse response = ThreadHttpClient.getInstance().getHttpclient().execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
			    HttpEntity entity = response.getEntity(); 
			    String htmlEntity = EntityUtils.toString(entity);
			    roomNum = ServerUtils.QueryRoomApi(htmlEntity).getId();
			}
			get.abort();
		}catch (Exception e) {
			return roomNum;
		}
		return roomNum;
	}
	public static ZhanqiApiServerVo QueryServer(String roomName) {
		ZhanqiApiServerVo zhanqiApiServerVo = null;
		BASE64Decoder b64d = new BASE64Decoder();
		String b64Servers = "";
		try{
			HttpGet get = new HttpGet("http://api.teemo.name/live/zhanqiApi.do?room="+roomName);
			get.setHeader("User-Agent", "ZhanqiAssistant");
			HttpResponse response = ThreadHttpClient.getInstance().getHttpclient().execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
			    HttpEntity entity = response.getEntity(); 
			    String htmlEntity = EntityUtils.toString(entity);
			    b64Servers = ServerUtils.QueryRoomApi(htmlEntity).getFlashvars().getServers();
			}
			get.abort();
			String servers = new String(b64d.decodeBuffer(b64Servers),"UTF-8");
			zhanqiApiServerVo = ServerUtils.QueryServer(servers);
		}catch (Exception e) {
			return zhanqiApiServerVo;
		}
		return zhanqiApiServerVo;
	}
	public static RoomViewerVo QuryZhanqiRoomViewer() {
		RoomViewerVo roomViewerVo = null;
		try{
			HttpGet get = new HttpGet("http://www.zhanqi.tv/api/public/room.viewer");
			HttpResponse response = ThreadHttpClient.getInstance().getHttpclient().execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
			    HttpEntity entity = response.getEntity(); 
			    String htmlEntity = EntityUtils.toString(entity);
			    roomViewerVo = ServerUtils.QuryZhanqiRoomViewer(htmlEntity);
			    
			}
			get.abort();
		}catch (Exception e) {
			return roomViewerVo;
		}
		return roomViewerVo;
	}
	public static String QueryZhanqiDownloadUrl(String roomName) {
		String downloadUrl = "";
		try{
			HttpGet get = new HttpGet("http://api.teemo.name/live/zhanqiApi.do?room="+roomName);
			get.setHeader("User-Agent", "ZhanqiAssistant");
			HttpResponse response = ThreadHttpClient.getInstance().getHttpclient().execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
			    HttpEntity entity = response.getEntity(); 
			    String htmlEntity = EntityUtils.toString(entity);
			    downloadUrl = 
			    		"http://wshdl.load.cdn.zhanqi.tv/zqlive/" + 
			    		ServerUtils.QueryRoomApi(htmlEntity).getVideoId() +
			    		".flv";
			}
			get.abort();
		}catch (Exception e) {
			return downloadUrl;
		}
		return downloadUrl;
	}

	public static String showAnnounce(){
		String announce = "";
		try{
			HttpGet get = new HttpGet("http://share.teemo.name/ZhanqiAssistant/Announce");
			HttpResponse response = ThreadHttpClient.getInstance().getHttpclient().execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
			    HttpEntity entity = response.getEntity(); 
			    String[] ans = EntityUtils.toString(entity).split("[|]");
			    announce = ans[(int)(Math.random()*ans.length)];
			}
			get.abort();
		}catch (Exception e) {
			announce = "公告获取失败";
		}
		return announce.trim();
	}


	
}
