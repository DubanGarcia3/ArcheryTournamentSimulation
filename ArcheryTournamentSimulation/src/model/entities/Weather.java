package model.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import persistence.FileManager;

public class Weather {
	
	private String name;

	public Weather(String name) {
		this.name = name;
	}
	
	
	public Weather() {
		super();
	}

	public List<Weather> getListWeather() {
		List<Weather> list = new ArrayList<>();
		try {
			for (int i = 0; i < FileManager.readFileWeather().size(); i++) {
				if (Double.parseDouble(FileManager.readFileWeather().get(i)) >= 3 && Double.parseDouble(FileManager.readFileWeather().get(i)) <=48) {
					list.add(new Weather("Lluvia"));
				}else if (Double.parseDouble(FileManager.readFileWeather().get(i)) >= 48 && Double.parseDouble(FileManager.readFileWeather().get(i)) <=100) {
					list.add(new Weather("Soleado"));
				}else if (Double.parseDouble(FileManager.readFileWeather().get(i)) < 3) {
					
					list.add(new Weather("viento"));
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
