package exercise1.binarysearchtree;


public class SimpleBinarySearchTree<E> implements SimpleBinarySearchTreeInterface<E>{
	/******************  CLASS VARIABLES  ***************************************/
	private SimpleTreeNode<E> rootNode = null;
	
	/******************  GETTERS AND SETTERS ************************************/
	public SimpleTreeNode<E> getRootNode(){
		return rootNode;
	}
	
	public void setRootNode(SimpleTreeNode<E> root){
		this.rootNode = root;
	}
	
	/***************** CONSTRUCTORS *********************************************/
	public SimpleBinarySearchTree(){
		
	}
	
	/***************** METHODS *************************************************/

	public E removeElement(E targetElement){
		E resultElement = null;
		SimpleTreeNode<E> resultingNode = null;
		if(getRootNode() != null){
			resultingNode = findNode(getRootNode(), targetElement);
		}
		if(resultingNode != null){
			resultElement = resultingNode.getValue();
			replaceNode(resultingNode);//replace the node with its successor
		}
		return resultElement;
	}
	
	/**
	 * Finds the node in the tree that contains the target element value passed in (if it exists).
	 * It starts with the node passsed in and checks to see if that node's value is equal to the target element
	 * passed in.  If it is, it sets the reult as the node that was passed in.  If it isn't, then it compare's the 
	 * target element to the node's value.  If it is less, it checks to see if the node has a left child.  If it doesn't 
	 * it sets the result to null.  If it does, then it call this same method recursively, passing in the 
	 * node's left child node and the target element.  If it is greater, it checks to see if the node has a right child.
	 * If it doesn't, it sets the result to null.  If it does, then then it calls this same method recursively, passing in the 
	 * node's right child node and the target element.  The very last statement in this method should return the reult (which 
	 * could be null).
	 * @param node
	 * @param targetLement
	 * @return
	 */
	private SimpleTreeNode<E> findNode(SimpleTreeNode<E> node, E targetElement){

		//TODO:  PUT YOUR CODE HERE
		Comparable<E> comparableElement = (Comparable<E>)targetElement;
		SimpleTreeNode<E> result = null;
		
		if(comparableElement.compareTo(node.getValue()) == 0){
			result = node;
		}else if(comparableElement.compareTo(node.getValue()) < 0){
			if(node.getLeftChildTreeNode() == null){
				result = null;
			}
			else{
				result = findNode(node.getLeftChildTreeNode(), targetElement);
			}
		}else{
			if(node.getRightChildTreeNode() == null){
				result = null;
			}else{
				result = findNode(node.getRightChildTreeNode(), targetElement);
			}
		}
		return result;
	}
	/**
	 * Calls one of three other methods based on whether the node passed in has 0, 1 or 2 child nodes.
	 * @param node
	 */
	private void replaceNode(SimpleTreeNode<E> node){
		if (getChildCount(node) == 0){
			//Case 1:  Node has no children.
			replaceNodeWithNoChildren(node);
		}else if (getChildCount(node) == 1){
			//Case 2: Node has exactly one child.
			replaceNodeWithOneChild(node);
		}else{
			//Case 3: Node has exactly two children.
			replaceNodeWithTwoChildren(node);
		}
	}
	
	/**
	 * Replaces a node that has two children with its successor node.  This requires the following steps:
	 * 1) Find the successor parent's node.  This will be found by following the right child's left children to the bottom.
	 * 2) If the successor's parent is the node itself, set the successor's left child to be the node's left child
	 *    and skip to step 6.
	 * 3) Set the successor's parent's left child to be the successor's right child.
	 * 4) Set the successor's right child to be the node's right child.
	 * 5) Set the successor's left child to be the node's left child.
	 * 6) Set the node parent's right node to be the successor node.
	 * @param node
	 * @param parent
	 */
	private void replaceNodeWithTwoChildren(SimpleTreeNode<E> node){
		//Step 1:  Find the successor's parent
		SimpleTreeNode<E> successor = findSuccessor(node);
		//Step 2: See if successor's parent is the node being replaced and, if so, set the left
		//        child of the successor to be the left child of the node
		if(successor.getParentTreeNode() == node){
			successor.setLeftChildTreeNode(node.getLeftChildTreeNode());
		}else{//Do steps 3 - 5
			//Step 3: Set the successor's parent's left child to be the successor's right child.
			successor.getParentTreeNode().setLeftChildTreeNode(successor.getRightChildTreeNode());
			
			//Step 4:  Set the successor's right child to be the node's right child and set the node's right child to null.

			successor.setRightChildTreeNode(node.getRightChildTreeNode());
			node.setRightChildTreeNode(null);
			
			//Step 5: Set the successor's left child to be the node's left child and set the node's left child to be null;

			successor.setLeftChildTreeNode(node.getLeftChildTreeNode());
			node.setLeftChildTreeNode(null);
			
		}
		//Step 6: If the node being replaced is the root node, just set the successor as the new root. 
		//        Otherwise, set the successor as the parent's child (making it the same child as the
		//		  node that was replaced.

		if(node == getRootNode()){
			setRootNode(successor);
		}else{
			if(node == node.getParentTreeNode().getLeftChildTreeNode()){
				node.getParentTreeNode().setLeftChildTreeNode(successor);
			}else{
				node.getParentTreeNode().setRightChildTreeNode(successor);
			}
		}
		
		//Step 7: Set the parent of the successor node to the node's parent


	}
	
