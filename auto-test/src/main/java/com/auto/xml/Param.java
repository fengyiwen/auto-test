package com.auto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
/**
 * 
 *<p>Title:Param</p>
 *<p>Description:参数类</p>
 *<p>Company:atzuche</p>
 * @author zhiping.li
 * @date 2015年11月27日上午10:08:47
 */
@XStreamAlias("param")  
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "content" }) 
public class Param {
	public Param(String name, String content) {  
		super();  
		this.name = name;  
		this.content = content;  
	}  

	@XStreamAsAttribute  
	private String name;  

	private String content;  

	public String getName() {  
		return name;  
	}  

	public void setName(String name) {  
		this.name = name;  
	}  

	public String getContent() {  
		return content;  
	}  
	
	public void setContent(String content) {  
		this.content = content;  
	}  
}
