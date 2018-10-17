package com.lxq.service.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxq.beans.TouZiDongTaiBean;
import com.lxq.beans.ZhongYangShangWuBean;
import com.lxq.dao.Dao;
@Service
@Transactional
public class ZhongYangShangWuService {
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
		String hql = "FROM ZhongYangShangWuBean";
		List<ZhongYangShangWuBean> orders = this.dao.findByPage(hql, Integer.valueOf(page), Integer.valueOf(rows));
		Long total = this.dao.count(ZhongYangShangWuBean.class,hql);
		map.put("data", orders);
	    map.put("count", total);
	    map.put("code", 0);
	    map.put("msg", "");
	    return map;
	}
	
	/**
	 * ɾ������
	 */
	public boolean delbean(ZhongYangShangWuBean tb){
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
	public void add(ZhongYangShangWuBean tb){
		dao.save(tb);
	}
	
	/**
	 * �޸�
	 */
	public void up(ZhongYangShangWuBean tb){
		dao.update(tb);
	}
	
	/**
	 * ��ȡ����
	 */
	public Map<String, Object> get(String daid){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "FROM ZhongYangShangWuBean WHERE id = '"+daid+"'";
		List<ZhongYangShangWuBean> ss = dao.find(hql);
		map.put("data", ss);
		return map;
	}
	
	/**
	 * ǰ�˻�ȡ����
	 */
	public Map<String, Object> getDate(){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "FROM ZhongYangShangWuBean ORDER BY creatime DESC LIMIT 1";
		List<ZhongYangShangWuBean> ss = dao.find(hql);
		map.put("data", ss);
		return map;
	}
}
