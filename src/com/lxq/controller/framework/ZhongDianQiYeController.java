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

import com.lxq.beans.ZhongDianQiYeBean;
import com.lxq.service.framework.ZhongDianQiYeService;

@Controller
@RequestMapping("/framework/admin")
public class ZhongDianQiYeController {

	@Autowired
	private ZhongDianQiYeService zhongdianqiyeservice;
	
	@RequestMapping(value = "/listZhongDianQiYe.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = zhongdianqiyeservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delZhongDianQiYe.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		ZhongDianQiYeBean tzdb = new ZhongDianQiYeBean();
		tzdb.setId(id);
		boolean tyri = zhongdianqiyeservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addZhongDianQiYe.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(ZhongDianQiYeBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			zhongdianqiyeservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updZhongDianQiYe.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(ZhongDianQiYeBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			zhongdianqiyeservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getZhongDianQiYe.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = zhongdianqiyeservice.get(daid);
		return map;
	}
	
}
