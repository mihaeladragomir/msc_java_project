package game;

public class Item {

	
	private boolean isUsed, isPickedUp;
	
	private String name;
	
	public Item(String itemName){
		name=itemName;
		isUsed = false;
		isPickedUp = false;
	}
	
	public boolean isPickedUp(){
		return isPickedUp;
	}
	
	public boolean isUsed(){
		return isUsed;
	}
    
	public void setUsed(boolean value){
		isUsed=value;
	}
    
	public void setPickedUp(boolean value){
		isPickedUp=value;
	}
}
