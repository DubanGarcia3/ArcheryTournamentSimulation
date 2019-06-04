package model.entities;

import java.util.ArrayList;

import dao.Manager.ManagerShot;
import model.entities.Team;

public class Match {
	
	private Team team1;
	private Team team2;
	private Weather weather;
	private ArrayList<Round> listRound;
	private ManagerShot managerShot;
	
	public Match(Team teamA, Team teamB, ManagerShot managerShot, Weather weather) {
		this.team1 = teamA;
		this.team2 = teamB;	
		this.weather = weather;
		this.managerShot = managerShot;
		this.listRound = new ArrayList<Round>();
	}
	
	public void generateRound() {
		for (int i = 0; i < 20; i++) {
			team1.getPlayerList().get(i).shoot(managerShot);
			team2.getPlayerList().get(i).shoot(managerShot);
		}
	}
	
	public void clearList() {
		for (int i = 0; i < 20; i++) {
			team1.getPlayerList().get(i).getListShots().clear();
			team2.getPlayerList().get(i).getListShots().clear();
		}
	}
	
	public void addRound(double d, int winnerTeam ) {
		listRound.add(new Round(d, winnerTeam));
	}
	
	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public ArrayList<Round> getListRound() {
		return listRound;
	}

	public void setListRound(ArrayList<Round> listRound) {
		this.listRound = listRound;
	}

	public ManagerShot getManagerShot() {
		return managerShot;
	}

	public void setManagerShot(ManagerShot managerShot) {
		this.managerShot = managerShot;
	}
}