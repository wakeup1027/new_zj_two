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

import com.lxq.beans.ZhongYangShangWuBean;
import com.lxq.service.framework.ZhongYangShangWuService;

@Controller
@RequestMapping("/framework/admin")
public class ZhongYangShangWuController {

	@Autowired
	private ZhongYangShangWuService zhongyangshangwuservice;
	
	@RequestMapping(value = "/listZhongYangShangWu.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = zhongyangshangwuservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delZhongYangShangWu.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		ZhongYangShangWuBean tzdb = new ZhongYangShangWuBean();
		tzdb.setId(id);
		boolean tyri = zhongyangshangwuservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addZhongYangShangWu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(ZhongYangShangWuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			zhongyangshangwuservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updZhongYangShangWu.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(ZhongYangShangWuBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			zhongyangshangwuservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getZhongYangShangWu.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = zhongyangshangwuservice.get(daid);
		return map;
	}
	
}
