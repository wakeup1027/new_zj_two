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

import com.lxq.beans.TouZiLiuChengBean;
import com.lxq.service.framework.TouZiLiuChengService;

@Controller
@RequestMapping("/framework/admin")
public class TouZiLiuChengController {

	@Autowired
	private TouZiLiuChengService touziliuchengservice;
	
	@RequestMapping(value = "/listTouZiLiuCheng.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = touziliuchengservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delTouZiLiuCheng.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		TouZiLiuChengBean tzdb = new TouZiLiuChengBean();
		tzdb.setId(id);
		boolean tyri = touziliuchengservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addTouZiLiuCheng.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(TouZiLiuChengBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touziliuchengservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updTouZiLiuCheng.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(TouZiLiuChengBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touziliuchengservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getTouZiLiuCheng.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = touziliuchengservice.get(daid);
		return map;
	}
	
}
