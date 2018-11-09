package com.snow.www.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 作用：过滤字符，
 *  在HttpServletRequest到达Servlet之前，拦截客户的HttpServletRequest。
   根据需要检查HttpServletRequest，也可以修改HttpServletRequest头和数据。
   在HttpServletResponse到达客户端之前，拦截HttpServletResponse。
   根据需要检查HttpServletResponse，也可以修改HttpServletResponse头和数据
记录日志

 * 用法：filter可以选择实现filter或者继承已有的filter，封装添加自己特性，比如某些请求不强制转码
 * web服务器根据Filter在web.xml文件中的注册顺序，决定先调用哪个Filter
 * 1.一般filter都是一个链,web.xml 里面配置了几个就有几个。一个一个的连在一起 
request -> filter1 -> filter2 ->filter3 -> …. -> request resource.

2.chain.doFilter将请求转发给过滤器链下一个filter , 如果没有filter那就是你请求的资源，基于函数回调

 * @author LiHuaSheng
 *
 */
public class WebCharacterEncodingFilter extends CharacterEncodingFilter{

	private String exclude;

	public String getExclude() {
		return this.exclude;
	}

	public void setExclude(String exclude) {
		this.exclude = exclude;
	}

	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("==============filter1==============");
		String url = request.getRequestURL().toString();
		if ((url != null) && (url.indexOf(this.exclude) != -1))
			filterChain.doFilter(request, response);
		else
			super.doFilterInternal(request, response, filterChain);
	}



	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
