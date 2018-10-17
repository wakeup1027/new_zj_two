package com.lxq.controller.frontwork;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxq.service.framework.LiaoJieWoMenService;

@Controller
@RequestMapping("/front")
public class FrontLiaoJieWoMenController {
	
	@Autowired
	private LiaoJieWoMenService liaojiewomenservice;
	
	@RequestMapping(value = "/getDataLiaoJieWoMen.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("map1", liaojiewomenservice.getDate("1"));
		map.put("map2", liaojiewomenservice.getDate("2"));
		map.put("map3", liaojiewomenservice.getDate("3"));
		map.put("map4", liaojiewomenservice.getDate("4"));
		return map;
	}
}
