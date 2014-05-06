public class Graph{
	private Vertex[] vertices;
	private int numberOfVertices;
	private int vertexCount;

	public Graph(int n){
		this.numberOfVertices = n;
		vertices = new Vertex[n];
		vertexCount = 0;
	}

	public void addVertex(Vertex v){
		vertices[vertexCount] = v;
		++vertexCount;
	}

	public Vertex[] getVertices(){
		return vertices;
	}
}