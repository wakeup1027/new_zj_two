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

import com.lxq.beans.ZiLiaoXiaZaiBean;
import com.lxq.service.framework.ZiLiaoXiaZaiService;

@Controller
@RequestMapping("/framework/admin")
public class ZiLiaoXiaZaiController {

	@Autowired
	private ZiLiaoXiaZaiService ziliaoxiazaiservice;
	
	@RequestMapping(value = "/listZiLiaoXiaZai.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = ziliaoxiazaiservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delZiLiaoXiaZai.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		ZiLiaoXiaZaiBean tzdb = new ZiLiaoXiaZaiBean();
		tzdb.setId(id);
		boolean tyri = ziliaoxiazaiservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addZiLiaoXiaZai.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(ZiLiaoXiaZaiBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			ziliaoxiazaiservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updZiLiaoXiaZai.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(ZiLiaoXiaZaiBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			ziliaoxiazaiservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getZiLiaoXiaZai.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = ziliaoxiazaiservice.get(daid);
		return map;
	}
	
}
