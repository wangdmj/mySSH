package com.mySSH.web.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DownloadUtils {
    public String download(String fileName,String filepath, HttpServletRequest request, HttpServletResponse response)  
            throws Exception {  
  
        response.setContentType("text/html;charset=utf-8");  
        request.setCharacterEncoding("UTF-8");  
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
  
        String downLoadPath =request.getSession().getServletContext().getRealPath(  
                "/")  
                + "\\" + filepath; 
        try {  
            long fileLength = new File(downLoadPath).length();  
            response.setContentType("application/x-msdownload;");  
            response.setHeader("Content-disposition", "attachment; filename="  
                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));  
            response.setHeader("Content-Length", String.valueOf(fileLength));  
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
            bos = new BufferedOutputStream(response.getOutputStream());  
            byte[] buff = new byte[2048];  
            int bytesRead;  
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
                bos.write(buff, 0, bytesRead);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bis != null)  
                bis.close();  
            if (bos != null)  
                bos.close();  
        }  
        return null;  
    }
}
