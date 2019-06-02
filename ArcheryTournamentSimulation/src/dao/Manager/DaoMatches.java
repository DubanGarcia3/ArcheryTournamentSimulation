package dao.Manager;

import java.util.ArrayList;

import model.entities.Match;

public class DaoMatches {
	
	private ArrayList<Match> listMatches;
	
	public DaoMatches() {
		listMatches = new ArrayList<Match>();
	}

	public ArrayList<Match> getListMatches() {
		return listMatches;
	}

	public void setListMatches(ArrayList<Match> listMatches) {
		this.listMatches = listMatches;
	}
	
	public void addMatch( Match match) {
		listMatches.add(match);
	}
}
