package com.snow.www.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.snow.www.tools.POIUtils;

/**
 * 使用Kaptcha工具生成验证码，校验验证码可以再session中校验,在构造函数中初始化属性不生效，在servlet中初始化才行
 * @author LiHuaSheng
 *
 */
@RestController
public class ToolController {
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
	
	@RequestMapping("/uploadExcel")
    public boolean uploadExcel(@RequestParam MultipartFile file,HttpServletRequest request) throws IOException {

        if(!file.isEmpty()){
            String filePath = file.getOriginalFilename();
            //windows
            String savePath = request.getSession().getServletContext().getRealPath(filePath);

            //linux
            //String savePath = "/home/odcuser/webapps/file";

            File targetFile = new File(savePath);

            if(!targetFile.exists()){
                targetFile.mkdirs();
            }

            file.transferTo(targetFile);
            return true;
        }

        return false;
    }
	
	@RequestMapping("/createExcel")
	public void createExcel(HttpServletResponse response) throws IOException{
		HSSFWorkbook hb = POIUtils.createExcel();
		OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=details.xls");
        response.setContentType("application/msexcel");
        hb.write(output);
        output.close();
	}
}
