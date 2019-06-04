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
	}

	public List<Weather> getListWeather() {
		List<Weather> list = new ArrayList<>();
		try {
			List<String> aux = FileManager.readFileWeather();
			for (int i = 0; i < aux.size(); i++) {
				if (Double.parseDouble(aux.get(i)) >= 3 && Double.parseDouble(aux.get(i)) <=48) {
					list.add(new Weather("Lluvioso"));
				}else if (Double.parseDouble(aux.get(i)) >= 48 && Double.parseDouble(aux.get(i)) <=100) {
					list.add(new Weather("Soleado"));
				}else if (Double.parseDouble(aux.get(i)) < 3) {
					
					list.add(new Weather("Viento"));
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}