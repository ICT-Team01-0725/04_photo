package com.ict.team01.photo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Developers : 김경서 & 김우현 & 박영찬
//주석으로 파트별 아이데이션을 올린 분의 이름을 적었습니다.
//자세한 과정이 궁금하신 분은 Request를 확인해주세요.

//[ 특징 ]
// 저장된 파일, 저장할 파일의 경로를 직접적인 경로로 지정합니다.
// 파일복사 > 파일 경로에 따른 여러 메서드를 작성합니다. (try~catch)
// 파일삭제 > delete 메서드를 이용합니다. (if~else)

public class Photo00 {
	public static void main(String[] args) {

	// 01. 파일을 읽고 쓰는 경로 > 김경서

		File src = new File("C:/Users/ict-00/Downloads/bear.jpg");  // 저장되어 있는 파일의 경로
		File dist = new File("D:/userID/util/bear_copy.jpg");		// 저장될 파일의 경로

		copyFile(src, dist);

		deleteFile(src);
	}
	
	// 02. 파일복사 / try~catch, Stream 이용 > 팀 전원 ~ 김경서 수정
	
	private static void copyFile(File src, File dist) {
		try (FileInputStream fis = new FileInputStream(src);
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream(dist);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
			bos.flush();
			System.out.println("파일 복사 성공: " + src.getName());

		} catch (IOException e) {
			System.out.println("파일 복사 실패: " + src.getName());
			e.printStackTrace();
		}
	}

	// 03. 파일삭제 / if~else, delete 메서드 > 김우현 & 박영찬
	
	private static void deleteFile(File file) {
		if (file.delete()) {
			System.out.println("파일 삭제 성공: " + file.getName());
		} else {
			System.out.println("파일 삭제 실패: " + file.getName());
		}
	}
}
