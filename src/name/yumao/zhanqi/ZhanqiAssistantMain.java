package name.yumao.zhanqi;

import javax.swing.JFrame;

import name.yumao.zhanqi.swing.Danmu;
import name.yumao.zhanqi.swing.Download;

public class ZhanqiAssistantMain extends JFrame{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		if(args[0].equals("-content")){
			Danmu danmu = new Danmu();
		}else if(args[0].equals("-download")){
			Download download = new Download();
		}else{
			System.out.print("错误的传入参数！");
		}
	}	
}
