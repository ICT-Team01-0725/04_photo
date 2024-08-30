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

public class photo_01 {
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

			/* ============== 읽기 ============== */
			// 위의 코드로 작성한 in_file 파일을 FileInputStream을 통해 읽어올 수 있다.
			fis = new FileInputStream(in_file);
			
			// 보조 스트림을 사용하면 향상된 성능으로 파일을 읽어올 수 있다.
			// 버퍼는 바이트 배열로, 여러 바이트를 저장하여 한 번에 많은 양의 데이터를 입출력할 수 있도록 도와주는 임시저장소이다.
			bis = new BufferedInputStream(fis);
			
			/* ============== 출력 (쓰기) ============== */
			// out_file에 지정된 이름으로 파일에 쓸 파일 출력 스트림을 만든다.
			fos = new FileOutputStream(out_file);
			// 보조 스트림을 사용하면 향상된 성능으로 파일을 읽어올 수 있다.
			bos = new BufferedOutputStream(fos);
			
			
			// [1번 방법]
			int b = 0;
			
			// bis.readLine() 내용을 한줄씩 읽고 =>  b에 넣었을 때 -1 이 아니면 실행
			while ((b = bis.read()) != -1) {
				bos.write(b); // 1이 실행 시 b의 정보를 bos로 읽어온다.
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
