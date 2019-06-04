package model.entities;

public class Round {
	
	private double points;
	private int winnerTeam;
	
	
	public Round(double d, int winnerTeam) {
		this.points = d;
		this.winnerTeam = winnerTeam;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getWinnerTeam() {
		return winnerTeam;
	}

	public void setWinnerTeam(int winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	@Override
	public String toString() {
		return "points=" + points + ", winnerTeam=" + winnerTeam;
	}
}
