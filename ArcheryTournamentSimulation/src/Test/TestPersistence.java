package Test;

import java.io.IOException;
import java.util.List;

import persistence.FileManager;

public class TestPersistence {

	public static void main(String[] args) {
		
		try {
			List<String> a = FileManager.readFile();
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
}
