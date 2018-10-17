package com.lxq.service.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxq.beans.LiaoJieWoMenBean;
import com.lxq.dao.Dao;
@Service
@Transactional
public class LiaoJieWoMenService {
	@Resource
	private Dao dao;
	
	/**
	 * 获取投资动态数据
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> shows(int page, int rows){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "FROM LiaoJieWoMenBean";
		List<LiaoJieWoMenBean> orders = this.dao.findByPage(hql, Integer.valueOf(page), Integer.valueOf(rows));
		Long total = this.dao.count(LiaoJieWoMenBean.class,hql);
		map.put("data", orders);
	    map.put("count", total);
	    map.put("code", 0);
	    map.put("msg", "");
	    return map;
	}
	
	/**
	 * 删除数据
	 */
	public boolean delbean(LiaoJieWoMenBean tb){
		try {
			dao.delete(tb);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 新增
	 * @param tb
	 */
	public void add(LiaoJieWoMenBean tb){
		dao.save(tb);
	}
	
	/**
	 * 修改
	 */
	public void up(LiaoJieWoMenBean tb){
		dao.update(tb);
	}
	
	/**
	 * 获取数据
	 */
	public Map<String, Object> get(String daid){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "FROM LiaoJieWoMenBean WHERE id = '"+daid+"'";
		List<LiaoJieWoMenBean> ss = dao.find(hql);
		map.put("data", ss);
		return map;
	}
	
	/**
	 * 前端获取数据
	 */
	public Map<String, Object> getDate(String numtype){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "FROM LiaoJieWoMenBean WHERE type = '"+numtype+"' ORDER BY creatime DESC LIMIT 1";
		List<LiaoJieWoMenBean> ss = dao.find(hql);
		map.put("data", ss);
		return map;
	}
}
