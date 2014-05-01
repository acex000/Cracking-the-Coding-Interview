import java.util.Date;

public abstract class Animal{
	public String name;
	public Date date;
	public long time;
	public String type;

	public Animal(String name){
		this.name = name;
		this.date = new Date();
		setTime();
	}

	public void setTime(){
		this.time = date.getTime();
	}

	abstract void setType();
}
