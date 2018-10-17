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

import com.lxq.beans.DaYiJieHuoBean;
import com.lxq.service.framework.DaYiJieHuoService;

@Controller
@RequestMapping("/framework/admin")
public class DaYiJieHuoController {

	@Autowired
	private DaYiJieHuoService dayijiehuoservice;
	
	@RequestMapping(value = "/listDaYiJieHuo.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = dayijiehuoservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delDaYiJieHuo.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		DaYiJieHuoBean tzdb = new DaYiJieHuoBean();
		tzdb.setId(id);
		boolean tyri = dayijiehuoservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addDaYiJieHuo.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(DaYiJieHuoBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			dayijiehuoservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updDaYiJieHuo.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(DaYiJieHuoBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			dayijiehuoservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getDaYiJieHuo.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = dayijiehuoservice.get(daid);
		return map;
	}
	
}
