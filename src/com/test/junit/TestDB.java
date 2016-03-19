package com.test.junit;

import org.junit.Test;

import com.test.db.DBUtils;

public class TestDB {
	
	@Test
	public void getConnection(){
		System.out.println(DBUtils.getConnection());
	}
}
