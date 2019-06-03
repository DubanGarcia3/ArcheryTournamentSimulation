package model.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import persistence.FileManager;

public class Weather {

	public Weather() {
		
	}
	
	public List<String> getListWeather() {
		List<String> list = new ArrayList<String>();
		try {
			for (int i = 0; i < FileManager.readFileWeather().size(); i++) {
				if (Double.parseDouble(FileManager.readFileWeather().get(i)) >= 3 && Double.parseDouble(FileManager.readFileWeather().get(i)) <=48) {
					list.add("Lluvia");
				}else if (Double.parseDouble(FileManager.readFileWeather().get(i)) >= 48 && Double.parseDouble(FileManager.readFileWeather().get(i)) <=100) {
					list.add("soleado");
				}else if (Double.parseDouble(FileManager.readFileWeather().get(i)) < 3) {
					
					list.add("viento");
				} 
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public void printData() {
		for (int i = 0; i < this.getListWeather().size(); i++) {
			System.out.println(this.getListWeather().get(i).toString());
		}
	}
}
