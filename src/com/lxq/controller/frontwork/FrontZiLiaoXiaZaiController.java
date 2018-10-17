package com.lxq.controller.frontwork;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxq.service.framework.ZiLiaoXiaZaiService;

@Controller
@RequestMapping("/front")
public class FrontZiLiaoXiaZaiController {
	
	@Autowired
	private ZiLiaoXiaZaiService ziliaoxiazaiservice;
	
	@RequestMapping(value = "/getListZiLiaoXiaZai.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = ziliaoxiazaiservice.shows(page, limit);
		return map;
	}
}
