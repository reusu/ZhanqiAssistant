package name.yumao.zhanqi.vo.servers;

import java.io.Serializable;
import java.util.List;

public class ZhanqiApiServerVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1843417108190665213L;
	private ZhanqiApiServerLogVo log;
	private List<ZhanqiApiServerListVo> list;
	public ZhanqiApiServerLogVo getLog() {
		return log;
	}
	public void setLog(ZhanqiApiServerLogVo log) {
		this.log = log;
	}
	public List<ZhanqiApiServerListVo> getList() {
		return list;
	}
	public void setList(List<ZhanqiApiServerListVo> list) {
		this.list = list;
	}
	
}
