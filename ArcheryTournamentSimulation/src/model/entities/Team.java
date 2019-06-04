package model.entities;

import java.util.ArrayList;

public class Team {
	
	private static int ID_BASE = 1;
	private int id;
	private ArrayList<Player> playerList;
	
	public Team() {
		playerList = new ArrayList<Player>();
		this.id = ID_BASE++;
	}
	
	public double calculateTotalDistance() {
		double aux=0;
		for (int i = 0; i < playerList.size(); i++) {
				aux += playerList.get(i).getTotalDistance();
		}
		return aux;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public void removeAll() {
		playerList.removeAll(playerList);
	}

	@Override
	public String toString() {
		return "Team = " + id;
	}
}
