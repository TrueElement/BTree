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
		
		if(root.isLeaf()){
			root.keys.remove(root.keys.indexOf(x));
		} else {
			value_index = root.keys.indexOf(x);
			if(root.hasPredecessor(value_index)) {
				predecessor = root.getPredecessor(value_index);
				root.keys.set(value_index, predecessor);  
				root.removeCopy(value_index);
			} else {
				root.links.remove(value_index);
				root.keys.remove(value_index);
			}
		}
		
		if(root.isEmpty()) {
			TreeNode temp = root.links.get(0);
			root = null;
			this.setRoot(temp);
		}
	}

	private void remove(TreeNode node,String value){
		TreeNode valueParent, valueNode;
		int value_index, value_position; 
		String predecessor;

		valueParent = findParent(value,node);
		valueNode = valueParent.getLinked(value);
		value_position = valueParent.linkIndexSearch(value);

		if(valueNode.isLeaf()){
			value_index = valueNode.keys.indexOf(value);
			valueNode.keys.remove(value_index);
			if(valueNode.fillStatus() == -1){
				valueParent.repairLeaf(value_position);  
			}
		} else{
			value_index = valueNode.keys.indexOf(value);
			predecessor = valueNode.getPredecessor(value_index);
			if(predecessor == null) {
				System.out.println("Null Predecessor for - " + value);
			}
			valueNode.keys.set(value_index, predecessor);  
			valueNode.removeCopy(value_index);
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
}
