package exercise1.binarysearchtree;

public interface SimpleBinarySearchTreeInterface<E> {
	/**
	 * Adds the element to the approriate place in a binary search tree.
	 * @param element
	 */
	public void addElement(E element);
	
	/**
	 * Removes the first occurrence of an eleemnt from a binary search tree
	 * and returns it.
	 * @param element
	 * @return
	 */
	public E removeElement(E element);
	
	/**
	 * Returns the root node of this binary search tree
	 * @return
	 */
	public SimpleTreeNode<E> getRootNode();
	
	/**
	 * Seraches the binary search tree to see if it contains the element passed in.  If it does, 
	 * it returns the element from the tree.  If it doesn't, it returns null;
	 * @param element
	 * @return
	 */
	public E searchElement(E element);

}
