package com.snow.www.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 使用Kaptcha工具生成验证码，校验验证码可以再session中校验,在构造函数中初始化属性不生效，在servlet中初始化才行
 * @author LiHuaSheng
 *
 */
@RestController
public class CheckCodeController {
//	@Autowired
	@Resource(name="captchaProducerTest")
	private Producer captchaProducer;

	@RequestMapping("/kaptcha.jpg")
	public ModelAndView  getCheckCode(HttpServletRequest request, HttpServletResponse response) throws IOException {   
		
		response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
		
		String codeStr = captchaProducer.createText();
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, codeStr);
		BufferedImage bi = captchaProducer.createImage(codeStr);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
	}
}
