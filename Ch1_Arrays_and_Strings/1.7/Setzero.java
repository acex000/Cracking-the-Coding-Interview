public class Setzero{


	public static void main(String[] args){
		int[][] matrix = {
			{1,0,3,4,5},
			{6,7,8,9,1},
			{1,2,3,0,5},
			{6,7,8,9,2}
		};
		int m = matrix.length, n = matrix[0].length;

		setZ(matrix, m, n);
	}

	public static void setZ(int[][] matrix, int m, int n){
		int[][] coordinate = new int[2][];
		coordinate[0] = new int[m];
		coordinate[1] = new int[n];

		for(int i=0;i<m;++i)
			for(int j=0;j<n;++j){
				if(matrix[i][j]==0){
					coordinate[0][i] = 1;
					coordinate[1][j] = 1;
				}
			}

		for(int i=0;i<m;++i)
			if(coordinate[0][i]==1){
				for(int j=0;j<n;++j)
					matrix[i][j]=0;
			}
		for(int i =0;i<n;++i)
			if(coordinate[1][i]==1){
				for(int j=0;j<m;++j)
					matrix[j][i]=0;
			}

		for(int i=0;i<m;++i){
			for(int j=0;j<n;++j)
				System.out.print(matrix[i][j]);
			System.out.print("\n");
		}
	}
}