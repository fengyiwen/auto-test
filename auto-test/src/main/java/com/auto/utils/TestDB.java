package com.auto.utils;

import java.util.List;
import java.util.Map;

public class TestDB {

	public static void main(String[] args) {
		String sql = "select * from relief_reward_log";
		List list = TestUtils.getExpectListFromDB(sql);
		int size = list.size();
		for (int i=0;i<size;i++){
			Object obj = list.get(i);
			if (obj instanceof Map){
				Map map = (Map)obj;
				System.out.println(map.get("task_code"));
			}
		}

	}

}
