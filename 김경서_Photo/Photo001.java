package com.ict.team01.photo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Photo001 {
	public static void main(String[] args) {
		File src1 = new File("C:/Users/ict-08/Downloads/bear.jpg"); 
		File src2 = new File("C:/Users/ict-08/Downloads/cup.jpg"); 
		File dist1 = new File("D:/kkyungseo/util/bear_copy.jpg"); 
		File dist2 = new File("D:/kkyungseo/util/cup_copy.jpg"); 

		copyFile(src1, dist1);
		copyFile(src2, dist2);
	}

	private static void copyFile(File src, File dist) {
		int count;
		FileInputStream fin = null;
		FileOutputStream fos = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bos = null;

		try {
			fin = new FileInputStream(src); 		// 파일 입력 바이트 스트림 연결
			fos = new FileOutputStream(dist); 		// 파일 출력 바이트 스트림 연결
			bin = new BufferedInputStream(fin); 	// 버퍼 입력 스트림 연결
			bos = new BufferedOutputStream(fos);	// 버퍼 출력 스트림 연결

			while ((count = bin.read()) != -1) { 
				bos.write(count);
			}

			System.out.println("파일 복사 성공");		// 복사가 성공한 파일 개수만큼 '파일복사성공' 출력
		} catch (Exception e) {
			System.out.println("파일 복사 실패");
		} finally {
			try {
				if (bin != null)
					bin.close();
				if (bos != null)
					bos.close();
				if (fin != null)
					fin.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				System.out.println("파일을 다시 확인하십시오.");
			}
		}
	}
}
