package com.snow.www.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;
import org.springframework.util.StringUtils;

import com.snow.www.tools.FileTool;

/**
 * 读取自定义的配置文件，并提供公用方法调用
 * @author LiHuaSheng
 *
 */
public class PropertiesUtil extends PropertyPlaceholderConfigurer{
	
	private boolean ignoreResourceNotFound = false; // 重新定义父类中的这个同名属性
	private PropertiesPersister propertiesPersister = new DefaultPropertiesPersister(); // 重新定义父类中的这个同名属性
	private Resource[] locations;// 重新定义父类中的这个同名属性
	private String fileEncoding; // 配置文件编码
    private String configPath; // 配置文件目录
    private String[] configList; // 配置文件列表
    private static Map<String, String> propertiesMap = new HashMap<String, String>();
    private static final String XML_FILE_EXTENSION="。xml";
    
    public void init() {
        this.configPath = LocalConfig.configPath;
        this.initLocations(this.configPath);
    }
    
    
    /**
     * 自定义加载配置文件方法
     */
    @Override
    protected void loadProperties(Properties props) throws IOException {
    	System.out.println("------------------------");
        // super.loadProperties(props);
         if (this.locations != null) {
            for (Resource location : this.locations) {
            	if (null == location) {
					continue;
				}
                InputStream is = null;
                try {
                    is = location.getInputStream();
                    String filename = null;
                    try {
                        filename = location.getFilename();
                        logger.info("cmd=init:configName | ret=OK | filename="+filename);
                    } catch (IllegalStateException ex) {
                        // resource is not file-based. See SPR-7552.
                        logger.error("cmd=init:configName ｜ret=OK | filename=" + filename + " | msg=load file is fail",ex);
                    }

                    if (filename != null && filename.endsWith(XML_FILE_EXTENSION)) {
                        this.propertiesPersister.loadFromXml(props, is);
                    } else {
                        if (this.fileEncoding != null) {
                            this.propertiesPersister.load(props, new InputStreamReader(is, this.fileEncoding));
                        } else {
                            this.propertiesPersister.load(props, is);
                        }
                    }
                } catch (IOException ex) {
                    if (this.ignoreResourceNotFound) {
                        // if (logger.isWarnEnabled()) {
                        logger.error("cmd=init:config | ret=FAIL | msg=Could not load properties from " + location, ex);
                        // }
                    } else {
                        throw ex;
                    }
                } finally {
                    if (is != null) {
                        is.close();
                    }
                }
            }
            // this.props=props;
        }
    }
    
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
        super.processProperties(beanFactory, props);
        System.out.println("++++++++++++++");
        System.out.println("++++++++++++++"+props.get("key"));
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = resolvePlaceholder(keyStr, props, SYSTEM_PROPERTIES_MODE_NEVER);
            propertiesMap.put(keyStr, value);
            System.out.println("++++++++++++++++++++++"+propertiesMap.toString());
            //按公司安全规范，密码配置项不输出到日志文件  
            if(isPasswordField(keyStr)){
                logger.info(String.format("cmd=init:config | key=%s | value=****** | msg=load propertie key/value in map",keyStr,"**"));
            }else{
                logger.info(String.format("cmd=init:config | key=%s | value=%s | msg=load propertie key/value in map",keyStr,value));
            }
        }
    }
    
    /**
     * 以String型获取配置文件中指定key的值，获取失败默认将返回　""
     * 
     * @param name 配置文件中的key值
     * @return
     */
    public static String getProperty(String name) {
        if (!StringUtils.isEmpty(name)) {
            String val = propertiesMap.get(name);
            return (!StringUtils.isEmpty(val)) ? val.trim() : "";
        } else {
            return "";
        }
    }
    
    private static boolean isPasswordField(String keystr){
        String key = keystr.toLowerCase();
        return (key.indexOf("superpwd")>0 || key.indexOf("password")>0 ||  key.indexOf("pwd")>0);
    }
    
    protected void initLocations(String configPath) {
        if (FileTool.getinstance().fileExists(configPath)) {
            this.locations = new FileSystemResource[configList.length];
            String[] loadfiles = new String[configList.length];
            
            for (int i = 0; i < configList.length; i++) {
                String file = configList[i];
                String fp = this.configPath + file;
                
                File f = new File(fp);
                if (null == f || !f.exists())  continue;
				
                loadfiles[i] = file;
                Resource location = new FileSystemResource(fp).createRelative(file);
                this.locations[i] = location;
            }
            logger.info(String.format("cmd=init:configPath | ret=OK | fileEncoding=%s | path=%s | success loaded=%s | msg=config path load ok.", this.fileEncoding, configPath, Arrays.asList(loadfiles)));
        } else {
            logger.error("cmd=init:configPath | ret=FAIL | fileEncoding=" + this.fileEncoding +" | path="+configPath+" | msg=Config Path is not exists.");
        }

    }


	public String getFileEncoding() {
		return fileEncoding;
	}


	public void setFileEncoding(String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}


	public String getConfigPath() {
		return configPath;
	}


	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}


	public String[] getConfigList() {
		return configList;
	}


	public void setConfigList(String[] configList) {
		this.configList = configList;
	}
    
}
