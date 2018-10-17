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

import com.lxq.beans.TouZiMuLuBean;
import com.lxq.service.framework.TouZiMuLuService;

@Controller
@RequestMapping("/framework/admin")
public class TouZiMuLuController {

	@Autowired
	private TouZiMuLuService touzimuluservice;
	
	@RequestMapping(value = "/listTouZiMuLu.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = touzimuluservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delTouZiMuLu.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		TouZiMuLuBean tzdb = new TouZiMuLuBean();
		tzdb.setId(id);
		boolean tyri = touzimuluservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addTouZiMuLu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(TouZiMuLuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzimuluservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updTouZiMuLu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(TouZiMuLuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzimuluservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getTouZiMuLu.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = touzimuluservice.get(daid);
		return map;
	}
	
}
