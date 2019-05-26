package model.entities;

public class Player {
	
	private String name;
	private Gender gender;
	private int age;
	private int resistence;
	private int aim;
	private int exp;
	private int lucky;
	
	public Player(String name, Gender gender, int age, int resistence, int aim, int exp, int lucky) {
		this.gender = gender;
		this.age = age;
		this.resistence = resistence;
		this.aim = aim;
		this.exp = exp;
		this.lucky = lucky;
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
	public int getLucky() {
		return lucky;
	}
	public void setLucky(int lucky) {
		this.lucky = lucky;
	}
}