package com.lxq.controller.frontwork;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxq.beans.ZiLiaoXiaZaiBean;
import com.lxq.service.framework.TouZiDongTaiService;
import com.lxq.service.frontwork.SreachResultService;

@Controller
@RequestMapping("/front")
public class FrontTouZiDongTaiController {
	@Autowired
	private TouZiDongTaiService touzidongtaiservice;
	
	@Autowired
	private SreachResultService<?> sreachresultservice;
	
	@RequestMapping(value = "/getDataTouZiDongTai.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = touzidongtaiservice.shows(page, limit);
		return map;
	}
	
	/***
	 * 前端搜索
	 */
	@RequestMapping(value = "/sreachRes.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> sreach(String type, String keyVal){
		Map<String, Object> map = new HashMap<String, Object>();
		if("0".equals(type)){
			map.put("map1", sreachresultservice.shows("touzidongtai", keyVal, "1"));//投资动态
			map.put("map2", sreachresultservice.shows("xinwenmeijie", keyVal, "2"));//新闻媒介
			map.put("map3", sreachresultservice.shows("liaojiewomen", keyVal, "3"));//了解我们
			map.put("map4", sreachresultservice.shows("touzixiangmu", keyVal, "4"));//投资项目
			map.put("map5", sreachresultservice.shows("touzizhengce", keyVal, "5"));//投资政策
			map.put("map6", sreachresultservice.shows("touzichengben", keyVal, "6"));//投资成本
			map.put("map7", sreachresultservice.shows("zhongdianqiye", keyVal, "7"));//重点企业
			map.put("map8", sreachresultservice.shows("touziliucheng", keyVal, "8"));//投资流程
			map.put("map9", sreachresultservice.shows("zhinengbumen", keyVal, "9"));//职能部门联系
			map.put("map10", sreachresultservice.shows("touzimulu", keyVal, "10"));//投资目录
			map.put("map11", sreachresultservice.shows("ziliaoxiazai", keyVal, "11"));//资料下载
			map.put("map12", sreachresultservice.shows("dayijiehuo", keyVal, "12"));//答疑解惑
			map.put("map13", sreachresultservice.shows("shihuayuanqu", keyVal, "13"));//石化园区
			map.put("map14", sreachresultservice.shows("gangtieyuanqu", keyVal, "14"));//钢铁配套园区
			map.put("map15", sreachresultservice.shows("zhongyangshangwu", keyVal, "15"));//中央商务区
		}else if("1".equals(type)){
			map.put("map1", sreachresultservice.shows("touzidongtai", keyVal, "1"));//投资动态
		}else if("2".equals(type)){
			map.put("map2", sreachresultservice.shows("xinwenmeijie", keyVal, "2"));//新闻媒介
		}else if("3".equals(type)){
			map.put("map3", sreachresultservice.shows("liaojiewomen", keyVal, "3"));//了解我们
		}else if("4".equals(type)){
			map.put("map4", sreachresultservice.shows("touzixiangmu", keyVal, "4"));//投资项目
		}else if("5".equals(type)){
			map.put("map5", sreachresultservice.shows("touzizhengce", keyVal, "5"));//投资政策
		}else if("6".equals(type)){
			map.put("map6", sreachresultservice.shows("touzichengben", keyVal, "6"));//投资成本
		}else if("7".equals(type)){
			map.put("map7", sreachresultservice.shows("zhongdianqiye", keyVal, "7"));//重点企业
		}else if("8".equals(type)){
			map.put("map8", sreachresultservice.shows("touziliucheng", keyVal, "8"));//投资流程
		}else if("9".equals(type)){
			map.put("map9", sreachresultservice.shows("zhinengbumen", keyVal, "9"));//职能部门联系
		}else if("10".equals(type)){
			map.put("map10", sreachresultservice.shows("touzimulu", keyVal, "10"));//投资目录
		}else if("11".equals(type)){
			map.put("map11", sreachresultservice.shows("ziliaoxiazai", keyVal, "11"));//资料下载
		}else if("12".equals(type)){
			map.put("map12", sreachresultservice.shows("dayijiehuo", keyVal, "12"));//答疑解惑
		}else if("13".equals(type)){
			map.put("map13", sreachresultservice.shows("shihuayuanqu", keyVal, "13"));//石化园区
		}else if("14".equals(type)){
			map.put("map14", sreachresultservice.shows("gangtieyuanqu", keyVal, "14"));//钢铁配套园区
		}else if("15".equals(type)){
			map.put("map15", sreachresultservice.shows("zhongyangshangwu", keyVal, "15"));//中央商务区
		}
		return map;
	}
	
