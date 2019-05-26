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

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
}
