package it.polito.tdp.exam.model;

public class Arco {
	
	int year1;
	int year2;
	int peso;
	public Arco(int year1, int year2, int peso) {
		super();
		this.year1 = year1;
		this.year2 = year2;
		this.peso = peso;
	}
	public int getYear1() {
		return year1;
	}
	public void setYear1(int year1) {
		this.year1 = year1;
	}
	public int getYear2() {
		return year2;
	}
	public void setYear2(int year2) {
		this.year2 = year2;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	

}
