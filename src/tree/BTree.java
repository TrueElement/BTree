package tree;

//Import Statements
//Local Imports
import tree.TreeNode;
//External Imports


public class BTree {
	public TreeNode root;
	int numRootSplits = 0;
	int positionValue = 0;
	NaturalComparator<String> cmp;

	public BTree() {
		root = new TreeNode();
		cmp = new NaturalComparator<String>();
	}
	
	public TreeNode getRoot(){
		return root;
	}

 
	public void setRoot(TreeNode root){
		this.root = root;
	}
	
	public boolean contains(String value){    
		boolean to_return = false;
		if(value == null) {
			to_return =  false;
		} else {
			to_return = contains(value, root);
		}
		return to_return;
	}       

	private boolean contains(String value, TreeNode node){
		boolean to_return = false;
		if(node.keys.contains(value)){
			to_return = true;
		} else if (node.isLeaf() && !node.keys.contains(value)){
			to_return = false;
		}
		if(to_return == false) {
			TreeNode temp = node.getLinked(value);
			if(temp != null) {
				to_return = contains(value, temp);
			}
		}
		return to_return;
	}

	public int getPostionValue(){
		return positionValue;
	}

	public void add(String x){
		if(root.isFull()){
			numRootSplits++;
			System.out.println("Splitting Root.");
			root.splitRoot();
		}
		add(x,root);
	}
	
	private void add(String x,TreeNode node){
		if(node.isLeaf()){
			node.insertKey(x);
		} else {
			TreeNode temp = node.getLinked(x);
			if(temp.isFull()){
				node.nodeSplit(temp);
				temp = node.getLinked(x); 
			}
			add(x,temp);
		}
	}

	public TreeNode findParent(String value, TreeNode node){
		TreeNode temp, parent;
			temp = node.getLinked(value);
		if(temp.keys.contains(value)) {
			parent = node;
		} else {
			parent = findParent(value, temp);
		}
		return parent;
	}

	public TreeNode findLink(TreeNode node, String myVal){
		positionValue = 0;
		for(String k : node.keys){
			if(myVal.compareTo(k) > 0){
				positionValue++;
			}
			else{
				break;
			}
		}
		return node.links.get(positionValue);
	}

	public void remove(String x){
		if(root.isEmpty()) {
			rootIsEmpty();
		}
		if(root.keys.contains(x)) {
			removeRoot(x);
		} else if(contains(x)){
			remove(root,x);
		} else{
			System.out.println();
			System.out.println("REMOVE - Not Found: " + x);
		}
	}
	
	private void removeRoot(String x) {
		int value_index;
		String predecessor;
		
		//if i am a leaf 
		if(root.isLeaf()){
			//remove from me 
			root.keys.remove(root.keys.indexOf(x));
		} else {
			//else get the index of the value to be removed
			value_index = root.keys.indexOf(x);
			//if i have a predecessor
			if(root.hasPredecessor(value_index)) {
				//get the predecessor out of the root
				predecessor = root.rootPredecessor(value_index);
				//set predecessor into the root
				root.keys.set(value_index, predecessor);  
				repairTree(root);
			} else {
				root.links.remove(value_index);
				root.keys.remove(value_index);
			}
		}
		

	}

	private void remove(TreeNode node,String value){
		TreeNode valueParent, valueNode;
		int value_index, value_position; 
		String predecessor;

		valueParent = findParent(value,node);
		valueNode = valueParent.getLinked(value);
		value_position = valueParent.linkIndexSearch(value);
		boolean value_leaf = valueNode.isLeaf();
		
		//if value node is a leaf
		if(value_leaf){
			//get the index of the value to be removed
			value_index = valueNode.keys.indexOf(value);
			//then remove the value out of value node at the index
			valueNode.keys.remove(value_index);
			//check to see that the node needs to be repaired
			if(valueNode.fillStatus() == -1){
				valueParent.repairLeaf(value_position);  
			}
		} else{
			value_index = valueNode.keys.indexOf(value);
			predecessor = valueNode.getPredecessor(value_index);
			if(valueNode.fillStatus() == -1) {
				//repairTree(node);
				repairTree(valueParent);
			}
			//for debugging
			if(predecessor == null) {
				System.out.println("Null Predecessor for - " + value);
			}
			//if the value node does not have the value any more
			//re-find the parent
			//this is caused by the predecessor
			if(!valueNode.keys.contains(value)) {
				valueParent = findParent(value, node);
				valueNode = valueParent.getLinked(value);
				value_index = valueNode.keys.indexOf(value);
			}
			//add the predecessor to value node at the specified index
			valueNode.keys.set(value_index, predecessor);  
			//valueNode.removeCopy(value_index);
		}
		if(valueParent.keys.equals(root.keys)) {
			return;
		}
		if(valueParent.fillStatus() == -1) {
			repairTree(node);
		}
	}
	
	private void repairTree(TreeNode node) {
		TreeNode child;
		int child_fill = -3;
		for(int i = 0; i < node.links.size(); i++) {
			child = node.links.get(i);
			child_fill = child.fillStatus();
			if(child.isLeaf() && child_fill == -1) {
				node.repairLeaf(i);
			} else {
				repairTree(child);
				if(child.fillStatus() == -1) {
					node.reapairInternal(i);
				}
			}
		}
	}
	
	public String toString() {
		StringBuffer ss = new StringBuffer();
		ss = toString(ss, root);
		return ss.toString();
	}
	
	private StringBuffer toString(StringBuffer ss, TreeNode x) {
		ss.append(x.toString());
		ss.append(System.getProperty("line.separator"));
		for(int i = 0; i < x.links.size(); i++) {
			ss = toString(ss, x.links.get(i));
		}
		return ss;
	}
	public void rootIsEmpty(){
			TreeNode temp = root.links.get(0);
			root = null;
			this.setRoot(temp);
	}
}
