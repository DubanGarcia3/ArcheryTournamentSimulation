package model.entities;

import java.util.ArrayList;

public class Team {
	
	private ArrayList<Player> playerList;
	
	public Team() {
		playerList = new ArrayList<Player>();
	}

//	public shoot() {
//		
//	}
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}
	
	public void addPlayerToTeam(Player player) {
		playerList.add(player);
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public void removeAll() {
		playerList.removeAll(playerList);
	}

	@Override
	public String toString() {
		return "Team [playerList=" + playerList + "]";
	}
}
