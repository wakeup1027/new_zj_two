package com.lxq.controller.frontwork;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxq.service.framework.ZhongYangShangWuService;

@Controller
@RequestMapping("/front")
public class FrontZhongYangShangWuController {
	@Autowired
	private ZhongYangShangWuService zhongyangshangwuservice;
	
	@RequestMapping(value = "/getDataZhongYangShangWu.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(){
		Map<String, Object> map = new HashMap<String, Object>();
		map = zhongyangshangwuservice.getDate();
		return map;
	}
}
