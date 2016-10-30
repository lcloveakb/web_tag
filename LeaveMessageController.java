package org.qq.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.qq.model.Leavemessage;
import org.qq.model.Wbusers;
import org.qq.model.pageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaveMessage")
public class LeaveMessageController extends SuperController {

	/**
	 * 此控制器用于留言板的相关操作
	 * 负责：刘畅
	 * 编码时  请仔细标上注释 以便后期整合
	 */
	
	private pageBean page_bean;
	
	
	private static final Logger logger =Logger.getLogger(LeaveMessageController.class);
	
	////当用户点击留言板时跳转至功能主页的方法
	@RequestMapping("/toMyLeaveMessage")
	public String toMyLeaveMessage(HttpServletRequest request,String pageNo){
		
		
		logger.info(" toMyLeaveMessage ");
		Integer page_num=pageNo==null?1:Integer.parseInt(pageNo);
		Wbusers user = (Wbusers) request.getSession().getAttribute("wbusers");
		page_bean = leaveMessageService.getLeaveMessageListById(user.getUserId(), page_num, 7);
		request.setAttribute("page", page_bean);
		return "leaveMessage";
	}
	
	
	
	
	@RequestMapping("/del")
	public String del(Integer id){
		
		logger.info(id);
		leaveMessageService.delete(id);
		return "redirect:/leaveMessage/toMyLeaveMessage";
	}
	
	@RequestMapping("/save")
	public String save(Leavemessage leaveMessage,HttpServletRequest request){
		
		Wbusers user = (Wbusers) request.getSession().getAttribute("wbusers");
		leaveMessage.setFirends(user);
		leaveMessage.setWbusers(user);
		leaveMessageService.save(leaveMessage);
		return "redirect:/leaveMessage/toMyLeaveMessage";
	}

	
}
