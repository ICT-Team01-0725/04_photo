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

public class photo_03 {
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
			
			// [3번 방법]
			int b = 0;
			
			while (true) {
				b = fis.read();
				
				// read는 int 형이며 만약 읽을 수가 없으면 -1 이 나온다.
				// 그래서 fis.read() 읽었을 때 -1 이 나오면 해당 while문을 종료해라
				if (b == -1) {
					break;
				}
				
				
				bos.write(b); // b값을 출력
			}
			
			bos.flush(); // 한 글자씩 출력된 값을 받아서 bos.flush();가 값을 출력해준다.
			
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
