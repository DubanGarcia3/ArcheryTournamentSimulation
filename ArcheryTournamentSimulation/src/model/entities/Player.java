package model.entities;

import java.util.ArrayList;

import dao.Manager.ManagerShot;

public class Player {
	
	private String name;
	private Gender gender;
	private int age;
	private int resistence;
	private int aim;
	private int exp;
	private double lucky;
	private ArrayList<Shot> listShots;
	
	public Player(String name, Gender gender, int age, int resistence, int aim, int exp, double lucky) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.resistence = resistence;
		this.aim = aim;
		this.exp = exp;
		this.lucky = lucky;
		listShots = new ArrayList<Shot>();
	}
	
	public void addShot(ManagerShot managerShot) {
		listShots.add(managerShot.getRandomShot());
	}
/**
 * Genera la distancia total de los disparos de 1 SOLO jugador
 * @return
 */
	public double getTotalDistance() {
		double aux = 0;
		for (int i = 0; i < listShots.size(); i++) {
			aux += listShots.get(i).calculateDistance();
		}
		return aux;
	}
/**
 * Genera disparos hasta que la resistencia del jugador se termine	
 * @param managerShot
 */
	public void shoot(ManagerShot managerShot) {
		int auxResistance = this.resistence;
		while (auxResistance >= 4) {
			listShots.add(managerShot.getRandomShot());
			auxResistance -=4;
		}
	}
/**
 * Incrementa la experiencia para alguien que tiene mas de 18 de experiencia	
 */
	public void incrementDistance() {
		if (exp >= 18) {
			for (int i = 0; i < listShots.size(); i++) {
				listShots.get(i).incrementDistance(0.025); 
			}
		}
	}
/**
 * Afecta los disparos dependiendo del clima
 * @param weather
 */
	public void calculateShootsOnWeather(String weather) {
		if (weather.equals("Lluvioso")) {
			for (int i = 0; i < listShots.size(); i++) {
				listShots.get(i).decrementDistance(0.08);
			}
		}else if (weather.equals("Viento")) {
			for (int i = 0; i < listShots.size(); i++) {
				listShots.get(i).decrementDistance(0.04);
			}
		}
	}
/**
 * Incrementa la experiencia del jugador en 2
 */
	public void incrementEXP() {
		exp = exp+2;
	}
	
	public ArrayList<Shot> getListShots() {
		return listShots;
	}

	public void setListShots(ArrayList<Shot> listShots) {
		this.listShots = listShots;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getResistence() {
		return resistence;
	}
	public void setResistence(int resistence) {
		this.resistence = resistence;
	}
	public int getAim() {
		return aim;
	}
	public void setAim(int aim) {
		this.aim = aim;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public double getLucky() {
		return lucky;
	}
	public void setLucky(double lucky) {
		this.lucky = lucky;
	}

	@Override
	public String toString() {
		return "" + name + " gender=" + gender + " age=" + age + " resistence=" + resistence + " aim="
				+ aim + "  exp=" + exp + " lucky=" + lucky ;
	}
}