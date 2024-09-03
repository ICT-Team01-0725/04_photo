package com.ict.day18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex_Bear {
	public static void main(String[] args) {
		Path path = Paths.get("D:", "pyc" , "bear.jpg");
		String pathName = path.toString();
		File file = new File(pathName);
		Path path2 = Paths.get("D:", "pyc" ,"util", "bear.jpg");
		String pathName2 = path2.toString();
		File file2 = new File(pathName2);
		FileInputStream fis = null;
		FileOutputStream fos = null; 
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			byte[] b = new byte[(int)file.length()];
			bis.read(b);
			
			fos = new FileOutputStream(file2);
			bos = new BufferedOutputStream(fos);
			bos.write(b);
			bos.flush();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				bis.close();
				fos.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
