package dao.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Shot;
import persistence.FileManager;

public class ManagerShot {
	
	private List<Shot> listshot;

	public ManagerShot(List<Shot> listshot) {
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

	public Shot createShot(String []shot) {
		return new Shot(Double.parseDouble(shot[0]), Double.parseDouble(shot[1]));
	}
}