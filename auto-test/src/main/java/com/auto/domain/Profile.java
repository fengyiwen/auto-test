package com.auto.domain;

import java.io.Serializable;

public class Profile implements Serializable{
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -334387682304951476L;
	private boolean isHintEnabled;
	
	public boolean getIsHintEnabled() {
		return isHintEnabled;
	}
	
	public void setIsHintEnabled(boolean isHintEnabled) {
		this.isHintEnabled = isHintEnabled;
	}
}
