package tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


//leafSteals need to be fixed as well as max keys
public class TreeNode{
	//Instance Variables
	int MAXKEYS = 7;
	public ArrayList<TreeNode> links;
	public ArrayList<String> keys;
	NaturalComparator<String> cmp;

	public TreeNode() {
		links = new ArrayList<TreeNode>();
		keys = new ArrayList<String>();
		cmp = new NaturalComparator<String>();
	}

	public TreeNode(ArrayList<String> key) {
		this.keys = key;
		links = new ArrayList<TreeNode>();
		keys = new ArrayList<String>();
		cmp = new NaturalComparator<String>();
	}
	
	public boolean isLeaf() {
		return links.isEmpty();
	}
	
	public boolean isFull(){ 
		return (keys.size() == MAXKEYS);
	}
	
	public boolean isEmpty() {
		return (keys.size() == 0);
	}
	
	public boolean hasPredecessor(int index) {
		boolean to_return = false;
		if(index - 1 < links.size() && index - 1 > 0) {
			if(links.get(index - 1).isEmpty()) {
				to_return = false;
			} else {
				to_return = true;
			}
		} else {
			to_return = false;
		}
		return to_return;
	}
	
	public int fillStatus(){
		int min_keys = MAXKEYS/2;
		int to_return;

		if(keys.size() < min_keys){
			to_return = -1;
		} else if(keys.size() == min_keys){
			to_return = 0;
		} else{
			to_return = 1;
		}
		return to_return;
	}


	public List<String> getKeys() {
		return Collections.unmodifiableList(keys);
	}

	public List<TreeNode> getLinks() {
		return Collections.unmodifiableList(links);
	}

	public void insertKey(String x){
		keys.add(x);        
		Collections.sort(keys);
	}
	
	public int linkIndexSearch(String key) {
		int to_return = 0;
		for(String k : keys) {
			if(cmp.compare(key, k) > 0) {
				to_return += 1;
			} else {
				break;
			}
		}
		return to_return;
	}
	
	public TreeNode getLinked(String key) {
		if(links.size() == 0) {
			return null;
		}
		int linkIndex = linkIndexSearch(key);
		if(linkIndex < 0 || linkIndex > links.size()) {
			return null;
		} else {
			return links.get(linkIndex);
		}
	}
	
	public String getPredecessor(int index){
		int next_link;
		TreeNode current_link;
		String value = null; //Did we find??
		current_link = links.get(index);
		
		if(current_link.isLeaf()){
			if(!current_link.isEmpty()) {
				value = current_link.keys.remove(current_link.keys.size() -1);
				if(current_link.fillStatus() == -1) {
					repairLeaf(index);
				}
			} 
		} else {
			next_link = current_link.links.size() -1;
			if(next_link > -1) {
				value = current_link.getPredecessor(next_link);
			}
		}
		System.out.println(" Found Predecessor - " + value);
		return value;
	}  

	public void splitRoot(){
		TreeNode left, right;
		left = leftSplitRoot();
		right = rightSplitRoot(); 
		
		if(!links.isEmpty()) {
			left = leftLink(left); 
			right = rightLink(right);
		}
		links.add(left);
		links.add(right);
	}
	
	private TreeNode rightSplitRoot(){
		TreeNode right = new TreeNode(); 
		String to_move;
		while(keys.size() != 1){
			to_move = keys.remove(1);
			right.keys.add(to_move);
		}
		return right;
	}

	private TreeNode leftSplitRoot(){
		TreeNode left = new TreeNode();
		String to_move;
		int count = (MAXKEYS/2); 
		for(int i =0; i < count; i++){
			to_move = keys.remove(0);
			left.keys.add(to_move); 
		}
		return left; 
	}

	private TreeNode leftLink(TreeNode left){
		TreeNode temp; 
		int linkCount = (MAXKEYS/2); 
		for(int i = 0; i<= linkCount;i++){
			temp = links.remove(0);
			left.links.add(temp); 
		}
		return left;
	}

	private TreeNode rightLink(TreeNode right){
		TreeNode temp;
		while(!links.isEmpty()){
			temp = links.remove(0);
			right.links.add(temp);
		}
		return right;
	}	

