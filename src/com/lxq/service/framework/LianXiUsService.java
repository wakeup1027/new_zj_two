package com.lxq.service.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxq.beans.JiGouZhiNengBean;
import com.lxq.beans.JuZhangYouXiangBean;
import com.lxq.beans.LianXiWoMenBean;
import com.lxq.dao.Dao;
@Service
@Transactional
public class LianXiUsService {
	@Resource
	private Dao dao;
	
	/**
	 * 前端获取数据
	 */
	public Map<String, Object> getDate(){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql1 = "FROM JiGouZhiNengBean ORDER BY creatime DESC LIMIT 1";
		List<JiGouZhiNengBean> ss1 = dao.find(hql1);
		map.put("data1", ss1);
		
		String hql2 = "FROM JuZhangYouXiangBean ORDER BY creatime DESC LIMIT 1";
		List<JuZhangYouXiangBean> ss2 = dao.find(hql2);
		map.put("data2", ss2);
		
		String hql3 = "FROM LianXiWoMenBean ORDER BY creatime DESC LIMIT 1";
		List<LianXiWoMenBean> ss3 = dao.find(hql3);
		map.put("data3", ss3);
		return map;
	}
}
