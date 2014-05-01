public class Cat extends Animal{

	public Cat(String name){
		super(name);
		setType();
	}

	public void setType(){
		this.type = "Cat";
	}
}