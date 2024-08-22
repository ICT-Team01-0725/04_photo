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

public class Ex_Cup {
	public static void main(String[] args) {
		// InputStream
		Path path = Paths.get("D:", "pyc" , "cup.jpg");
		String pathName = path.toString();
		File file = new File(pathName);
		// OutputStream
		Path path2 = Paths.get("D:", "pyc" , "util", "cup.jpg");
		String pathName2 = path2.toString();
		File file2 = new File(pathName2);
		
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(file2);
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			byte[] b = new byte[(int)file.length()];
			bis.read(b);
			bos.write(b);
			bos.flush();
			
			// file을 close해야 delete가 작동함.
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
			}
		
		boolean b = file.delete();
		System.out.println(b);
	}
}
