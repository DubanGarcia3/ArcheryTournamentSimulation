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
	private int countTeamA;
	private int countTeamB;
	private Team winner;
	
	public Match(Team teamA, Team teamB, ManagerShot managerShot, Weather weather) {
		this.team1 = teamA;
		this.team2 = teamB;	
		this.weather = weather;
		this.managerShot = managerShot;
		this.listRound = new ArrayList<Round>();
		this.countTeamA = 0;
		this.countTeamB = 0;
		this.winner = null;
	}
/**
 * Obtiene el jugador con mas suerte de cada equipo.
 */
	public void getPlayerLuckier() {
		team1.getPlayerLuckier(managerShot).addShot(managerShot);
		team2.getPlayerLuckier(managerShot).addShot(managerShot);
		System.out.println("tiro suerte para los jugadores " + 
				team1.getPlayerLuckier(managerShot).getName()+ " y " +
				team2.getPlayerLuckier(managerShot).getName()
				);
	}
	
	public Team getWinner() {
		return winner;
	}
/**
 * Indentifica el ganador de la partida
 */
	public void setWinner() {
		if (countTeamA > countTeamB) {
			this.winner = team1;
		}else {
			this.winner = team2;
		}
	}
/**
 * Calcula los disparos cuando se afectan por el clima
 */
	public void calculateShootOnWeather() {
		for (int i = 0; i < 20; i++) {
			if (weather.getName().equalsIgnoreCase("Soleado")) {
				//no pasa nada :) 
			}else {
				team1.getPlayerList().get(i).calculateShootsOnWeather(weather.getName());
				team2.getPlayerList().get(i).calculateShootsOnWeather(weather.getName());
			}
		}
	}
/**
 * Sirve para calcular quien gano la ronda individual	
 * @return
 */
	public Player calculateindividualWinner() {
		if (team1.getIndividualWinner().getTotalDistance() >= team2.getIndividualWinner().getTotalDistance() ) {
			return team1.getIndividualWinner();
		}else {
			return team2.getIndividualWinner();
		}
	}
/**
 * Genera un ronda
 */
	public void generateRound() {
		for (int i = 0; i < 20; i++) {
			team1.getPlayerList().get(i).shoot(managerShot);
			team2.getPlayerList().get(i).shoot(managerShot);
			System.out.println("Disparando jugador: "+ team1.getPlayerList().get(i).getName()+" TEAM A"+"                         "+
			"Disparando jugador: "+ team2.getPlayerList().get(i).getName()+" TEAM B");
//			Shot.showArchery();
		}
	}
/**
 * Vacia la lista de disparos de cada jugador para un nueva ronda	
 */
	public void clearList() {
		for (int i = 0; i < 20; i++) {
			team1.getPlayerList().get(i).getListShots().clear();
			team2.getPlayerList().get(i).getListShots().clear();
		}
	}
/**
 * Este metodo agrega una ronda a la lista de rondas, contando el ganador de la ronda
 * @param d puntos
 * @param winnerTeam Id del team ganador
 */
	public void addRound(double d, int winnerTeam) {
		if(winnerTeam == team1.getId()) {
			countTeamA++;
		}else {
			countTeamB++;
		}
		listRound.add(new Round(d, winnerTeam));
	}
	
	public double getExpEarned(Team team) {
		return team.getExpEarned();
	}
	
	public double getLuckyEarned(Team team) {
		return team.getLuckyEarned();
	}
	
	
	public int getCountTeamA() {
		return countTeamA;
	}

	public void setCountTeamA(int countTeamA) {
		this.countTeamA = countTeamA;
	}

	public int getCountTeamB() {
		return countTeamB;
	}

	public void setCountTeamB(int countTeamB) {
		this.countTeamB = countTeamB;
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

	@Override
	public String toString() {
		return "Match [team1=" + team1 + ", team2=" + team2 + ", weather=" + weather + "]";
	}
}