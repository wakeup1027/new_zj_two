package com.lxq.service.frontwork;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxq.dao.Dao;

import net.sf.json.JSONObject;

@Service
@Transactional
public class SreachResultService<T> {
	@Resource
	private Dao dao;
	
	public Map<String,Object> shows(String beanName, String keyVal, String numtype){
		Map<String,Object> map = new HashMap<String,Object>();
		String sql = "SELECT * FROM "+beanName+" WHERE title LIKE '%"+keyVal+"%' OR content LIKE '%"+keyVal+"%'";
		if("11".equals(numtype)){
			sql = "SELECT * FROM "+beanName+" WHERE title LIKE '%"+keyVal+"%'";
		}
		List<T> ss = dao.executeJDBCSqlQuery(sql);
		map.put("data", ss);
		map.put("typn", numtype);
	    return map;
	}
	
	public Map<String,Object> showdetails(String beanName, String keyVal, String numtype){
		Map<String,Object> map = new HashMap<String,Object>();
		String sql = "SELECT * FROM "+beanName+" WHERE id = '"+keyVal+"'";
		List<T> ss = dao.executeJDBCSqlQuery(sql);
		map.put("data", ss.get(0));
		map.put("typn", numtype);
	    return map;
	}
}
