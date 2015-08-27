package name.yumao.zhanqi.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JTextField;

import name.yumao.zhanqi.mina.ContentMinaThread;
import name.yumao.zhanqi.vo.roomviewer.RoomViewerVo;
import name.yumao.zhanqi.vo.servers.ZhanqiApiServerVo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpVideoDownloader {
	public void download(JTextField inNum,JButton butnSure,String url,String filePath){
       HttpClient client = new DefaultHttpClient();  
       HttpGet httpGet = new HttpGet(url);  
        try {  
			//进行录像操作
            HttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
    			// 提前获取api参数
    			String inputText = inNum.getText();
    			String roomNum = HttpClientFromZhanqi.QueryZhanqiRoomNum(inputText);
    			// 进行房间参数的号码转换
    			inNum.setText(roomNum);
//    			// 获取匿名登陆参数
    			RoomViewerVo roomViewerVo = HttpClientFromZhanqi.QuryZhanqiRoomViewer();
//    			// 获取登入服务器列表
    			ZhanqiApiServerVo zhanqiApiServerVo = HttpClientFromZhanqi.QueryServer(inputText);
    			
    			ContentMinaThread zhanqiMina = new ContentMinaThread(filePath.substring(0,filePath.indexOf("."))+".ass",zhanqiApiServerVo,roomViewerVo,inNum,butnSure);
    			Thread zhanqiMinaThread = new Thread(zhanqiMina);
    			zhanqiMinaThread.start();
    			//进行录像文件的储存操作
	            HttpEntity entity = response.getEntity();  
	            InputStream is = entity.getContent();  
	            File file = new File(filePath);  
	            FileOutputStream fileout = new FileOutputStream(file);  
	            //缓存200KB
	            byte[] buffer=new byte[204800];  
	            int ch = 0;  
	            while ((ch = is.read(buffer)) != -1) {  
	                fileout.write(buffer,0,ch);  
	            }  
	            is.close();  
	            fileout.flush();  
	            fileout.close();  
            }
            httpGet.abort();
        }catch (Exception e){  
            e.printStackTrace();  
        }
	}
}
