package test;
//Import Statements
//Local Imports
import tree.BTree;
import tree.TreeFiller;
import tree.TreeNode;



//External Imports
import java.util.ArrayList;


public class AddTests {
	//Boolean Flags
	boolean fill_node = false;
	boolean add_all = false;
	boolean add_100 = false;
	boolean root_split = false;
	//Instance Objects
	TreeFiller fill;
	
	public AddTests() {
		fill = new TreeFiller();
		fill.setFile("words.txt");
	}
	
	public void run() {
		if(add_all) {
			System.out.println("-------------Start Add All--------------");
			addAll();
			System.out.println("--------------End Add All---------------");
		}
		
		if(add_100) {
			System.out.println("-------------Start Add 100--------------");
			addAll();
			System.out.println("--------------End Add 100--------------");
		}
		
		if(root_split) {
			System.out.println("-----------Start Root Split-------------");
			rootSplit();
			System.out.println("------------End Root Split--------------");
		}
	}
	
	public void addAll() {
		int word_count = 0; 
		int repeated = 0;
		int not_found = 0;
		ArrayList<String> words;
		BTree tree;

		fill.newTree();
		word_count = fill.fillTree();
		tree = fill.getTree();
		repeated = fill.getRepeatCount();
		words = fill.getWordsRead();

		System.out.println("Added: " + word_count + "Repeats: " + repeated);
		for(String w : words) {
			if(tree.contains(w)) {
				continue;
			} else {
				not_found += 1;
			}
		}

		if(not_found > 0){
			System.out.println("Add All Words FAILED"); 
		}
		else{
			System.out.println("Add All Words PASSED");
		}
	}
	
	public void addHundred() {
		
	}
	
	public void rootSplit() {
		BTree  tree = new BTree();
		TreeNode node;
                
		tree.add("Abe");
		tree.add("Abo");
		tree.add("Abu");
		tree.add("Ada");
        tree.add("Al");
		tree.add("Ali");
		tree.add("Amy");
		tree.add("Ann");
        tree.add("Ben");
		tree.add("DEC");
		tree.add("Dan");
		tree.add("Dar");
        tree.add("De");
        
        System.out.println(tree);
	}
}