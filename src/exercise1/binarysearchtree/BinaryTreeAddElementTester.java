package exercise1.binarysearchtree;

import java.util.List;

public class BinaryTreeAddElementTester {

	public static void main(String[] args) {
		SimpleBinarySearchTreeInterface<Integer> sbst = new SimpleBinarySearchTree<Integer>();
		sbst.addElement(8);
		sbst.addElement(6);
		sbst.addElement(10);
		sbst.addElement(4);
		sbst.addElement(7);
		sbst.addElement(9);
		sbst.addElement(18);
		sbst.addElement(2);
		sbst.addElement(5);
		sbst.addElement(16);
		sbst.addElement(20);
		sbst.addElement(3);
		sbst.addElement(17);
		
	
		BTreePrinter.printNode(sbst.getRootNode());
		System.out.println("\nRemoving element 3...");
		sbst.removeElement(3);
		BTreePrinter.printNode(sbst.getRootNode());
		System.out.println("\nRemoving element 16...");
		sbst.removeElement(16);
		BTreePrinter.printNode(sbst.getRootNode());
		System.out.println("\nRemoving element 10...");
		sbst.removeElement(10);
		BTreePrinter.printNode(sbst.getRootNode());
		
		System.out.println("Searching for 9...");
		if (sbst.searchElement(new Integer(9)) == null){
			System.out.println("9 was not found!");
		}else{
			System.out.println("9 was found!");
		}
		System.out.println("Searching for 99...");
		if (sbst.searchElement(new Integer(99)) == null){
			System.out.println("99 was not found!");
		}else{
			System.out.println("99 was found!");
		}
	}
}
