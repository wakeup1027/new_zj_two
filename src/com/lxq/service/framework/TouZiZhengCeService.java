package com.lxq.service.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxq.beans.TouZiZhengCeBean;
import com.lxq.dao.Dao;
@Service
@Transactional
public class TouZiZhengCeService {
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
		String hql = "FROM TouZiZhengCeBean";
		List<TouZiZhengCeBean> orders = this.dao.findByPage(hql, Integer.valueOf(page), Integer.valueOf(rows));
		Long total = this.dao.count(TouZiZhengCeBean.class,hql);
		map.put("data", orders);
	    map.put("count", total);
	    map.put("code", 0);
	    map.put("msg", "");
	    return map;
	}
	
	/**
	 * ɾ������
	 */
	public boolean delbean(TouZiZhengCeBean tb){
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
	public void add(TouZiZhengCeBean tb){
		dao.save(tb);
	}
	
	/**
	 * �޸�
	 */
	public void up(TouZiZhengCeBean tb){
		dao.update(tb);
	}
	
	/**
	 * ��ȡ����
	 */
	public Map<String, Object> get(String daid){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "FROM TouZiZhengCeBean WHERE id = '"+daid+"'";
		List<TouZiZhengCeBean> ss = dao.find(hql);
		map.put("data", ss);
		return map;
	}
	
	/**
	 * ǰ�˻�ȡ����
	 */
	public Map<String, Object> getDate(){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "FROM TouZiZhengCeBean ORDER BY creatime DESC LIMIT 1";
		List<TouZiZhengCeBean> ss = dao.find(hql);
		map.put("data", ss);
		return map;
	}
}
