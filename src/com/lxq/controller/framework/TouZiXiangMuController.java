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

import com.lxq.beans.TouZiXiangMuBean;
import com.lxq.service.framework.TouZiXiangMuService;

@Controller
@RequestMapping("/framework/admin")
public class TouZiXiangMuController {

	@Autowired
	private TouZiXiangMuService touzixiangmuservice;
	
	@RequestMapping(value = "/listTouZiXiangMu.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = touzixiangmuservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delTouZiXiangMu.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		TouZiXiangMuBean tzdb = new TouZiXiangMuBean();
		tzdb.setId(id);
		boolean tyri = touzixiangmuservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addTouZiXiangMu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(TouZiXiangMuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzixiangmuservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updTouZiXiangMu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(TouZiXiangMuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzixiangmuservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getTouZiXiangMu.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = touzixiangmuservice.get(daid);
		return map;
	}
	
}
