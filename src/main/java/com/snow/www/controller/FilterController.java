package com.snow.www.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 注意咯！这里不能用@RestController注解,否则controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver也将不起作用，所以 只能用@Controller
 * @author LiHuaSheng
 *
 */
@Controller
public class FilterController {
	
	@RequestMapping("/filter")
	public String useFilter(String name){
		
		return name;
		
	}
	@RequestMapping("/nofilter")
	public String noFilter(String name){
		return name;
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
    public String add(){
		System.out.println("===========================add");
        return "add";
    }
	
	/**
	 * response 可以使用OutputStream流向客户端浏览器输出或者PrintWriter输出，但是同一个response只能被一种方式后获取
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
    public void addPost(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{

        //姓名
        String name=request.getParameter("name");  
        System.out.println("name>>>"+name);
        //国家
        String country=request.getParameter("country"); 
        System.out.println("country>>>"+country);
        //性别
        String sex = request.getParameter("sex"); 
        System.out.println("sex>>>"+sex);

        ServletOutputStream sos = response.getOutputStream();
        byte[] dataByteArr = name.getBytes();
        sos.write(dataByteArr);
        sos.flush();//刷新流  
        sos.close();//关闭流 
      //获取PrintWriter  
//      PrintWriter out = response.getWriter(); 
        /* out.print("name : "+name+"|");  
        out.print("country : "+country+"|");  
        out.print("sex : "+sex); */ 
    }

}
