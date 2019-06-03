package model.entities;

public class Round {
	
	private int points;
	private Team winnerTeam;
	
	
	public Round(int points, Team winnerTeam) {
		this.points = points;
		this.winnerTeam = winnerTeam;
	}

	public int getPoints() {
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