	/**
	 * Finds the successor of the node passed in.  To find the successor, we start with the right child
	 * of the node and then traverse the left children until we reach the bottom of the tree (i.e., where the left
	 * child is then null.  This will then be the successor node.
	 * @param node
	 * @return
	 */
	private SimpleTreeNode<E> findSuccessor(SimpleTreeNode<E> node){

		//TODO:  PUT YOUR CODE HERE
		SimpleTreeNode<E> result = null;
		if(node.getRightChildTreeNode() != null){
			result = node.getRightChildTreeNode();
			while(result.getLeftChildTreeNode() != null){
				result = result.getLeftChildTreeNode();
			}
		}
		return result;
	}
	
	/**
	 * Returns the number of children belonging to the node passed in.  The result should be
	 * 0, 1, or 2.  Obviously, only non-null children should be included in the countt!
	 * @param node
	 * @return
	 */
	private int getChildCount(SimpleTreeNode<E> node){

		//TODO:  PUT YOUR CODE HERE
		int result = 0;
		if(node.getLeftChildTreeNode() != null){
			result++;
		}
		if(node.getRightChildTreeNode() != null){
			result++;
		}
		return result;
	}
	
	/**
	 * Replaces a node that has no children.  If the node is the root, then we just
	 * set the root to be null.  Otherwise, we determine if the node passed in is the 
	 * parent node's left child or right child and set that child to be null (effectively 
	 * deleting that child).
	 * @param node
	 * @param parent
	 */
	private void replaceNodeWithNoChildren(SimpleTreeNode<E> node){

		//TODO:  PUT YOUR CODE HERE
		if(node == getRootNode()){
			setRootNode(null);
		}else if(node == node.getParentTreeNode().getLeftChildTreeNode()){
			node.getParentTreeNode().setLeftChildTreeNode(null);
		}else if(node == node.getParentTreeNode().getRightChildTreeNode()){
			node.getParentTreeNode().setRightChildTreeNode(null);
		}
	}
	/**
	 * Replaces a node that has exactly one child.  This simply replaces the node with 
	 * its child and sets the replacement node's parent to the parent of the node that 
	 * was replaced.
	 * @param node
	 */
	private void replaceNodeWithOneChild(SimpleTreeNode<E> node){

		//TODO:  PUT YOUR CODE HERE
		SimpleTreeNode<E> successorNode = null;
		SimpleTreeNode<E> parentNode = node.getParentTreeNode();
		if(node.getLeftChildTreeNode() != null){
			successorNode = node.getLeftChildTreeNode();
		}else{
			successorNode = node.getRightChildTreeNode();
		}
		if(parentNode == null){
			setRootNode(successorNode);
		}else if(node == parentNode.getLeftChildTreeNode()){
			parentNode.setLeftChildTreeNode(successorNode);
		}else{
			parentNode.setRightChildTreeNode(successorNode);
		}
		
	}

	public void addElement(E element){
		//If the tree is empty, create a root node from the element
		if (getRootNode() == null){
			SimpleTreeNode<E> node = new SimpleTreeNode<>(element);
			setRootNode(node);
		}else{ 
			addElement(element, getRootNode());
		}
	}
	
	/**
	 * Adds an element to the tree, starting at the tree node passed in.  This method
	 * is called recursively until the proper locationfor the node is found.
	 * @param element
	 * @param node
	 */
	private void addElement(E element, SimpleTreeNode<E> node){
		Comparable<E> comparableElement = (Comparable<E>)element;
		SimpleTreeNode<E> newNode = new SimpleTreeNode<E>(element);
		if(comparableElement.compareTo(node.getValue()) < 0){
			//The element is less than the node...so go to the left
			//If there is no left child of the current node, make this element the left child
			if(node.getLeftChildTreeNode() == null){
				node.setLeftChildTreeNode(newNode);
			}else{
				//there is already a left child...so add this element to it
				addElement(element, node.getLeftChildTreeNode());
			}
		}else{
			//This element is >= to the node, so go to the right
			//If there is no right child, make this element the right child
			if (node.getRightChildTreeNode() == null){
				node.setRightChildTreeNode(newNode);
			}else{
				//there is already a right child, so add this element to it
				addElement(element, node.getRightChildTreeNode());
			}
		}
	}

	@Override
	public E searchElement(E element) {
		//If the tree is empty, return a null result
		E result = null;
		if (getRootNode() == null){
			result = null;
		}else{ 
			result = searchElement(element, getRootNode());
		}
		return result;
	}
	private E searchElement(E element, SimpleTreeNode<E> node){
		Comparable<E> comparableElement = (Comparable<E>)element;
		E result = null;
		if (comparableElement.compareTo(node.getValue()) == 0){
			result =  node.getValue();
		}else if(comparableElement.compareTo(node.getValue()) < 0){
			//The element is less than the node...so go to the left
			//If there is no left child of the current node, set result to null
			if(node.getLeftChildTreeNode() == null){
				result = null;
			}else{
				//there is a left child...so continue search there
				result = searchElement(element, node.getLeftChildTreeNode());
			}
		}else{
			//This element is > the node, so go to the right
			//If there is no right child, set result to null
			if (node.getRightChildTreeNode() == null){
				result = null;
			}else{
				//there is already a right child, so continue search there
				result = searchElement(element, node.getRightChildTreeNode());
			}
		}
		return result;
	}

	public E removeMin(SimpleTreeNode<E> node)
	{
		E result = null;
		SimpleTreeNode<E> min = null;
		while(node.getLeftChildTreeNode() != null){
			min = node.getLeftChildTreeNode();
		}
		result = min.getValue();
		replaceNode(min);
		
		return result;
	}
	
	public E removeMax(SimpleTreeNode<E> node){
		E result = null;
		SimpleTreeNode<E> max = null;
		while(node.getRightChildTreeNode() != null){
			max = node.getRightChildTreeNode();
		}
		result = max.getValue();
		replaceNode(max);
		
		return result;
	}
}
