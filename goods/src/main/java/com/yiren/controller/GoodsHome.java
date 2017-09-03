package com.yiren.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.yiren.entity.GoodsInfo;
import com.yiren.entity.MyUsers;
import com.yiren.service.GoodsInfoService;
import com.yiren.service.MyUserService;
import com.yiren.utils.Log;
//import com.yiren.utils.Log;
import com.yiren.utils.MD5Utils;

@Controller
//requestMapping("/home")
@RequestMapping("/")
public class GoodsHome {
	@Resource
	private GoodsInfoService goodsInfoService;
	@Autowired
	private HttpServletRequest request;
	public GoodsInfoService getGoodsInfoService() {
		return goodsInfoService;
	}
	public void setGoodsInfoService(GoodsInfoService goodsInfoService) {
		this.goodsInfoService = goodsInfoService;
	}

	@Resource
	private  MyUserService myUserService;	
	public MyUserService getMyUserService() {
		return myUserService;
	}
	public void setMyUserService(MyUserService myUserService) {
		this.myUserService = myUserService;
	}
	@RequestMapping("/loginjsp")
	public String loginjsp( ){
	//	Log.out().info("login.jsp");
		return "login";
	}
	@RequestMapping("/loginmapping")
    public String login(MyUsers myuser){    	
    	String pwd1=myuser.getPassword();  
    	String name1=myuser.getLoginname();
    	MyUsers users=new MyUsers();
    	users.setLoginname(name1);    	
    	String jsp="";
    	MyUsers us=myUserService.queryMyUsersByname(users);
    	if(us==null){
    		jsp="error";
    		return "operation";
    	}
    	String pwd2=us.getPassword();  
        MD5Utils cipher = new MD5Utils();  
       //将123加密  
      //  pwd2 = cipher.generatePassword(pwd1);  
        if(cipher.validatePassword(pwd2, pwd1)) {        
        	Log.out().info(name1+"在"+System.currentTimeMillis()+"登录了");
        	jsp="operation";
        }  
        else {  
            jsp="error"; 
        }  	
        return "operation";
    	
    }
	@RequestMapping("/selectStyle")
	public @ResponseBody void selectStyle(PrintWriter pri){		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", 1);
		map.put("text", "11");
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("id", 2);
		map2.put("text", "22");
		map2.put("selected", true);
		Map<String,Object> map3=new HashMap<String,Object>();
		map3.put("id", 3);
		map3.put("text", "33");
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(map);
		list.add(map2);
		list.add(map3);
		String json=JSONArray.toJSONString(list);

		pri.write(json);
		
	}
	@RequestMapping("/fileUp")
	public @ResponseBody String fileUp(@RequestParam(value="pictureurl") MultipartFile file,HttpServletRequest request,ModelMap model){
	
	String path=	request.getSession().getServletContext().getRealPath("upload");
		
		String filename=file.getOriginalFilename();
		File targetFile=new File(path, filename);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}	
			try {
				file.transferTo(targetFile);
			} catch (IllegalStateException | IOException e) {				
				e.printStackTrace();
			}
			String url= request.getContextPath()+"/upload/"+filename;
	
		return url;
	}
	@RequestMapping("/submitData")
	public @ResponseBody String submitData(GoodsInfo info){
		int i=goodsInfoService.insertGoodsInfo(info);
		System.out.println(i);
		String re="";
		re=i>0?"suc":"err";
		System.out.println(re);
		return re;
		
	}
	@RequestMapping(value="/queryUsers")
public String queryUsers(){
	//List<MyUsers> list=	myUserService.queryMyUsers();
		GoodsInfo goodsInfo=new GoodsInfo();
	List<GoodsInfo> infoList=goodsInfoService.findGoodsInfo(goodsInfo);
	request.setAttribute("infoList", infoList);
	//临时新增数据
	for (int i = 1; i < 8; i++) {
		GoodsInfo goodsInfo2=new GoodsInfo();
		goodsInfo2.setName("商品"+i);
		goodsInfo2.setPrice(12.00);
		goodsInfo2.setPictureurl("image_"+i+".jpg");
		goodsInfo2.setState(1);
		goodsInfoService.insertGoodsInfo(goodsInfo2);
			
	}
	return "home";
}

	@RequestMapping("/hello")
	public String helloWord(){	
	System.out.println("访问 我的  SpringMvc成功了 !");	
	MyUsers myUser=new MyUsers();	
	myUser.setLoginname("ROOT");
	myUser.setNickname("root");
	myUser.setPassword("1qaz@WSX");
	myUser.setPhone("130");
	myUser.setState(0);	
	
	this.myUserService.insertMyUsers(myUser);
	return "home";
	}
	

}
