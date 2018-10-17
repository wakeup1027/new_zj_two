package com.lxq.service.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxq.beans.LianXiWoMenBean;
import com.lxq.dao.Dao;
@Service
@Transactional
public class LianXiWoMenService {
	@Resource
	private Dao dao;
	
	/**
	 * ��ȡͶ�ʶ�̬����
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> shows(int page, int rows){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "FROM LianXiWoMenBean";
		List<LianXiWoMenBean> orders = this.dao.findByPage(hql, Integer.valueOf(page), Integer.valueOf(rows));
		Long total = this.dao.count(LianXiWoMenBean.class,hql);
		map.put("data", orders);
	    map.put("count", total);
	    map.put("code", 0);
	    map.put("msg", "");
	    return map;
	}
	
	/**
	 * ɾ������
	 */
	public boolean delbean(LianXiWoMenBean tb){
		try {
			dao.delete(tb);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * ����
	 * @param tb
	 */
	public void add(LianXiWoMenBean tb){
		dao.save(tb);
	}
	
	/**
	 * �޸�
	 */
	public void up(LianXiWoMenBean tb){
		dao.update(tb);
	}
	
	/**
	 * ��ȡ����
	 */
	public Map<String, Object> get(String daid){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "FROM LianXiWoMenBean WHERE id = '"+daid+"'";
		List<LianXiWoMenBean> ss = dao.find(hql);
		map.put("data", ss);
		return map;
	}
}
