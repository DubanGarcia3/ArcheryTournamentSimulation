package model.entities;

import java.util.ArrayList;

import dao.Manager.ManagerShot;

public class Team {
	
	private static int ID_BASE = 1;
	private int id;
	private ArrayList<Player> playerList;
	
	public Team() {
		playerList = new ArrayList<Player>();
		this.id = ID_BASE++;
	}
	
	public Player getPleyerLuckier(ManagerShot managerShot) {
		Player max = null;
		double aux =0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i)!= null) {
				if (playerList.get(i).getLucky() > aux) {
					aux = playerList.get(i).getLucky();
					max = playerList.get(i);
					playerList.get(i).addShot(managerShot);
				}
			}
		}
		return max;
	}
	
	public double calculateTotalDistance() {
		double aux=0;
		for (int i = 0; i < playerList.size(); i++) {
				aux += playerList.get(i).getTotalDistance();
		}
		return aux;
	}
	
	public void incrementDistance() {
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).incrementDistance();
		}
	}
	
	public Player getIndividualWinner() {
		Player max = null;
		double aux =0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i)!= null) {
				if (playerList.get(i).getTotalDistance() > aux) {
					aux = playerList.get(i).getTotalDistance();
					max = playerList.get(i);
				}
			}
		}
		return max ;
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
	
	public double getExpEarned() {
		double exp = 0;
		for (int i = 0; i < playerList.size(); i++) {
			exp += playerList.get(i).getExp() -10;
		}
		return exp;
	}
	
	public double getLuckyEarned() {
		double lucky = 0;
		for (int i = 0; i < playerList.size(); i++) {
			lucky += playerList.get(i).getExp() -10;
		}
		return lucky;
	}

	@Override
	public String toString() {
		return "Team = " + id;
	}

}
