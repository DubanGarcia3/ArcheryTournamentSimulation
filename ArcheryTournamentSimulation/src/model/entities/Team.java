package model.entities;

import java.util.ArrayList;

public class Team {
	
	private static int ID_BASE = 1;
	private int id;
	private ArrayList<Player> playerList;
	
	public Team() {
		this.id = ID_BASE++;
		playerList = new ArrayList<Player>();
	}
	
	public double calculateTotalDistance() {
		double aux=0;
		for (int i = 0; i < playerList.size(); i++) {
			for (int j = 0; j < playerList.get(i).getListShots().size(); j++) {
				aux+=playerList.get(i).getListShots().get(j).calcualteDistance();
				
			}
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
