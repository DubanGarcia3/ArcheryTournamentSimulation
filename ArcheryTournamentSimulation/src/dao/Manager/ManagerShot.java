package dao.Manager;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import model.entities.Shot;
import persistence.FileManager;

public class ManagerShot {
	
	private List<Shot> listshot;

	public ManagerShot() {
		this.listshot = new ArrayList<Shot>();
	}
	
	public void addFromPersistence() {
		try {
			for (int i = 0; i < FileManager.readFileLanzamientos().size(); i++) {
				if (FileManager.readFileLanzamientos() != null) {
					listshot.add(this.createShot(FileManager.splitLine(FileManager.readFileLanzamientos().get(i), ",")));
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public Shot getRandomShot() {
		int a =(int) ((Math.random() * 199)+0);
		System.out.println(a);
		return listshot.get(a);
	}

	public Shot createShot(String []shot) {
		return new Shot(Double.parseDouble(shot[0]), Double.parseDouble(shot[1]));
	}
}