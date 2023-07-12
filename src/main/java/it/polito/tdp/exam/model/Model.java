package it.polito.tdp.exam.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.exam.db.BaseballDAO;

public class Model {
	
	private Graph<Integer, DefaultWeightedEdge> grafo;
	private BaseballDAO dao;
	private List<Integer> listaVertici;
	private List<Arco> listaArchi;
	
	public Model() {
		
		dao = new BaseballDAO();
	}
	
	public List<String> listaSquadre() {
		return this.dao.listaSquadre();
	}
	
	public void creaGrafo(String squadra) {
		
		listaVertici = new ArrayList<Integer>();
		listaArchi = new ArrayList<Arco>();
		grafo = new SimpleWeightedGraph<Integer, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		this.dao.creaVertici(listaVertici, squadra);
		Graphs.addAllVertices(this.grafo, listaVertici);
		
		for (int anno1 : listaVertici) {
			for (int anno2 : listaVertici) {
				if (anno1 > anno2) {
					Graphs.addEdgeWithVertices(this.grafo, anno1, anno2, 0);
					Arco a = new Arco(anno1, anno2, 0);
					listaArchi.add(a);
				}
			}
		}
		
		this.dao.setPesoArchi(grafo, squadra);
	}
	
	public List<Integer> listaAnni() {
		
		Collections.sort(listaVertici);
		return listaVertici;
	}
	
	public String dettagli(int anno) {
		
		String result = "";
		
		List<Arco> lista = new ArrayList<Arco>();
		
		for (int y : listaVertici) {
			if (y == anno) {
				List<Integer> adiacenti = Graphs.neighborListOf(this.grafo, y);
				
				for (int yy : adiacenti) {
					int peso = (int)this.grafo.getEdgeWeight(this.grafo.getEdge(yy, y));
					
					lista.add(new Arco(yy, y, peso));
				}
				
				Collections.sort(lista, new Comparator<Arco>() {
					 @Override
					 public int compare(Arco o1, Arco o2) {
					 return (int) (o1.getPeso() - o2.getPeso ());
					 }});
				
				for (Arco a : lista) {
					if (a.getPeso() != 0) {
					result = result + a.getYear2() + "<->" + a.getYear1() + "; peso: " + a.getPeso() + "\n";
				}
				}
			}
		}
		
		return result;
	}
	
	public int numeroVertici() {
		return this.grafo.vertexSet().size();
		}
	
		 public int numeroArchi() {
		return this.grafo.edgeSet().size();
		}
	
	
	
}
