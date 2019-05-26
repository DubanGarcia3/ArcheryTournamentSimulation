package Test;

import java.io.IOException;

import persistence.FileManager;

public class TestPersistence {

	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		try {
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < fileManager.readFile().size(); i++) {
				System.out.println(fileManager.readFile().get(i));
			}
			long endTime = System.currentTimeMillis() - startTime;
			System.out.println(endTime);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
