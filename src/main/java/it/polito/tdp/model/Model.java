package it.polito.tdp.model;

import java.security.InvalidParameterException;

public class Model {

	private int segreto;
	private final int TMAX = 8;
	private final int NMAX = 100;
	private int tentativiFatti;
	
	private boolean inGioco = false;
	
	public void nuovaPartita() {
		this.segreto = (int)((Math.random() * NMAX) +1);
    	this.tentativiFatti = 0;
    	this.inGioco = true;
	}
	
	public int tentativo(int tentativo) {
		
		if(!inGioco) {
			throw new IllegalStateException("HAI PERSO STRONZO!");
		}
		
		
		if(!tentativoValido(tentativo)) {
			throw new InvalidParameterException("Hai inserito male i dati");
		}
		
		this.tentativiFatti++;
		
		if(this.tentativiFatti == TMAX) {
			this.inGioco = false;
		}
		
		
		if(tentativo==segreto ) {
			this.inGioco = false;
			return 0; 
		} else if (tentativo<segreto) {
			return -1;
		} else {
			return 1;  
		}
		
		
		
	}
	
	public boolean tentativoValido(int tentativo) {
		if(tentativo<1||tentativo>NMAX) {
			return false;
			//throw new InvalidParameterException("Hai inserito male i dati");
		} 
		return true;
	} 
	
	public int getSegreto() {
		return segreto;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}
	
	
	
}