	public void nodeSplit(TreeNode currentLink){
		int index = -1;
		String promoted = currentLink.keys.remove(MAXKEYS / 2);
			keys.add(promoted);
			Collections.sort(keys);
			index = keys.indexOf(promoted);
		
		TreeNode split_node = new TreeNode();
			links.add(index + 1, split_node);
		
		String value;
		
		for(int i = MAXKEYS / 2; i < currentLink.keys.size(); i++) {
			value = currentLink.keys.get(i);
			split_node.keys.add(value);
		}
		
		TreeNode tempLink;
		int mid_index = (MAXKEYS / 2) + 1;
		while(mid_index < currentLink.links.size()) {
			tempLink = currentLink.links.remove(mid_index);
			split_node.links.add(tempLink);
		}
		
		mid_index = (MAXKEYS / 2);
		while(mid_index != currentLink.keys.size()) {
			currentLink.keys.remove(mid_index);
		}
	}

	//i am the parent 
	// i have the index of the remove node 
	// public void leafStealFromLeftPlaceInRight(int indexRemove,String value){
	public void leafStealLeftRight(int index) {
		TreeNode toRepair, toSteal;
		String parentValue, stolenValue;
			toRepair = links.get(index);
			toSteal = links.get(index - 1);
			stolenValue = toSteal.keys.remove(toSteal.keys.size() - 1);
			parentValue = keys.remove(index - 1);
			toRepair.keys.add(0, parentValue);
			keys.add(index - 1, stolenValue);
	}
	
	public void leafStealRightLeft(int index) {
		TreeNode toRepair, toSteal;
		String parentValue, stolenValue;
			toRepair = links.get(index);
			toSteal = links.get(index + 1);
			stolenValue = toSteal.keys.remove(0);
			parentValue = keys.remove(index);
			toRepair.keys.add(toRepair.keys.size(), parentValue);
			keys.add(index, stolenValue);
	}
	
	public void stealLeftRightLink(int index) {
		TreeNode toRepair, toSteal, stolenLink;
		String parentValue, stolenValue;
			toRepair = links.get(index);
			toSteal = links.get(index - 1);
			stolenValue = toSteal.keys.remove(toSteal.keys.size() - 1);
			parentValue = keys.remove(index - 1);
			stolenLink = toSteal.links.remove(toSteal.links.size() - 1);
			keys.add(index - 1, stolenValue);
			toRepair.keys.add(0, parentValue);
			toRepair.links.add(0, stolenLink);
	}
	
	public void stealRightLeftLink(int index) {
		TreeNode toRepair, toSteal, stolenLink;
		String parentValue, stolenValue;
			toRepair = links.get(index);
			toSteal = links.get(index + 1); 
			stolenValue = toSteal.keys.remove(0);
			parentValue = keys.remove(index);
			stolenLink = toSteal.links.remove(0);
			keys.add(index, stolenValue);
			toRepair.keys.add(parentValue);
			toRepair.links.add(stolenLink); 
	}

//leaf merge
	public void mergeRight(int index) {
		TreeNode toRemove, toFill; 
		String parentValue;
			toRemove = links.get(index);
			toFill = links.get(index + 1);
			parentValue = keys.remove(index);
			toFill.keys.add(0,parentValue);

		String w;
		int i = 0;
		while(!toRemove.keys.isEmpty()) {
			i = toRemove.keys.size() - 1;
			w = toRemove.keys.remove(i);
			toFill.keys.add(0, w);
		}
		links.remove(index);
	}
	
//internal merge
	public void mergeRightLink(int index) {
		TreeNode toRemove, toFill; 
		String parentValue; 
			toRemove = links.get(index);
			toFill = links.get(index + 1);
			parentValue = keys.remove(index);
			toFill.keys.add(0, parentValue); 
 

		String w;
		int i = 0;
		while(!toRemove.keys.isEmpty()) {
			i = toRemove.keys.size() - 1;
			w = toRemove.keys.remove(i);
			toFill.keys.add(0, w);
		}


		TreeNode l;
		while(!toRemove.links.isEmpty()){
			i = toRemove.links.size() - 1;
			l = toRemove.links.remove(i);
			toFill.links.add(0, l);
		}
		links.remove(index);
	}
	
