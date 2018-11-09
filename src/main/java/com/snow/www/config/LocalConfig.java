package com.snow.www.config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**JAVA里面对于类进行调用配置资源的文件数据，以this.getClass().getResourceAsStream()来读取比较合适。
 * 获取配置文件的目录
 * @author LiHuaSheng
 *
 */
public class LocalConfig {
	public static String configPath = new LocalConfig().getConfigPath();
	
	/**
	 * 加载本服务器配置文件
	 */
	public String getConfigPath()
	{
	    InputStream is = null;
	    InputStreamReader reader = null;
	    try
	    {
	    	 System.out.println("load LocalProperties Start========================================");

	         is = getClass().getResourceAsStream("/local.properties");
	        if (is != null)
	        {
	            System.out.println("load LocalProperties Success end ========================================");
	        }
	        else
	        {
	        	 System.out.println("load LocalProperties Error end ========================================");
	        }

	        reader = new InputStreamReader(is, "UTF-8");
	        Properties localProps = new Properties();
	        localProps.load(reader);

	        
	        return localProps.getProperty("configdir");
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	        return "";
	    }
	    finally
	    {
	        if (is != null)
	        {
	            try
	            {
	                is.close();
	                is = null;
	            }
	            catch (Exception e)
	            {
	            	 e.printStackTrace();
	            }
	        }
	        if (reader != null)
	        {
	            try
	            {
	                reader.close();
	                reader = null;
	            }
	            catch (Exception e)
	            {
	               e.printStackTrace();
	            }
	        }
	    }
	}
}
