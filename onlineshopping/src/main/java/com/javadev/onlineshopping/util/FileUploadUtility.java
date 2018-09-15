package com.javadev.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH = "H:\\Development\\Project\\Spring\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request,
			MultipartFile file, String code) {
		
		// get the Real Path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		// to make sure all the directories exists
		// if not, please create the directories
		if(!new File(ABS_PATH).exists()){
			// create the directories
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()){
			// create the directories
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			// server upload path
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			// project directory path
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		} catch (IOException e) {}
	}
}
