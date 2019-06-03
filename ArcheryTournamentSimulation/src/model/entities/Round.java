package model.entities;

public class Round {
	
	private double points;
	private Team winnerTeam;
	
	
	public Round(double d, Team winnerTeam) {
		this.points = d;
		this.winnerTeam = winnerTeam;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Team getWinnerTeam() {
		return winnerTeam;
	}

	public void setWinnerTeam(Team winnerTeam) {
		this.winnerTeam = winnerTeam;
	}
}
