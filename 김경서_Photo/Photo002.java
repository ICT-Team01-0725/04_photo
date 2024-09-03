package com.ict.team01.photo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Photo002 {
	public static void main(String[] args) {
		File src1 = new File("C:/Users/ict-08/Downloads/bear.jpg"); 
		File src2 = new File("C:/Users/ict-08/Downloads/cup.jpg"); 
		File dist1 = new File("D:/kkyungseo/util/bear_copy.jpg"); 
		File dist2 = new File("D:/kkyungseo/util/cup_copy.jpg"); 
		
		try {
			Files.copy(src1.toPath(),dist1.toPath(),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Files.copy(src2.toPath(),dist2.toPath(),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
