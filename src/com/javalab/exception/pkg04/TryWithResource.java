package com.javalab.exception.pkg04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {

	public static void main(String[] args) {

		FileReader reader = null; // 초기화 안됨

		try {
			reader = new FileReader("c:/filetest/input.txt"); // 파일 열기(자원 오픈)
			int data;
			while ((data = reader.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (FileNotFoundException f) {
			System.out.println("파일이 존재하지 않거나 경로가 잘못되었습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close(); // 파일 닫기
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
