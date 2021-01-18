package exercise1.binarysearchtree;

public class SimpleTreeNode<E> {
	/************* CLASS VARIABLES ********************************************/
	private E value = null;  //Element value to be held in this node
	private SimpleTreeNode<E> leftChildTreeNode = null;
	private SimpleTreeNode<E> rightChildTreeNode = null;
	private SimpleTreeNode<E> parentTreeNode = null;
	/************* GETTERS AND SETTERS******************************************/
	/**
	 * @return the value
	 */
	public E getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(E value) {
		this.value = value;
	}
	/**
	 * @return the leftChildTreeNode
	 */
	public SimpleTreeNode<E> getLeftChildTreeNode() {
		return leftChildTreeNode;
	}
	/**
	 * @param leftChildTreeNode the leftChildTreeNode to set
	 */
	public void setLeftChildTreeNode(SimpleTreeNode<E> leftChildTreeNode) {
		this.leftChildTreeNode = leftChildTreeNode;
		if(leftChildTreeNode != null){
			leftChildTreeNode.setParentTreeNode(this);
		}
	}
	/**
	 * @return the rightChildTreeNode
	 */
	public SimpleTreeNode<E> getRightChildTreeNode() {
		return rightChildTreeNode;
	}
	/**
	 * @param rightChildTreeNode the rightChildTreeNode to set
	 */
	public void setRightChildTreeNode(SimpleTreeNode<E> rightChildTreeNode) {
		this.rightChildTreeNode = rightChildTreeNode;
		if(rightChildTreeNode != null){
			rightChildTreeNode.setParentTreeNode(this);
		}
	}
	/**
	 * @return the parentTreeNode
	 */
	public SimpleTreeNode<E> getParentTreeNode() {
		return parentTreeNode;
	}
	/**
	 * @param parentTreeNode the parentTreeNode to set
	 */
	public void setParentTreeNode(SimpleTreeNode<E> parentTreeNode) {
		this.parentTreeNode = parentTreeNode;
	}
	/************* CONSTRUCTORS **************************************************/
	public SimpleTreeNode(E value){
		setValue(value);
	}
	/************* METHODS ******************************************************/
	@Override
	public String toString() {
		return getValue().toString();
	}
}
