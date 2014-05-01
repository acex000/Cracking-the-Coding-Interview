public class Dog extends Animal{

	public Dog(String name){
		super(name);
		setType();
	}

	public void setType(){
		this.type = "Dog";
	}
}