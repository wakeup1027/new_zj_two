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

import com.lxq.beans.ZhiNengBuMenBean;
import com.lxq.service.framework.ZhiNengBuMenService;

@Controller
@RequestMapping("/framework/admin")
public class ZhiNengBuMenController {

	@Autowired
	private ZhiNengBuMenService zhinengbumenservice;
	
	@RequestMapping(value = "/listZhiNengBuMen.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = zhinengbumenservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delZhiNengBuMen.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		ZhiNengBuMenBean tzdb = new ZhiNengBuMenBean();
		tzdb.setId(id);
		boolean tyri = zhinengbumenservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addZhiNengBuMen.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(ZhiNengBuMenBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			zhinengbumenservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updZhiNengBuMen.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(ZhiNengBuMenBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			zhinengbumenservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getZhiNengBuMen.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = zhinengbumenservice.get(daid);
		return map;
	}
	
}
