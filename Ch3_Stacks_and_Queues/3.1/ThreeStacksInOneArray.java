public class ThreeStacksInOneArray{
	Object[] fixSpace = new Object[11];
	int length = fixSpace.length;
	int start1 = 0, end1 = length/3-1;
	int start2 = length/3, end2 = length*2/3-1;
	int start3 = length*2/3, end3 = length-1;

	public static void main(String[] args){
		Object[] fixSpace = new Object[11];
		int length = fixSpace.length;
		int start1 = 0, end1 = length/3-1;
		int start2 = length/3, end2 = length*2/3-1;
		int start3 = length*2/3, end3 = length-1;
		System.out.println("stack1 start:"+start1);
		System.out.println("stack1 end:"+end1);
		System.out.println("stack2 start:"+start2);
		System.out.println("stack2 end:"+end2);
		System.out.println("stack3 start:"+start3);
		System.out.println("stack3 end:"+end3);
	}

	public class Stack1{
		int stackTop = start1;


		public void push(Object item){
			if(stackTop<end1)
				fixSpace[stackTop] = item;
			else
				System.out.println("stack is full, push failed");
		}

		public Object pop(){
			if(stackTop>start1){
				Object item = fixSpace[stackTop];
				--stackTop;
				return item;
			}
			return null;
		}
	}

	public class Stack2{
		int stackTop = start2;


		public void push(Object item){
			if(stackTop<end2)
				fixSpace[stackTop] = item;
			else
				System.out.println("stack is full, push failed");
		}

		public Object pop(){
			if(stackTop>start2){
				Object item = fixSpace[stackTop];
				--stackTop;
				return item;
			}
			return null;
		}
	}

	public class Stack3{
		int stackTop = start3;


		public void push(Object item){
			if(stackTop<end3)
				fixSpace[stackTop] = item;
			else
				System.out.println("stack is full, push failed");
		}

		public Object pop(){
			if(stackTop>start3){
				Object item = fixSpace[stackTop];
				--stackTop;
				return item;
			}
			return null;
		}
	}
}