	/***
	 * 前端搜索
	 */
	@RequestMapping(value = "/getdetails.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getdetails(String dataty, String fdid){
		Map<String, Object> map = new HashMap<String, Object>();
		if("1".equals(dataty)){
			map.put("map1", sreachresultservice.showdetails("touzidongtai", fdid, "1"));//投资动态
		}else if("2".equals(dataty)){
			map.put("map2", sreachresultservice.showdetails("xinwenmeijie", fdid, "2"));//新闻媒介
		}else if("3".equals(dataty)){
			map.put("map3", sreachresultservice.showdetails("liaojiewomen", fdid, "3"));//了解我们
		}else if("4".equals(dataty)){
			map.put("map4", sreachresultservice.showdetails("touzixiangmu", fdid, "4"));//投资项目
		}else if("5".equals(dataty)){
			map.put("map5", sreachresultservice.showdetails("touzizhengce", fdid, "5"));//投资政策
		}else if("6".equals(dataty)){
			map.put("map6", sreachresultservice.showdetails("touzichengben", fdid, "6"));//投资成本
		}else if("7".equals(dataty)){
			map.put("map7", sreachresultservice.showdetails("zhongdianqiye", fdid, "7"));//重点企业
		}else if("8".equals(dataty)){
			map.put("map8", sreachresultservice.showdetails("touziliucheng", fdid, "8"));//投资流程
		}else if("9".equals(dataty)){
			map.put("map9", sreachresultservice.showdetails("zhinengbumen", fdid, "9"));//职能部门联系
		}else if("10".equals(dataty)){
			map.put("map10", sreachresultservice.showdetails("touzimulu", fdid, "10"));//投资目录
		}else if("11".equals(dataty)){
			map.put("map11", sreachresultservice.showdetails("ziliaoxiazai", fdid, "11"));//资料下载
		}else if("12".equals(dataty)){
			map.put("map12", sreachresultservice.showdetails("dayijiehuo", fdid, "12"));//答疑解惑
		}else if("13".equals(dataty)){
			map.put("map13", sreachresultservice.showdetails("shihuayuanqu", fdid, "13"));//石化园区
		}else if("14".equals(dataty)){
			map.put("map14", sreachresultservice.showdetails("gangtieyuanqu", fdid, "14"));//钢铁配套园区
		}else if("15".equals(dataty)){
			map.put("map15", sreachresultservice.showdetails("zhongyangshangwu", fdid, "15"));//中央商务区
		}
		return map;
	}
	
	/***
	 * 登录
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	@ResponseBody
	public boolean chexuser(ServletRequest request, ServletResponse response, String user, String pass){
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpSession session = servletRequest.getSession();
		if("admin".equals(user)&&"123456".equals(pass)){
			session.setAttribute("UserName", "admin");
			return true;
		}
		return false;
	}
	
	/***
	 * 退出登录
	 */
	@RequestMapping(value = "/outlogin.action", method = RequestMethod.GET)
	@ResponseBody
	public boolean outlogin(ServletRequest request, ServletResponse response, String user, String pass){
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		session.removeAttribute("UserName");
		try {
			servletResponse.sendRedirect("/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 *下载资料 
	 */
	@RequestMapping(value = "/downFile.action", method = RequestMethod.GET)
	@ResponseBody
	public boolean down(String idstr, HttpServletRequest request, HttpServletResponse response){
		List<ZiLiaoXiaZaiBean> ltz = touzidongtaiservice.getList(idstr);
		ZiLiaoXiaZaiBean tb = ltz.get(0);
		String filename = tb.getFileUrl();
		filename = filename.substring(filename.lastIndexOf("/")+1,filename.length());
		try{    
			String savePath = request.getSession().getServletContext().getRealPath("uploadFile");
	        File file = new File(savePath+"/"+filename);
	        InputStream fis = new BufferedInputStream(new FileInputStream(savePath+"/"+filename));    
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);    
	        fis.close();    
	        response.reset();    
	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());    
	        response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes(), "UTF-8"));    
	        toClient.write(buffer);    
	        toClient.flush();    
	        toClient.close();    
	        response.setContentType("application/octet-stream");    
	        response.addHeader("Content-Length", String.valueOf(file.length()));  
	    } catch (SocketException e){
	    	e.printStackTrace();
	    } catch (IOException ex){
	    	ex.printStackTrace();
	    }
		return false;
	}
}
