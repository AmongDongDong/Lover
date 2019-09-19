package com.lover.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class FileCopy {

	/**
	 * 文件复制的方法
	 * @param sourcePath
	 * @param detainPath
	 * @throws IOException
	 */
	public static void copyTxtFileBuffer(String sourcePath ,String detainPath ) throws IOException {
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(
						new File(sourcePath)));
		
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(
						new File(detainPath)));
		byte [] b = new byte[1024];
		while(true){
			int len = bis.read(b);
			if(len == -1 ){
				break;
			}
			bos.write(b,0,len);
		}
		bis.close();
		bos.close();
		
	}
}
