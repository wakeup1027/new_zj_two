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

import com.lxq.beans.ShiHuaYuanQuBean;
import com.lxq.service.framework.ShiHuaYuanQuService;

@Controller
@RequestMapping("/framework/admin")
public class ShiHuaYuanQuController {

	@Autowired
	private ShiHuaYuanQuService shihuayuanquservice;
	
	@RequestMapping(value = "/listShiHuaYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = shihuayuanquservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delShiHuaYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		ShiHuaYuanQuBean tzdb = new ShiHuaYuanQuBean();
		tzdb.setId(id);
		boolean tyri = shihuayuanquservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addShiHuaYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(ShiHuaYuanQuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			shihuayuanquservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updShiHuaYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(ShiHuaYuanQuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			shihuayuanquservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getShiHuaYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = shihuayuanquservice.get(daid);
		return map;
	}
	
}
