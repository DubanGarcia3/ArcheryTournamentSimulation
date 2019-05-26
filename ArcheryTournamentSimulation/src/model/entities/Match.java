package model.entities;

import java.util.ArrayList;

import model.entities.Team;

public class Match {
	
	private Team team1;
	private Team team2;
	private ArrayList<Weather> weatherList;
	
	public Match(Team team1, Team team2, ArrayList<Weather> weatherList) {
		this.team1 = team1;
		this.team2 = team2;
		this.weatherList = new ArrayList<Weather>();
	}
	
	public Player getWinner() {
		return null;
	}
	
	
	public void shoot() {
		
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
	public ArrayList<Weather> getWeatherList() {
		return weatherList;
	}
	public void setWeatherList(ArrayList<Weather> weatherList) {
		this.weatherList = weatherList;
	}	
}