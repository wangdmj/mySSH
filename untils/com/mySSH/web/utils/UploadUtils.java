package com.mySSH.web.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author wangd
 *
 */
public class UploadUtils {
	public String uploadForSingle(MultipartFile file,HttpServletRequest request,String uploadPath) throws IOException{
		if(!file.isEmpty()){
			ServletContext sc = request.getSession().getServletContext();
	        String dir = sc.getRealPath("/"+uploadPath);   
	        String filename = file.getOriginalFilename();    
			FileUtils.writeByteArrayToFile(new File(dir,filename), file.getBytes());
			return filename;
		}
		return null;
	}
	public String photoUploadForSingle(final MultipartFile file,HttpServletRequest request,String uploadPath) throws IOException{
		if(!file.isEmpty()){
			ServletContext sc = request.getSession().getServletContext();
	        final String dir = sc.getRealPath("/"+uploadPath);   
	        final String filename = Math.random()*1000+file.getOriginalFilename().hashCode()+".jpg";
	        File newFile=new File(dir+filename);
	        newFile.createNewFile();
	        new Thread(){
	        	public void run() {
	        		try {
						FileUtils.writeByteArrayToFile(new File(dir,filename), file.getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
	        	};
	        }.start();
			return filename;
		}
		return null;
	}
}
