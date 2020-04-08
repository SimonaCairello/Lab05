package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {
	
	private ParolaDAO parolaDao = new ParolaDAO();
	private List<String> soluzione;
	
	public boolean controllaParola(String p) {
		return parolaDao.controllaParola(p);
	}
	
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if(disponibili.size()==0) {
			this.soluzione.add(parziale);
		}
		
		for(Character ch: disponibili) {
			String tentativo = parziale + ch;
			List<Character> rimanenti = new ArrayList<>(disponibili);
			rimanenti.remove(ch);
			
			cerca(tentativo, livello+1, rimanenti);
		}
	}	
	
	public List<String> anagrammi(String parola) {
		this.soluzione = new ArrayList<String>();
		
		parola = parola.toLowerCase();
		
		List<Character> disponibili = new ArrayList<Character>();
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}
		
		cerca("", 0, disponibili); 
		return this.soluzione;
	}

}
