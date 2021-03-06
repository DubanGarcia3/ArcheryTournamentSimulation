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
	
/**
 * Identifica cuantos hombres hay en el team
 * @return
 */
	public int getCountM() {
		int count = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).getGender().equals(Gender.MALE)) {
				count++;
			}
		}
		return count;
	}
/**
 * Identifica la cantidad de mujeres en el team	
 * @return
 */
	public int getCountF() {
		int count = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).getGender().equals(Gender.FEMALE)) {
				count++;
			}
		}
		return count;
	}
/**
 * Obtiene el jugador con mas suerte del team	
 * @param managerShot Clase que administra los disparos
 * @return
 */
	public Player getPlayerLuckier(ManagerShot managerShot) {
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
/**
 * Calcula la distancia total de un team	
 * @return
 */
	public double calculateTotalDistance() {
		double aux=0;
		for (int i = 0; i < playerList.size(); i++) {
				aux += playerList.get(i).getTotalDistance();
		}
		return aux;
	}
/**
 * Incrementa la distancia para el jugador que tenga m�s de 18 de exp
 */
	public void incrementDistance() {
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).incrementDistance();
		}
	}
/**
 * Obtiene el jugador que gan� la ronda	
 * @return
 */
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
/**
 * Obtiene los jugadores que tengan m�s de 10 de experiencia
 * @return
 */
	public int getOnlyExp() {
		int count = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getExp() >10) {
				count ++;
			}
			
		}
		return count;
	}

	public int getOnlyLucky() {
		int count = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getLucky() > 10) {
				count ++;
			}
			
		}
		return count;
	}
/**
 * Obtiene la lista de jugadores con m�s de 10 de experiencia	
 * @return
 */
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
