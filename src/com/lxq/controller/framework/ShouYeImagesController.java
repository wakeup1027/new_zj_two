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

import com.lxq.beans.ImagesBean;
import com.lxq.service.framework.ShouYeImagesService;

@Controller
@RequestMapping("/framework/admin")
public class ShouYeImagesController {

	@Autowired
	private ShouYeImagesService ShouYeImagesservice;
	
	@RequestMapping(value = "/listShouYeImages.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = ShouYeImagesservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delShouYeImages.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		ImagesBean tzdb = new ImagesBean();
		tzdb.setId(id);
		boolean tyri = ShouYeImagesservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addShouYeImages.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(ImagesBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			ShouYeImagesservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updShouYeImages.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(ImagesBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			ShouYeImagesservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getShouYeImages.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = ShouYeImagesservice.get(daid);
		return map;
	}
	
}
