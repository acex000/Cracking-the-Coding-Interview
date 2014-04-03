public class RotateMatrix {

	public static void main(String[] args){
		int[][] image = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		rotate(image);

	}

	public static void rotate(int[][] image){
		
		for(int layer = 0;layer<image.length/2;++layer){
			for(int offset=0;offset<image.length-2*layer-1;++offset){
				int index = layer+offset;
				int temp = image[layer][index];				
				image[layer][index] = image[image.length-1-index][layer];
				//top<-left
				image[image.length-1-index][layer] = image[image.length-1-layer][image.length-1-index];
				//left<-bottom
				image[image.length-1-layer][image.length-1-index] = image[index][image.length-1-layer]; 
				//bottom<-right
				image[index][image.length-1-layer] = temp;
				//top<-right
			
			}

		}
		for (int i = 0; i < image.length; i++) {
  			for (int j = 0; j < image.length; j++) {
        		System.out.print(image[i][j] + " ");
    		}
    		System.out.print("\n");
		}
	}
}