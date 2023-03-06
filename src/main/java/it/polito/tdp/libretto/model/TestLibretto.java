package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi 1", 29, LocalDate.of(2021, 01, 25)));
		lib.add(new Voto("Fisica 2", 24, LocalDate.of(2022, 02, 21)));
		lib.add(new Voto("Informatica", 25, LocalDate.of(2021, 02, 01)));
		
		lib.stampa();
		
		lib.stampaPuntiUguali(25);
		
		Voto v = lib.cercaVotoPerNome("Analisi 1");
		System.out.println(v);
		
		v = lib.cercaVotoPerNome("Analisi 2");
		System.out.println(v);
		
		Voto a1bis = new Voto("Analisi 1", 29, LocalDate.of(2025, 01, 01));
		Voto a1ter = new Voto("Analisi 1", 30, LocalDate.of(2025, 01, 01));
		
		System.out.println(a1bis + "è duplicato + " + lib.esisteVoto(a1bis));
		System.out.println(a1ter + "è duplicato + " + lib.esisteVoto(a1ter));
		
	}
	
}
