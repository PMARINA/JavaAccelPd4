/**
 * @author PMARINA
 * @version Apr 30, 2016
 */

public class Bird {
	private String name;

	public Bird(String name){
		this.name = name;
	}
	public void setName(String name){
		if(name != null){
			this.name = name;
		}
		else{
			throw new NullPointerException();
		}
	}
	public String toString(){
		return this.name;
	}
}
