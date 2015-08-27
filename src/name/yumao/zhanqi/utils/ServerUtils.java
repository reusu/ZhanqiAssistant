package name.yumao.zhanqi.utils;

import com.google.gson.Gson;

import name.teemo.api.vo.live.zhanqi.ZhanqiApiVo;
import name.yumao.zhanqi.vo.response.ContentGiftVo;
import name.yumao.zhanqi.vo.response.ContentVo;
import name.yumao.zhanqi.vo.response.LoginResponseVo;
import name.yumao.zhanqi.vo.roomviewer.RoomViewerVo;
import name.yumao.zhanqi.vo.servers.ZhanqiApiServerVo;

public class ServerUtils {
	public static ZhanqiApiVo QueryRoomApi(String roomApiStr) throws Exception{
		byte[] obj = HexUtils.hexString2Bytes(roomApiStr);
		byte[] obj_2 = new byte[obj.length-"abcde".length()];
		System.arraycopy(obj, 0, obj_2, 0, obj_2.length);
		obj = JzlibUtils.unZlib(obj_2);
		ZhanqiApiVo zhanqiApiVo = (ZhanqiApiVo)ObjectAndByte.toObject(obj);
		return zhanqiApiVo;
	}
//	public static RoomApiVo QueryRoomApi(String htmlEntity){
//		JSONObject jsonObject = JSONObject.fromObject(htmlEntity);  
//		JsonConfig config = new JsonConfig();
//    	config.setJavaIdentifierTransformer(new JavaIdentifierTransformer() {
//    		public String transformToJavaIdentifier(String str) {
//    	    	char[] chars = str.toCharArray();
//    	    	chars[0] = Character.toLowerCase(chars[0]);
//    	        return new String(chars);
//    	    }
//    	});
//    	config.setRootClass(RoomApiVo.class);
//		RoomApiVo vo = (RoomApiVo) JSONObject.toBean(jsonObject,config);
//	    return vo;
//	}
//	public static List<RoomApiServerListVo> QueryServer(String htmlEntity) {
//		htmlEntity = htmlEntity.substring(htmlEntity.indexOf("["),htmlEntity.lastIndexOf("]")+1);
//		List<RoomApiServerListVo> roomApiServerListVo = new ArrayList<RoomApiServerListVo>();
//		JSONArray jsonArray = JSONArray.fromObject(htmlEntity);
//	    for ( int i = 0 ; i<jsonArray.size(); i++){          
//	    	JSONObject jsonObject = jsonArray.getJSONObject(i);
//	    	RoomApiServerListVo vo = (RoomApiServerListVo) JSONObject.toBean(jsonObject,RoomApiServerListVo.class);
//	    	roomApiServerListVo.add(vo);	            
//	    }	
//		return roomApiServerListVo;
//	}  
//	public static RoomViewerVo QuryRoomViewer(String htmlEntity) {
//		JSONObject jsonObject = JSONObject.fromObject(htmlEntity);  
//		JsonConfig config = new JsonConfig();
//    	config.setJavaIdentifierTransformer(new JavaIdentifierTransformer() {
//    		public String transformToJavaIdentifier(String str) {
//    	    	char[] chars = str.toCharArray();
//    	    	chars[0] = Character.toLowerCase(chars[0]);
//    	        return new String(chars);
//    	    }
//    	});
//    	config.setRootClass(RoomViewerVo.class);
//    	RoomViewerVo vo = (RoomViewerVo) JSONObject.toBean(jsonObject,config);
//	    return vo;
//	}
//	public static String getCpuIdMd5() {  
//	    String serial = ""; 
//	    try {  
//	        Process process = Runtime.getRuntime().exec(  
//	        new String[] { "wmic", "cpu", "get", "ProcessorId" });  
//	        process.getOutputStream().close();  
//	        Scanner sc = new Scanner(process.getInputStream());  
//	        sc.next();  
//	        serial = sc.next();  
//	    } catch (IOException e) {  
//	    }  
//	    return MD5Util.MD5(serial).toUpperCase();
//	}
	public static LoginResponseVo QueryLoginResponse(String msgStr) {
		Gson gson = new Gson();
		LoginResponseVo vo = (LoginResponseVo) gson.fromJson(msgStr, LoginResponseVo.class);
	    return vo;
	}
	public static ContentVo QueryContent(String msgStr) {
		Gson gson = new Gson();
		ContentVo vo = (ContentVo)  gson.fromJson(msgStr,ContentVo.class);
	    return vo;
	}
	public static ContentGiftVo QueryContentGift(String msgStr) {
		Gson gson = new Gson();
		ContentGiftVo vo = (ContentGiftVo) gson.fromJson(msgStr,ContentGiftVo.class);
	    return vo;
	}
	public static ZhanqiApiServerVo QueryServer(String servers) {
		Gson gson = new Gson();
		ZhanqiApiServerVo vo = (ZhanqiApiServerVo) gson.fromJson(servers, ZhanqiApiServerVo.class);
		return vo;
	}
	public static RoomViewerVo QuryZhanqiRoomViewer(String htmlEntity) {
		Gson gson = new Gson();
		RoomViewerVo vo = (RoomViewerVo) gson.fromJson(htmlEntity, RoomViewerVo.class);
		return vo;
	}


}
