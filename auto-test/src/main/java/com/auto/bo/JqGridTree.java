package com.auto.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JqGridTree {
	private int id;
	private String name;
	private String type;
	private String description;
	private String remark;
	private String parent_id;
	private int level;
	private String isLeaf;
	private boolean loaded;
	private boolean expanded;
	private String value;
	private String operator;
	private String icon;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isLoaded() {
		return loaded;
	}
	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	@JsonIgnore
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	/**
	 * 重写equals方法，用于比较数据是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)  
			return true;  
		if (obj == null)  
			return false;  
		if (getClass() != obj.getClass())  
			return false;  
		final JqGridTree other = (JqGridTree) obj;  
		if (this.getId() != other.getId())  
			return false;  
		return true;  
	}

}
