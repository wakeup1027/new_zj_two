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

import com.lxq.beans.LianXiWoMenBean;
import com.lxq.service.framework.LianXiWoMenService;

@Controller
@RequestMapping("/framework/admin")
public class LianXiWoMenController {

	@Autowired
	private LianXiWoMenService lianxiwomenservice;
	
	@RequestMapping(value = "/listLianXiWoMen.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = lianxiwomenservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delLianXiWoMen.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		LianXiWoMenBean tzdb = new LianXiWoMenBean();
		tzdb.setId(id);
		boolean tyri = lianxiwomenservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addLianXiWoMen.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(LianXiWoMenBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			lianxiwomenservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updLianXiWoMen.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(LianXiWoMenBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			lianxiwomenservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getLianXiWoMen.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = lianxiwomenservice.get(daid);
		return map;
	}
	
}
