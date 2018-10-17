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

import com.lxq.beans.JuZhangYouXiangBean;
import com.lxq.service.framework.JuZhangYouXiangService;

@Controller
@RequestMapping("/framework/admin")
public class JuZhangYouXiangController {

	@Autowired
	private JuZhangYouXiangService juzhangyouxiangservice;
	
	@RequestMapping(value = "/listJuZhangYouXiang.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = juzhangyouxiangservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delJuZhangYouXiang.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		JuZhangYouXiangBean tzdb = new JuZhangYouXiangBean();
		tzdb.setId(id);
		boolean tyri = juzhangyouxiangservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addJuZhangYouXiang.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(JuZhangYouXiangBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			juzhangyouxiangservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updJuZhangYouXiang.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(JuZhangYouXiangBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			juzhangyouxiangservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getJuZhangYouXiang.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = juzhangyouxiangservice.get(daid);
		return map;
	}
	
}
