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
		this.managerShot = managerShot;
		this.team1 = teamA;
		this.team2 = teamB;	
		this.weather = weather;
		this.managerShot = managerShot;
	}
	
	public void generateround() {
		for (int i = 0; i < 20; i++) {
			team1.getPlayerList().get(i).shoot(managerShot.getRandomShot());
		}
	}
	
	public Player getWinner() {
		return null;
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
}