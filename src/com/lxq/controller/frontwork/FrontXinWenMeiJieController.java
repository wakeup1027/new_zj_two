package com.lxq.controller.frontwork;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxq.service.framework.XinWenMeiJieService;

@Controller
@RequestMapping("/front")
public class FrontXinWenMeiJieController {
	@Autowired
	private XinWenMeiJieService xinwenmeijieservice;
	
	@RequestMapping(value = "/getDataXinWenMeiJie.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = xinwenmeijieservice.shows(page, limit);
		return map;
	}
}
