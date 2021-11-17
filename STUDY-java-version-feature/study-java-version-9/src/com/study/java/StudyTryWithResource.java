package com.study.java;

import java.io.FileInputStream;
import java.io.IOException;

public class StudyTryWithResource {
	public static void main(String[] args) throws IOException {
//		FileInputStream fIn = new FileInputStream("test.txt");
//		try (FileInputStream fInForTWR = fIn) {
//			System.out.println(fInForTWR.available());
//		}
//		System.out.println(fIn.available());

		FileInputStream fIn = new FileInputStream("test.txt");
		try (fIn) {
			System.out.println(fIn.available());
		}
		System.out.println(fIn.available());
	}
}
