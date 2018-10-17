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

import com.lxq.beans.GangTieYuanQuBean;
import com.lxq.service.framework.GangTieYuanQuService;

@Controller
@RequestMapping("/framework/admin")
public class GangTieYuanQuController {

	@Autowired
	private GangTieYuanQuService gangtieyuanquservice;
	
	@RequestMapping(value = "/listGangTieYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = gangtieyuanquservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delGangTieYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		GangTieYuanQuBean tzdb = new GangTieYuanQuBean();
		tzdb.setId(id);
		boolean tyri = gangtieyuanquservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addGangTieYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(GangTieYuanQuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			gangtieyuanquservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updGangTieYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(GangTieYuanQuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			gangtieyuanquservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getGangTieYuanQu.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = gangtieyuanquservice.get(daid);
		return map;
	}
	
}
