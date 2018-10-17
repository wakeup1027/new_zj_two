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

import com.lxq.beans.XinWenMeiJieBean;
import com.lxq.service.framework.XinWenMeiJieService;

@Controller
@RequestMapping("/framework/admin")
public class XinWenMeiJieController {

	@Autowired
	private XinWenMeiJieService xinwenmeijieservice;
	
	@RequestMapping(value = "/listXinWenMeiJie.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = xinwenmeijieservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delXinWenMeiJie.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		XinWenMeiJieBean tzdb = new XinWenMeiJieBean();
		tzdb.setId(id);
		boolean tyri = xinwenmeijieservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addXinWenMeiJie.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(XinWenMeiJieBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			xinwenmeijieservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updXinWenMeiJie.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(XinWenMeiJieBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			xinwenmeijieservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getXinWenMeiJie.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = xinwenmeijieservice.get(daid);
		return map;
	}
	
}
