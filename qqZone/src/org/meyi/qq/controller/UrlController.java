package org.meyi.qq.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.meyi.qq.dao.UrlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/url")
public class UrlController implements ServletContextAware {

	@Autowired
	UrlDao urlDao;
	
private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext  = context;
	}

	@RequestMapping(value="/getDefaultUrl")
	public ModelAndView getDefaultUrl(HttpServletRequest request){
		System.out.println("in getDefaultUrl()");
		//原始的4个网址
		List<Map> list = urlDao.findBySql("select * from url_tag where userId=1", 1, 20);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		ModelAndView model = new ModelAndView("url/url_tag");
		model.addObject("list",list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", "11");
		List<Map> list1 = urlDao.findBySql("select * from url_tag where userId=:userId", map, 1, 20);
		model.addObject("list1", list1);
		System.out.println("list1=="+list.size());
		return model;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(String url, String urlName,@RequestParam(required=false) CommonsMultipartFile file){
		if (!file.isEmpty()) {
			   String path = this.servletContext.getRealPath("/tmp/");  //获取本地存储路径
			   System.out.println(path);
			   String fileName = file.getOriginalFilename();
			   String fileType = fileName.substring(fileName.lastIndexOf("."));
			   System.out.println(fileType); 
			   File file2 = new File(path,new Date().getTime() + fileType); //新建一个文件
			   try {
				    file.getFileItem().write(file2); //将上传的文件写入新建的文件中
			   } catch (Exception e) {
				    e.printStackTrace();
			   }
			}else{
				
			}
//		return "";
		return "redirect:/url/getDefaultUrl";
	}
}
;