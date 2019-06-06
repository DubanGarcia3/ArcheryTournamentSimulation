package dao.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Shot;
import persistence.FileManager;

public class ManagerShot {
	
	private List<Shot> listshot;

	public ManagerShot() {
		this.listshot = new ArrayList<Shot>();
	}
/**
 * Agrega a la lista de disparos un nuevo disparo!	
 */
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
/**
 * Este metodo regresa un disparo aleatorio de la lista de disparos total!	
 * @return
 */
	public Shot getRandomShot() {
		int a =(int) ((Math.random() * 499)+0);
		return listshot.get(a);
	}
/**
 * Crea el disparo desde persistencia
 * @param shot
 * @return
 */
	public Shot createShot(String []shot) {
		return new Shot(Double.parseDouble(shot[0]), Double.parseDouble(shot[1]));
	}
}