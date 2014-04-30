import java.util.*;

public class SetOfStacks<T>{
	
	LinkedListNode<T> globalTop = null;
	ArrayList<LinkedListNode<T>> subTopSet = new ArrayList<LinkedListNode<T>>(); //use this to store pointer of top item of each sub stack
	int currentStack = -1;
	int stackSize = 5;
	int globalDepth = 0;
	
	public void push(T object){
		if(globalDepth == 0){	//no item in the stackSet
			LinkedListNode<T> newItem = new LinkedListNode<T>(object); //..
			globalTop = newItem;
			
			subTopSet.add(globalTop);

			++globalDepth;
			++currentStack;
		}
		else if((globalDepth>0)&&(globalDepth%stackSize==0)){	//set is not empty,and current sub stack is full, and then add a new stack pointer in pointerSet
			globalTop = globalTop.addToHead(object); 

			subTopSet.add(globalTop);
			
			++globalDepth;
			++currentStack;
		}
		else if((globalDepth>0)&&(globalDepth%stackSize>0)){	//set is not empty and sub stack is not full
			globalTop = globalTop.addToHead(object); 
			
			subTopSet.set(currentStack, globalTop);
			++globalDepth;
		}

	}	

	public T pop(){
		LinkedListNode<T> item = globalTop;
		globalTop = globalTop.next;
		if((globalDepth-1)%stackSize==0){	//just pop out the last item of a sub stack, now globalTop is at the toppest position of the current sub stack
			subTopSet.remove(currentStack);
			--globalDepth;
			--currentStack;
		}
		else if((globalDepth-1)%stackSize!=0){
			--globalDepth;
		}
		return item.data;

	}

	public T popAt(int stkIndex){
		LinkedListNode<T> popedTop = subTopSet.get(stkIndex);
		//A.:pop the curent stack which is also the toppest stack
		if(stkIndex==currentStack){	
			return pop();
		}
		//B.:pop the stack under the toppest stack
		else if(stkIndex<currentStack){	
			//B.1: This means after poping , the toppest stack will become empty, so it will be removed
			if(globalDepth%stackSize==1){  	
				for(int i=stkIndex;i<currentStack;++i){	//reset every subTop in subTopSet tp point to its pre(upper) node
					subTopSet.set(i, subTopSet.get(i).pre);	
				}
				popedTop.pre.next = popedTop.next;
				popedTop.next.pre = popedTop.pre;
				--globalDepth;

				subTopSet.remove(currentStack); //remove the toppest empty stack subTop pointer from the set
				--currentStack;
			}
			//B.2: After poping, the toppest stack will not become empty,
			else{
				for(int i=stkIndex;i<currentStack;++i){	//reset every subTop in subTopSet tp point to its pre(upper) node
					subTopSet.set(i, subTopSet.get(i).pre);
				}
				popedTop.pre.next = popedTop.next;
				popedTop.next.pre = popedTop.pre;
				--globalDepth;
			}
		}
		return popedTop.data;
	}

	public boolean setIsEmpty(){
		if(globalDepth==0)
			return true;
		else
			return false;
	}

}