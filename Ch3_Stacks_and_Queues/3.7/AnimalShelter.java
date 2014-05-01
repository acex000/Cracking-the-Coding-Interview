public class AnimalShelter{

	public static void main(String[] args) {
		AnimalQueue animalQ = new AnimalQueue();
		Dog[] dogSet = new Dog[4];
		Cat[] catSet = new Cat[3];
		dogSet[0] = new Dog("dog0");
		dogSet[1] = new Dog("dog1");
		dogSet[2] = new Dog("dog2");
		catSet[0] = new Cat("cat0");
		catSet[1] = new Cat("cat1");
		catSet[2] = new Cat("cat2");
		for(int i=0;i<3;++i){
			animalQ.enQueue(dogSet[i]);
			animalQ.enQueue(catSet[i]);	
		}
		animalQ.printDogs();
		animalQ.printCats();
		System.out.println("deQueueAny:"+animalQ.deQueueAny().name);
		System.out.println("deQueueCat:"+animalQ.deQueueCat().name);
		System.out.println("deQueueDog:"+animalQ.deQueueDog().name);
	}
}