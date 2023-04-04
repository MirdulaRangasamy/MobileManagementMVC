package com.exterro.MobileManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exterro.MobileManagement.entity.Mobile;
import com.exterro.MobileManagement.service.MobileService;

@Controller
public class MobileController {
	
	@Autowired
	private MobileService mobileSvc;
	
	@RequestMapping("index")
	public String getHome() {
		return "index.html";
	}
	
	@RequestMapping("addMobile")
	public String addMobile(Mobile m) {
		System.out.println(m);
		Mobile m1 = mobileSvc.addMobile(m);
		return (m1 !=null)?"success.html":"failure.html";
	}
	
	@RequestMapping("viewMobile")
	@ResponseBody
	public Mobile viewMobile(String imeiNo) {
		return mobileSvc.getMobile(imeiNo);
	}
	
	@RequestMapping("viewAllMobile")
	@ResponseBody
	public List<Mobile> viewAllMobile() {
		return mobileSvc.getAllMobile();
	}
	
	@RequestMapping("updateMobile")
	public String updateMobile(Mobile m) {
		System.out.println(m);
		Mobile m1 = mobileSvc.updateMobile(m);
		return (m1 !=null)?"success.html":"failure.html";
	}
	
	@RequestMapping("deleteMobile")
	@ResponseBody
	public String deleteMobile(String imeiNo) {
		return mobileSvc.deleteMobile(imeiNo);
	}
}
