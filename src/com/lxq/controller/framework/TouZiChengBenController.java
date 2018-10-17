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

import com.lxq.beans.TouZiChengBenBean;
import com.lxq.service.framework.TouZiChengBenService;

@Controller
@RequestMapping("/framework/admin")
public class TouZiChengBenController {

	@Autowired
	private TouZiChengBenService touzichengbenservice;
	
	@RequestMapping(value = "/listTouZiChengBen.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = touzichengbenservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delTouZiChengBen.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		TouZiChengBenBean tzdb = new TouZiChengBenBean();
		tzdb.setId(id);
		boolean tyri = touzichengbenservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addTouZiChengBen.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(TouZiChengBenBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzichengbenservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updTouZiChengBen.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(TouZiChengBenBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzichengbenservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getTouZiChengBen.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = touzichengbenservice.get(daid);
		return map;
	}
	
}
