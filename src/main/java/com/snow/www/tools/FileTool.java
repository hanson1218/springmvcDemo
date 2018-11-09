package com.snow.www.tools;

import java.io.File;

public class FileTool {
	private static volatile FileTool instance;

	public static FileTool getinstance() {
		if (instance == null) {
			synchronized (FileTool.class) {
				if (instance == null) {
					instance = new FileTool();
				}
			}
		}
		return instance;
	}
	
	public boolean fileExists(String filePath) {
		File file = null;
		try {
			file = new File(filePath);
			if (file.exists()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
}
