package com.leon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.leon.bean.Userinfo;
import com.leon.service.UserinfoService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserinfoService userinfoService;

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	
	@RequestMapping(value="/regist",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView regist(){
		System.out.println("跳转注册");
		return new ModelAndView("regist");
	}
	
	@RequestMapping(value="/doRegist",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String doRegist(Userinfo userinfo){
		if(userinfo!=null){
			System.out.println("用户名："+userinfo.getUsername()+"\n密码："+userinfo.getPasswd());
			userinfo.setUserid(System.currentTimeMillis()+"");
			userinfoService.save(userinfo);
			System.out.println("保存成功！");
		}
		return "regist ok!";
	}
	
	@RequestMapping(value="/query",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView query(){
		System.out.println("跳转查询");
		return new ModelAndView("query-user");
	}
	
	
	@RequestMapping(value="/doQuery",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView doQuery(String userid){
		System.out.println("跳转查询");
		Userinfo userinfo = userinfoService.queryById(userid);
		ModelAndView mav = new ModelAndView("query-user-result");
		if(userinfo!=null){
			mav.addObject("userinfo", userinfo);
		}
		return mav;
	}
	
	
}