	//leaf merge
	public void mergeLeft(int index) {
		TreeNode toRemove, toFill; 
		String parentValue; 
			toRemove = links.get(index);
			toFill = links.get(index - 1);
			parentValue = keys.remove(index);
			toFill.keys.add(parentValue);

		String w;
		while(!toRemove.keys.isEmpty()) {
			w = toRemove.keys.remove(0);
			toFill.keys.add(w);
		}
		links.remove(index);
	}
	
	// this is internal merge
	public void mergeLeftLink(int index) {
		TreeNode toRemove, toFill; 
		String parentValue;
			toRemove = links.get(index);
			toFill = links.get(index - 1);
			parentValue = keys.remove(index);
			toFill.keys.add(parentValue); 

			String w;
			while(!toRemove.keys.isEmpty()) {
				w = toRemove.keys.remove(0);
				toFill.keys.add(w);

			}
			
			TreeNode l;
			while(!toRemove.links.isEmpty()){
				l = toRemove.links.remove(0);
				toFill.links.add(l);
			}
		links.remove(index);
	}

	public void removeCopy(int index){
		int next_link;
		TreeNode current_link;
		String value;

		current_link = links.get(index);
		if(current_link.isLeaf()){
			value = current_link.keys.remove(current_link.keys.size() -1);
			System.out.println("Link Copy Removed: " + value);
			if(current_link.fillStatus() == -1){
				repairLeaf(index);
			}
		} else{
			next_link = current_link.links.size() -1;
			current_link.removeCopy(next_link);
			if(current_link.fillStatus() == -1){
				reapairInternal(index);
			}
		}
	}

	public void repairLeaf(int index){
		TreeNode right, left;
		boolean hasRight = (index + 1) < links.size();
		boolean hasLeft = (index - 1) > -1;
		int right_fill = -1;
		int left_fill = -1;
		
		if(links.size() == 2) {
			repairSingle();
			return;
		}
		if(hasRight) {
			right = links.get(index + 1);
			right_fill = right.fillStatus();
		}
		
		if(hasLeft) {
			left = links.get(index - 1);
			left_fill = left.fillStatus();
		}
		
		if(hasRight && right_fill > 0) {
			leafStealRightLeft(index);
		} else if(hasLeft && left_fill > 0) {
			leafStealLeftRight(index);
		} else if(hasRight && right_fill == 0) {
			mergeRight(index);
		} else if(hasLeft && left_fill == 0) {
			mergeLeft(index);
		}
	}
	
	public void repairSingle() {
		TreeNode left, right;
			left = links.get(0);
			right = links.get(1);
		String w;
		while(!left.keys.isEmpty()) {
			w = left.keys.remove(left.keys.size() - 1);
			keys.add(0,w);
		}
		
		while(!right.keys.isEmpty()) {
			w = right.keys.remove(0);
			keys.add(w);
		}
		links.clear();
	}

	public void reapairInternal(int index){
		TreeNode right, left;

		boolean hasRight = (index + 1) < links.size();
		boolean hasLeft = (index - 1) > -1;
		int right_fill = -1;
		int left_fill = -1;
		
		if(hasRight) {
			right = links.get(index + 1);
			right_fill = right.fillStatus();
		}
		
		if(hasLeft) {
			left = links.get(index - 1);
			left_fill = left.fillStatus();
		}
		
		if(hasRight && right_fill > 0) {
			stealRightLeftLink(index);
		} else if(hasLeft && left_fill > 0) {
			stealLeftRightLink(index);
		} else if(hasRight && right_fill == 0) {
			mergeRightLink(index);
		} else if(hasLeft && left_fill == 0) {
			mergeLeftLink(index);
		}
	}
	
	public String toString() {
		if(keys.isEmpty()) {
			return "[empty]";
		} else {
			return keys.toString();
		}
	}
	
	//TODO Remove fails at 63
	//TODO change removeCopy - take out repairLeaf - predecessor calls it
	//TODO predecessor call internal repair
	//TODO remove removeCopy method
	//TODO test remove reverse order
	
}