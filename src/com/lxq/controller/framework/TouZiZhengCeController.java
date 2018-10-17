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

import com.lxq.beans.TouZiZhengCeBean;
import com.lxq.service.framework.TouZiZhengCeService;

@Controller
@RequestMapping("/framework/admin")
public class TouZiZhengCeController {

	@Autowired
	private TouZiZhengCeService touzizhengceservice;
	
	@RequestMapping(value = "/listTouZiZhengCe.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = touzizhengceservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delTouZiZhengCe.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		TouZiZhengCeBean tzdb = new TouZiZhengCeBean();
		tzdb.setId(id);
		boolean tyri = touzizhengceservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addTouZiZhengCe.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(TouZiZhengCeBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzizhengceservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updTouZiZhengCe.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(TouZiZhengCeBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzizhengceservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getTouZiZhengCe.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = touzizhengceservice.get(daid);
		return map;
	}
	
}
