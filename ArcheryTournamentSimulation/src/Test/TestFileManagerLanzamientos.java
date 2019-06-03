package Test;

import java.io.IOException;

import persistence.FileManager;

public class TestFileManagerLanzamientos {
	
	public static void main(String[] args) {
		try {
			for (int i = 0; i < FileManager.readFileLanzamientos().size(); i++) {
				System.out.println(i+ "-->" + FileManager.readFileLanzamientos().get(i));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
