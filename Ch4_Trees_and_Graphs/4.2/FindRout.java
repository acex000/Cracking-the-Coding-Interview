import java.util.LinkedList;
import java.util.Queue;

public class FindRout{

	public static Graph generateGraph(){
		Graph graph = new Graph(5);

		Vertex va = new Vertex("a");
		Vertex vb = new Vertex("b");
		Vertex vc = new Vertex("c");
		Vertex vd = new Vertex("d");
		Vertex ve = new Vertex("e");

		va.addAdjacent(vb);
		va.addAdjacent(vc);
		vb.addAdjacent(va);
		vb.addAdjacent(vd);
		vc.addAdjacent(va);
		vd.addAdjacent(vb);
		vd.addAdjacent(ve);
		ve.addAdjacent(vd);

		graph.addVertex(va);
		graph.addVertex(vb);
		graph.addVertex(vc);
		graph.addVertex(vd);
		graph.addVertex(ve);
		
		return graph;
	}

	public static boolean findRout(Graph graph, Vertex startV, Vertex destV){
		for(Vertex v: graph.getVertices()){
			v.isVisited = false;
		}
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.offer(startV);
		while(!queue.isEmpty()){
			Vertex temp = queue.poll();
			temp.isVisited = true;
			System.out.println(temp.getLabel());
			if(temp==destV){
				return true;
			}
			for(Vertex v: temp.getAdjacent()){
				if(v.isVisited==false)
					queue.offer(v);
			}
		}
		

		return false;
	}

	public static void main(String[] args){
		Graph graph = generateGraph();

		boolean result = findRout(graph, graph.getVertices()[2], graph.getVertices()[4]);	//test if there is a route bewteen vc and ve
		System.out.println("the result is: "+result);
	}

}