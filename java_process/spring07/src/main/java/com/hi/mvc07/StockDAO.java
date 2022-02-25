package com.hi.mvc07;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockDAO {
	
	@Autowired
	SqlSessionTemplate my;
	
	public void insert(StockVO vo) {
		my.insert("stock.create", vo);
	}
}
