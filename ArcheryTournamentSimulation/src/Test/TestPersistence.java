package Test;

import java.awt.List;
import java.io.IOException;

import model.entities.Shot;
import persistence.FileManager;

public class TestPersistence {

	public static void main(String[] args) {
		
		FileManager fileManager = new FileManager();
		try {
			java.util.List<String> a = FileManager.readFile();
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
}
