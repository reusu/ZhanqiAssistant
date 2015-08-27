package name.yumao.zhanqi.mina;

import java.net.InetSocketAddress;

import javax.swing.JButton;
import javax.swing.JTextField;

import name.yumao.zhanqi.mina.factory.HexCodecFactory;
import name.yumao.zhanqi.utils.HexUtils;
import name.yumao.zhanqi.vo.request.ZhanqiGetUCRequestVo;
import name.yumao.zhanqi.vo.request.ZhanqiLoginRequestVo;
import name.yumao.zhanqi.vo.roomviewer.RoomViewerVo;
import name.yumao.zhanqi.vo.servers.ZhanqiApiServerListVo;
import name.yumao.zhanqi.vo.servers.ZhanqiApiServerVo;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.google.gson.GsonBuilder;

public class ContentMinaThread implements Runnable{
	private static Logger logger = Logger.getLogger(ContentMinaThread.class);
	private ZhanqiApiServerListVo zhanqiApiServerListVo;
	private RoomViewerVo roomViewerVo;
	private JTextField inNum;
	private JButton butnSure;
	private String hexTmp;
	private GsonBuilder gb;
	private String filepath;
	public ContentMinaThread(String filepath,ZhanqiApiServerVo zhanqiApiServerVo,RoomViewerVo roomViewerVo,JTextField inNum,JButton butnSure){
		//拉起进程同时随机选择登陆服务器
		zhanqiApiServerListVo = zhanqiApiServerVo.getList().get((int)(Math.random()*zhanqiApiServerVo.getList().size()));
		logger.info("随机选择弹幕服务器 " + zhanqiApiServerListVo.getIp() + ":" + zhanqiApiServerListVo.getPort());
		//初始化
		this.filepath = filepath;
		this.inNum = inNum;
		this.butnSure = butnSure;
		this.roomViewerVo = roomViewerVo;
		this.gb = new GsonBuilder();
		gb.disableHtmlEscaping();
	}
	@Override
	public void run() {
		IoConnector connector = new NioSocketConnector();
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		chain.addLast("codec", new ProtocolCodecFilter(new HexCodecFactory()));
		connector.setHandler(new ContentMinaHandler(filepath,inNum,butnSure));
		IoSession session = null;
		try{
			
			ConnectFuture future = connector.connect(new InetSocketAddress(zhanqiApiServerListVo.getIp(),Integer.parseInt(zhanqiApiServerListVo.getPort())));
			future.awaitUninterruptibly();
			session=future.getSession();
			//发送登录信息
			hexTmp = HexUtils.setStringHeader("0000e803" + HexUtils.Bytes2HexString("{\"cmdid\":\"svrisokreq\"}".getBytes()).replace(" ", ""));
			session.write(hexTmp);
			Thread.sleep(1000);
			//进入聊天室
			ZhanqiGetUCRequestVo zhanqiGetUCRequestVo = new ZhanqiGetUCRequestVo();
			zhanqiGetUCRequestVo.setVod("0");
			zhanqiGetUCRequestVo.setCmdid("getdefaultuc");
			zhanqiGetUCRequestVo.setRoomid(inNum.getText());
			hexTmp = HexUtils.setStringHeader("00001027" + HexUtils.Bytes2HexString(gb.create().toJson(zhanqiGetUCRequestVo).getBytes()).replace(" ", ""));
			session.write(hexTmp);
			ZhanqiLoginRequestVo zhanqiLoginRequestVo = new ZhanqiLoginRequestVo();
			zhanqiLoginRequestVo.setFhost("iphone");
			zhanqiLoginRequestVo.setT(0);
			zhanqiLoginRequestVo.setGid(Long.parseLong(roomViewerVo.getData().getGid()));
			zhanqiLoginRequestVo.setSid(roomViewerVo.getData().getSid());
			zhanqiLoginRequestVo.setUid(0);
			zhanqiLoginRequestVo.setRoomid(Integer.parseInt(inNum.getText()));
			zhanqiLoginRequestVo.setNickname("");
			zhanqiLoginRequestVo.setCmdid("loginreq");
			zhanqiLoginRequestVo.setTimestamp(Long.parseLong(roomViewerVo.getData().getTimestamp()));
			zhanqiLoginRequestVo.setDevice(1);
			zhanqiLoginRequestVo.setR(0);
			hexTmp = HexUtils.setStringHeader("00001027" + HexUtils.Bytes2HexString(gb.create().toJson(zhanqiLoginRequestVo).getBytes()).replace(" ", ""));
			session.write(hexTmp);
			//开启心跳包线程
			KeepLive keeplive = new KeepLive(session);
			Thread keepliveThread = new Thread(keeplive);
			keepliveThread.start();
		}catch (Exception e) {
			logger.info("弹幕服务器连接失败!");
			e.printStackTrace();
		}
	}
}
