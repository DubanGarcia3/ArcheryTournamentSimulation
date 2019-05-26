package model.entities;

import java.util.ArrayList;

public class Team {
	
	private ArrayList<Player> playerList;
	
	public Team() {
		playerList = new ArrayList<Player>();
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}
	
	public void addPlayerToTeam(Player player) {
		playerList.add(player);
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
}
