package it.polito.tdp.libretto.model;

import java.time.*;

public class Voto{

	private String nomeCorso;
	private int punti; // da 18 a 31
	private LocalDate dataEsame;
	
	
	public Voto(String nomeCorso, int punti, LocalDate dataEsame) {
		this.nomeCorso = nomeCorso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}
	
	
	// Copy constructor di voto
	public Voto(Voto v) {
		this.nomeCorso = v.getNomeCorso();
		this.punti = v.getPunti() + 2;
		this.dataEsame = v.getDataEsame();
	}


	public String getNomeCorso() {
		return nomeCorso;
	}


	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}


	public int getPunti() {
		return punti;
	}


	public void setPunti(int punti) {
		this.punti = punti;
	}


	public LocalDate getDataEsame() {
		return dataEsame;
	}


	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}
	
	
	public boolean isDuplicato(Voto altro) {
		
		return this.getNomeCorso().equals(altro.getNomeCorso()) && this.getPunti() == altro.getPunti();
	}
	
	public boolean isConflitto(Voto altro) {
		
		return this.getNomeCorso().equals(altro.getNomeCorso()) && this.getPunti() != altro.getPunti();
	}
	
	
	@Override
	public String toString() {
		return "Voto [nomeCorso=" + nomeCorso + ", punti=" + punti + ", dataEsame=" + dataEsame + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	public Voto clone() {
		return new Voto(this.nomeCorso, this.punti, this.dataEsame);
	}


	public boolean equalsCorsoPunti(Voto nuovo) {
		
		if(this.nomeCorso.compareTo(nuovo.getNomeCorso())==0 && this.punti == nuovo.getPunti())
			return true;
		
		return false;
	}
	
	
}
