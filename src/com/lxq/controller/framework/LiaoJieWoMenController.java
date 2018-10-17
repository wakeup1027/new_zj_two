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

import com.lxq.beans.LiaoJieWoMenBean;
import com.lxq.service.framework.LiaoJieWoMenService;

@Controller
@RequestMapping("/framework/admin")
public class LiaoJieWoMenController {

	@Autowired
	private LiaoJieWoMenService liaojiewomenservice;
	
	@RequestMapping(value = "/listLiaoJieWoMen.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = liaojiewomenservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delLiaoJieWoMen.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		LiaoJieWoMenBean tzdb = new LiaoJieWoMenBean();
		tzdb.setId(id);
		boolean tyri = liaojiewomenservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addLiaoJieWoMen.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(LiaoJieWoMenBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			liaojiewomenservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updLiaoJieWoMen.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(LiaoJieWoMenBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			liaojiewomenservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getLiaoJieWoMen.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = liaojiewomenservice.get(daid);
		return map;
	}
	
}
