package personal.project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class photo_02 {
	public static void main(String[] args) {
		// C:\woohyun96\bear.jpg => utill 폴더로 복사
		// C:\woohyun96\bear.jpg => utill 폴더로 잘라내기
		
		// 파일 만들 경로 지정 : path
		Path path = Paths.get("C:", "woohyun96", "bear_new.jpg");
		String pathName = path.toString();
		File in_file = new File(pathName);
		
		Path path2 = Paths.get("C:", "woohyun96", "utill", "bear_new.jpg");
		String pathName2 = path2.toString();
		File out_file = new File(pathName2);
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream(in_file);
			bis = new BufferedInputStream(fis);
			
			fos = new FileOutputStream(out_file);
			bos = new BufferedOutputStream(fos);
			
			// [2번 방법]
			
			// length() : 파일의 크기를 byte 로 변환
			byte[] b = new byte[(int)(in_file.length())];
			// 파일 내용을 읽어서 byte[] b에 넣어주세요.
			fis.read(b);
			// 배열로 받은 b 값을 출력할 때 for/for each 돌리기
			for (byte k : b) {
				bos.write(k); // k값을 출력
			}
			
			bos.flush(); // 한 글자씩 출력된 값을 받아서 bos.flush();가 값을 전송해준다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 모든 조건이 끝났을 시 종료해준다.
				bos.close();
				fos.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 기존 파일 삭제 (잘라내기)
		in_file.delete();
		
		
	}
}
