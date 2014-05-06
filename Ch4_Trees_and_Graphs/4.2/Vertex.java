import java.util.ArrayList;

public class Vertex{
	private String label;
	private ArrayList<Vertex> adjacent;
	public boolean isVisited;

	public Vertex(String label){
		this.label = label;
		adjacent = new ArrayList<Vertex>();
	}

	public void addAdjacent(Vertex v){
		adjacent.add(v);
	}

	public ArrayList<Vertex> getAdjacent(){
		return adjacent;
	}

	public String getLabel(){
		return label;
	}
}