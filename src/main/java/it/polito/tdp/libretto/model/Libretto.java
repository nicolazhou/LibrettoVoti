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
		
		if(esisteVoto(v) || esisteConflittoVoto(v)) {
			
			System.out.println("Voto errato!");
			
			throw new IllegalArgumentException("Voto errato" + v.toString());
			
			//return false;
		}
		
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
	
	/**
	 * Verifica se la valutazione è già presente nel libretto (Stesso corso con lo stesso voto)
	 * @param nuovo
	 * @return
	 */
	public boolean esisteVoto(Voto nuovo) {
		
		for(Voto v : this.voti) {
			
			if(v.equalsCorsoPunti(nuovo)) {
				return true;
			}
			
		}
		
		return false;
	}
	
	
	/**
	 * Verifica se esiste un voto diverso già memorizzato dello stesso corso
	 * @param nuovo
	 * @return
	 */
	public boolean esisteConflittoVoto(Voto nuovo) {
		
		for(Voto v : this.voti) {
			
			if(v.getNomeCorso().compareTo(nuovo.getNomeCorso())==0) {
				if(v.getPunti() != nuovo.getPunti()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * Metodo 'factory' per creare un nuovo libretto con i voti migliorati
	 * @return
	 */
	public Libretto librettoMigliorato() {
		
		Libretto migliore = new Libretto();
		
		migliore.voti = new ArrayList<>();
		
		for(Voto v : this.voti) {
			// migliore.voti.add(v.clone());
			migliore.voti.add(new Voto(v));
		}
		
	/*	
		for(Voto v : migliore.voti) {
			
			v.setPunti(v.getPunti() + 2);
			
		}*/
		
		
		return migliore;
		
		
	}
	
	
	public void cancellaVotiInferiori(int punti) {
		
		List<Voto> daCancellare = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			
			if(v.getPunti() < punti) {
				daCancellare.add(v);
				//this.voti.remove(v);
			}
			
		}
		
		for(Voto v1 : daCancellare) {
			this.voti.remove(v1);
		}
		
		
		// Meglio : this.voti.removeAll(daCancellare);
		
		/*
		for(int i = 0; i < this.voti.size(); i++) {
			
			if(this.voti.get(i).getPunti() < punti) {
				this.voti.remove(i);
				i = i-1;
			}
			
		}*/
		
		
	}
	
	
	public Libretto librettoOrdinatoAlfabeticamente() {
		
		Libretto ordinato = new Libretto();
		
		ordinato.voti = new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new ComparatorByName());
		//Collections.sort(ordinato.voti);
		
		return ordinato;
		
	}
	
	
	public Libretto librettoOrdinatoPerVoto() {
		
		Libretto ordinato = new Libretto();
		
		ordinato.voti = new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new Comparator<Voto>() {

			@Override
			public int compare(Voto o1, Voto o2) {
				// TODO Auto-generated method stub
				return o2.getPunti()-o1.getPunti();
			}});
		
		return ordinato;
		
	}
	
	
	public String toString() {
		
		String s = "";
		
		for(Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		
		return s;
	}
	
}
