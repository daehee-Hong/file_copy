package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
        System.out.println("복사할 파일 이름을 확장자까지 입력해주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = br.readLine();
            br.close();
            // 현재 폴더 조회
            String currentPath = System.getProperty("user.dir");

            if (fileName == null || "".equals(fileName)){
                System.out.println("파일이름을 다시 입력해주세요");
                return;
            }
            // 파일 복사
            Path sourcePath = Path.of(currentPath, fileName);
            Path copyPath = Path.of(currentPath, "2_" + fileName);
            Files.copy(sourcePath, copyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("파일 복사 완료");
        }catch (IOException e){
            System.err.println("파일 복사 실패 : " +e.getMessage());
        }

    }
}