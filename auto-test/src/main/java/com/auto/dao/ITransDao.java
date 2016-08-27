package com.auto.dao;

import com.auto.bo.TransBase;

public interface ITransDao {
	
	public TransBase query(Long orderNo);
}
