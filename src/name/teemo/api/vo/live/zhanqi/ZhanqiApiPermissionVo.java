package name.teemo.api.vo.live.zhanqi;

import java.io.Serializable;

public class ZhanqiApiPermissionVo implements Serializable{
	private static final long serialVersionUID = 2960300990471701793L;
	private boolean fans;
	private boolean guess;
	private boolean replay;
	private boolean multi;
	private boolean shift;
	public boolean isFans() {
		return fans;
	}
	public void setFans(boolean fans) {
		this.fans = fans;
	}
	public boolean isGuess() {
		return guess;
	}
	public void setGuess(boolean guess) {
		this.guess = guess;
	}
	public boolean isReplay() {
		return replay;
	}
	public void setReplay(boolean replay) {
		this.replay = replay;
	}
	public boolean isMulti() {
		return multi;
	}
	public void setMulti(boolean multi) {
		this.multi = multi;
	}
	public boolean isShift() {
		return shift;
	}
	public void setShift(boolean shift) {
		this.shift = shift;
	}
	
}
