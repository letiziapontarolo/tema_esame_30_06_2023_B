package it.polito.tdp.exam.model;

import java.util.Objects;

public class Year {
	
	int anno;
	int salario;
	
	public Year(int anno, int salario) {
		super();
		this.anno = anno;
		this.salario = salario;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Year other = (Year) obj;
		return anno == other.anno;
	}
	@Override
	public String toString() {
		return "Year [anno=" + anno + "]";
	}
	
	

}
