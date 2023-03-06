package it.polito.tdp.libretto.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiungi un nuovo voto al libretto
	 * (per ora non fa nessun controllo)
	 * @param v
	 * @return
	 */
	public boolean add(Voto v) {
		return this.voti.add(v);	
	}
	
	
	public void stampa() {
		
		for(Voto v : this.voti) {
			System.out.println(v);
		}
	}
	
	public void stampaPuntiUguali(int valore) {
		
		for(Voto v : this.voti) {
			if(v.getPunti() == valore) {
				System.out.println(v);
			}
		}
	}
	
	public Voto cercaVotoPerNome(String corso) {
		
		for(Voto v : this.voti) {
			if(v.getNomeCorso().equals(corso)) {
				return v;
			}
		}
		return null;
		
		//throw new RunTimeException("Voto non trovato!");
		
	}
	
	public boolean esisteVoto(Voto nuovo) {
		
		for(Voto v : this.voti) {
			
			if(v.equalsCorsoPunti(nuovo)) {
				return true;
			}
			
		}
		
		return false;
	}
	
	
	
	
}
