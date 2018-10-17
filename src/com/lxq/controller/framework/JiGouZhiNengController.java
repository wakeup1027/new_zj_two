package com.lxq.controller.framework;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxq.beans.JiGouZhiNengBean;
import com.lxq.service.framework.JiGouZhiNengService;

@Controller
@RequestMapping("/framework/admin")
public class JiGouZhiNengController {

	@Autowired
	private JiGouZhiNengService jigouzhinengservice;
	
	@RequestMapping(value = "/listJiGouZhiNeng.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = jigouzhinengservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delJiGouZhiNeng.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		JiGouZhiNengBean tzdb = new JiGouZhiNengBean();
		tzdb.setId(id);
		boolean tyri = jigouzhinengservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addJiGouZhiNeng.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(JiGouZhiNengBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			jigouzhinengservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updJiGouZhiNeng.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(JiGouZhiNengBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			jigouzhinengservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getJiGouZhiNeng.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = jigouzhinengservice.get(daid);
		return map;
	}
	
}
