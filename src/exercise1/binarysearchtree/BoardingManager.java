package exercise1.binarysearchtree;

import java.util.List;

public class BoardingManager {
	
	public static void main(String[] args) {
		SimpleBinarySearchTree<Passenger> sbst = new SimpleBinarySearchTree<Passenger>();

		Passenger [] pass;
		pass = new Passenger[5];
		pass[0] = new Passenger("Fred","Jones",6441);
		pass[1] = new Passenger("Mark","Jacobs",2545);
		pass[2] = new Passenger("Ethan","Hedge", 6946);
		pass[3] = new Passenger("Ernie","Matthews",9163);
		pass[4] = new Passenger("Carlos","Alvarez",2644);
		
		sbst.addElement(pass[0]);
		sbst.addElement(pass[1]);
		sbst.addElement(pass[2]);
		sbst.addElement(pass[3]);
		sbst.addElement(pass[4]);
		
		//for(int i = 0; i < 5; i++){
			//removeMax(pass[i]);
		sbst.removeMax(pass[0]);
		}
	}
}
