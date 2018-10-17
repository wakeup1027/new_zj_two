package com.lxq.controller.framework;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lxq.beans.TouZiDongTaiBean;
import com.lxq.service.framework.TouZiDongTaiService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/framework/admin")
public class TouZiDongTaiController {
	private static final int FILE_SIZE = 16*1024;  //16K
	
	@Autowired
	private TouZiDongTaiService touzidongtaiservice;
	
	@RequestMapping(value = "/listTouZiDongTai.action", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map = touzidongtaiservice.shows(page, limit);
		return map;
	}
	
	@RequestMapping(value = "/delTouZiDongTai.action", method = RequestMethod.POST)
    @ResponseBody
    public boolean del(String id){
		TouZiDongTaiBean tzdb = new TouZiDongTaiBean();
		tzdb.setId(id);
		boolean tyri = touzidongtaiservice.delbean(tzdb);
		return tyri;
	}
	
	@RequestMapping(value = "/addTouZiDongTai.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean add(TouZiDongTaiBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzidongtaiservice.add(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/updTouZiDongTai.action", method = RequestMethod.POST)
    @ResponseBody
	public boolean upd(TouZiDongTaiBean tztb){
		tztb.setCreatime(new Timestamp(new Date().getTime()));
		try{
			touzidongtaiservice.up(tztb);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@RequestMapping(value = "/getTouZiDongTai.action", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> get(String daid){
		Map<String, Object> map = touzidongtaiservice.get(daid);
		return map;
	}
	
	@RequestMapping(value = "/addImages.action", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addMyText(@RequestParam(value="fenMian") MultipartFile[] file, HttpServletRequest request){
		JSONObject JONS = new JSONObject();
		String[] urldata = new String[file.length];
		if(null != file && file.length > 0){
			int i = 0;
			for(MultipartFile filone : file){
				//自定义输出路径
				String fileName = filone.getOriginalFilename();  //获取到上传文件的文件名
				String fileType = fileName.substring(fileName.lastIndexOf(".")); //获取到上传文件的类型
				String chuangeName = System.currentTimeMillis()+fileType;
				String path = request.getSession().getServletContext().getRealPath("uploadImg"); //设置保存路径
				File filePath = new File(path);
				if (!filePath.exists() && !filePath.isDirectory()) {
					filePath.mkdir();
				}
				String savePath = path+File.separator+chuangeName;
				InputStream inp = null;
				OutputStream out = null;
				try {
					inp = filone.getInputStream();
					
					/*创建输出文件流*/
					File files =  new File(savePath);
					FileOutputStream fout = new FileOutputStream(files);
					out = new BufferedOutputStream(fout); //指定缓冲区大小
					
					/*分解输入文件流*/
					byte[] buffer = new byte[FILE_SIZE];
					int length = 0;
					while((length = inp.read(buffer))>0){
						out.write(buffer, 0, length);  //开始写入到输出文件流
					}

					urldata[i]="/uploadImg/"+chuangeName;
					JONS.put("errno", 0);
					i++;
				} catch (IOException e1) {
					e1.printStackTrace();
					JONS.put("errno", 1);
					break;
				} finally{
					try {
						inp.close();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		JONS.put("data", urldata);
		return JONS;
	}
	
	@RequestMapping(value = "/addFile.action", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addFile(@RequestParam(value="fenMian") MultipartFile[] file, HttpServletRequest request){
		JSONObject JONS = new JSONObject();
		String[] urldata = new String[file.length];
		if(null != file && file.length > 0){
			int i = 0;
			for(MultipartFile filone : file){
				//自定义输出路径
				String fileName = filone.getOriginalFilename();  //获取到上传文件的文件名
				String fileType = fileName.substring(fileName.lastIndexOf(".")); //获取到上传文件的类型
				String chuangeName = System.currentTimeMillis()+fileType;
				String path = request.getSession().getServletContext().getRealPath("uploadFile"); //设置保存路径
				File filePath = new File(path);
				if (!filePath.exists() && !filePath.isDirectory()) {
					filePath.mkdir();
				}
				String savePath = path+File.separator+chuangeName;
				InputStream inp = null;
				OutputStream out = null;
				try {
					inp = filone.getInputStream();
					
					/*创建输出文件流*/
					File files =  new File(savePath);
					FileOutputStream fout = new FileOutputStream(files);
					out = new BufferedOutputStream(fout); //指定缓冲区大小
					
					/*分解输入文件流*/
					byte[] buffer = new byte[FILE_SIZE];
					int length = 0;
					while((length = inp.read(buffer))>0){
						out.write(buffer, 0, length);  //开始写入到输出文件流
					}

					urldata[i]="/uploadFile/"+chuangeName;
					JONS.put("errno", 0);
					i++;
				} catch (IOException e1) {
					e1.printStackTrace();
					JONS.put("errno", 1);
					break;
				} finally{
					try {
						inp.close();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		JONS.put("data", urldata);
		return JONS;
	}
	
	@RequestMapping(value = "/addVideo.action", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addVideo(@RequestParam(value="fenMian") MultipartFile[] file, HttpServletRequest request){
		JSONObject JONS = new JSONObject();
		String[] urldata = new String[file.length];
		if(null != file && file.length > 0){
			int i = 0;
			for(MultipartFile filone : file){
				//自定义输出路径
				String fileName = filone.getOriginalFilename();  //获取到上传文件的文件名
				String fileType = fileName.substring(fileName.lastIndexOf(".")); //获取到上传文件的类型
				String chuangeName = System.currentTimeMillis()+fileType;
				String path = request.getSession().getServletContext().getRealPath("uploadVideo"); //设置保存路径
				File filePath = new File(path);
				if (!filePath.exists() && !filePath.isDirectory()) {
					filePath.mkdir();
				}
				String savePath = path+File.separator+chuangeName;
				InputStream inp = null;
				OutputStream out = null;
				try {
					inp = filone.getInputStream();
					
					/*创建输出文件流*/
					File files =  new File(savePath);
					FileOutputStream fout = new FileOutputStream(files);
					out = new BufferedOutputStream(fout); //指定缓冲区大小
					
					/*分解输入文件流*/
					byte[] buffer = new byte[FILE_SIZE];
					int length = 0;
					while((length = inp.read(buffer))>0){
						out.write(buffer, 0, length);  //开始写入到输出文件流
					}

					urldata[i]="/uploadVideo/"+chuangeName;
					JONS.put("errno", 0);
					i++;
				} catch (IOException e1) {
					e1.printStackTrace();
					JONS.put("errno", 1);
					break;
				} finally{
					try {
						inp.close();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		JONS.put("data", urldata);
		return JONS;
	}
}
