public class AnimalQueue{
	LinkedListNode<Dog> dogList=null, dogListEnd=null;
	LinkedListNode<Cat> catList=null, catListEnd=null;

	public void enQueue(Animal newAnimal){
		if(newAnimal.type=="Dog"){
			Dog newDog = (Dog)newAnimal;// We must use cast here
			LinkedListNode<Dog>  newNode = new LinkedListNode<Dog>(newDog);
			if(dogList==null){
				dogList = newNode;
				dogListEnd = dogList;
			}
			else{
				dogListEnd.next = newNode;
				dogListEnd = dogListEnd.next;
			}

		}
		else{
			Cat newCat = (Cat)newAnimal;
			LinkedListNode<Cat>  newNode = new LinkedListNode<Cat>(newCat);
			if(catList==null){
				catList = newNode;
				catListEnd = catList;
			}
			else{
				catListEnd.next = newNode;
				catListEnd = catListEnd.next;
			}
		}
	}

	public Animal deQueueAny(){
		if(dogList==null)
			return deQueueCat();
		else if(catList==null){
			return deQueueDog();
		}
		else{
			long dogTime = dogList.data.time;
			long catTime = catList.data.time;
			if(dogTime<=catTime){
				return deQueueDog();
			}
			else{
				return deQueueCat();
			}			
		}

	}

	public Dog deQueueDog(){
		LinkedListNode<Dog> dog = dogList;
		dogList = dogList.next;
		return dog.data;
	}

	public Cat deQueueCat(){
		LinkedListNode<Cat> cat = catList;
		catList = catList.next;
		return cat.data;
	}

	public void printDogs(){
		LinkedListNode<Dog> dog = dogList;
		while(dog!=null){
			System.out.print(dog.data.name+",");
			dog = dog.next;
		}
		System.out.println();
	}

	public void printCats(){
		LinkedListNode<Cat> cat = catList;
		while(cat!=null){
			System.out.print(cat.data.name+",");
			cat = cat.next;
		}
		System.out.println();
	}

}