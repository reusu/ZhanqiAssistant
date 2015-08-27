package name.yumao.zhanqi.mina;

//import javax.swing.ImageIcon;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JTextField;

import name.yumao.zhanqi.swing.ToolSub;
import name.yumao.zhanqi.swing.ToolTip;
import name.yumao.zhanqi.utils.BigHexStringUtils;
import name.yumao.zhanqi.utils.HexUtils;
import name.yumao.zhanqi.utils.SQLiteReadBDS;
import name.yumao.zhanqi.utils.SQLiteUtils;
import name.yumao.zhanqi.utils.SQLiteWriteBDS;
import name.yumao.zhanqi.utils.ServerUtils;
import name.yumao.zhanqi.vo.response.ContentGiftVo;
import name.yumao.zhanqi.vo.response.ContentVo;
import name.yumao.zhanqi.vo.response.LoginResponseVo;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ContentMinaHandler implements IoHandler {
	private ToolTip tip = null;
	private ToolSub sub = null;
	private JTextField inNum;
	private JButton butnSure;
	private BigHexStringUtils bigHexStringUtils;
	private Calendar calendar;
	private LoginResponseVo loginResponseVo;
	private ContentVo contentVo;
	private ContentGiftVo contentGiftVo;
	private String filepath;
	private static Logger logger = Logger.getLogger(ContentMinaHandler.class);
	public ContentMinaHandler(String filepath,JTextField inNum,JButton butnSure){
		this.filepath = filepath;
		this.inNum = inNum;
		this.butnSure = butnSure;
		this.bigHexStringUtils = new BigHexStringUtils();
		this.calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dabPath = "logs"+File.separator+"dab"+File.separator+simpleDateFormat.format(calendar.getTime())+"-"+inNum.getText()+".dab";
		SQLiteReadBDS.setSqliteUrl(dabPath);
		SQLiteWriteBDS.setSqliteUrl(dabPath);
		SQLiteUtils.initDB();
	}
	@Override
	public void exceptionCaught(IoSession session, Throwable arg1)
			throws Exception {
	}
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception{
//		logger.info("受到返回的信息: " + new String(HexUtils.HexString2Bytes(message.toString())));
		//进行hexString的格式化
		String hexMessage = message.toString().replace(" ", "");
		//默认以粘包方式拆分包
		if(hexMessage.length()>0){
			bigHexStringUtils.addHexStr(hexMessage);
			hexMessage = hexMessage.substring(hexMessage.length());
			while(bigHexStringUtils.hasFullHexStr()){
//				System.out.println("Before " + bigHexStringUtils.getHexStr());
				//如果包含完整包 从头开始将一个个包解析出来
				String hexStrTmp = bigHexStringUtils.getHexStr();
				int msgLength = Math.abs(HexUtils.getHexStringLength(hexStrTmp));
				String hexMsg = hexStrTmp.substring(0,(msgLength+4)*2+16);
				//判断是否是正常包
				if(bigHexStringUtils.isFullHexStr(hexMsg)){
					//是的话进行正常解码
					byte[] msgBytes = HexUtils.HexString2Bytes(hexMsg);
					String msgStr = new String(Arrays.copyOfRange(msgBytes, 12, msgBytes.length-1),"UTF-8");
//					logger.info("DanmuServer:" + msgStr);
					//评论解析操作
					if(msgStr.contains("loginresp")){
						loginResponseVo = ServerUtils.QueryLoginResponse(msgStr);
						if(tip == null){
							tip = new ToolTip();
						}
						tip.setToolTip("获取的登录用户名为: "+loginResponseVo.getNickname());
						logger.info("获取的登录用户名为: "+loginResponseVo.getNickname());
						Thread.sleep(100);
						tip.setToolTip("登陆的病床编号为: "+inNum.getText()+" 床");
						logger.info("登陆的病床编号为: "+inNum.getText()+" 床");
						Thread.sleep(100);
						if(filepath!=null&&(!filepath.equals(""))){
							//录制
							tip.setToolTip("启动录制进程...");
							logger.info("启动录制进程...");
						}else{
							//启动弹幕获取进程
							tip.setToolTip("启动弹幕获取进程...");
							logger.info("启动弹幕获取进程...");
						}
						Thread.sleep(100);
						tip.setToolTip("战旗TV小助手启动完毕!");
						logger.info("战旗TV小助手启动完毕!");
					}
					if(msgStr.contains("chatmessage")){
						contentVo = ServerUtils.QueryContent(msgStr);
						String content = contentVo.getContent();
						String snick = contentVo.getFromname();
						if(filepath!=null&&(!filepath.equals(""))){
							//进行弹幕分析 拉起字幕转储进程
							sub.addSubString(content.replace("=", "-"));
						}else{
							//进行弹幕分析 拉起气泡进程
							logger.info("接收到弹幕消息\t" + snick + " : " +content);
							if(tip == null){
								tip = new ToolTip();
							}
							tip.setToolTip(snick + " : " +content);
							SQLiteUtils.addContent(snick , content);
						}
					}
					if(msgStr.contains("Gift.Use")){
						contentGiftVo = ServerUtils.QueryContentGift(msgStr);
						String ms = contentGiftVo.getData().getCount();
						String snick = contentGiftVo.getData().getNickname();
						String item = contentGiftVo.getData().getName();
						logger.info("接收到礼物消息\t" + snick + " 赠送给主播" + ms + "个 "+item);
						if(tip == null){
							tip = new ToolTip();
						}
						if(filepath!=null&&(!filepath.equals(""))){}else{
							tip.setToolTip(snick + " 赠送给主播" + ms + "个 "+item);
						}
						SQLiteUtils.addDonateres(snick ,ms);
					}
				}else{
					//不是的话什么都不做 顺带清理无效数据
					logger.info("传入非完整的数据段");
				}
				bigHexStringUtils.clear();
				bigHexStringUtils.addHexStr(hexStrTmp.substring((msgLength+4)*2+16));
//				System.out.println("After " + bigHexStringUtils.getHexStr());
			}
		}
	}
	@Override
	public void messageSent(IoSession session, Object massage) throws Exception {
//		String msg =new String(HexUtils.HexString2Bytes(massage.toString()),"utf-8") ;
//		logger.info("Send Danmu Server " + msg);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		tip.setToolTip("失去与弹幕服务器的连接");
		logger.info("失去与弹幕服务器的连接");
		inNum.setEditable(true);
		butnSure.setEnabled(true);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		if(filepath!=null&&(!filepath.equals(""))){
			//录制模式建立连接的同时建立字幕文件
			if(sub == null){
				sub = new ToolSub(filepath);
			}
		}
		
	}
	@Override
	public void sessionIdle(IoSession session, IdleStatus arg1) throws Exception {
	}
	@Override
	public void sessionOpened(IoSession session) throws Exception {
	}
}
