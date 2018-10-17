package com.lxq.controller.frontwork;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxq.service.framework.ShouYeImagesService;

@Controller
@RequestMapping("/front")
public class FrontShouYeImagesController {
	
	@Autowired
	private ShouYeImagesService shouyeimagesservice;
	
	@RequestMapping(value = "/getDataShouYeImages.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(){
		Map<String, Object> map = new HashMap<String, Object>();
		map = shouyeimagesservice.getDate("1");
		return map;
	}
	
	@RequestMapping(value = "/getDataErWeiMa.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> lister(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("map1", shouyeimagesservice.getDate("2"));
		map.put("map2", shouyeimagesservice.getDate("3"));
		return map;
	}
}
