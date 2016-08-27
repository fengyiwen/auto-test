package com.auto.bo;

import java.util.List;

public class Tree {
	private String name;
	private List<Tree> chiludes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Tree> getChiludes() {
		return chiludes;
	}
	public void setChiludes(List<Tree> chiludes) {
		this.chiludes = chiludes;
	}


}
