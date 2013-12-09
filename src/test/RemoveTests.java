package test;

//Import Statements
//Local Imports
import tree.BTree;
import tree.TreeFiller;
import tree.TreeNode;



//External Imports
import java.util.ArrayList;

public class RemoveTests {
	//Boolean Flags
	public boolean remove_one = false;
	public boolean remove_all_order = false;
	public boolean remove_hundred_order = false;
	
	//Instance Objects
	TreeFiller fill;
	
	public RemoveTests() {
		fill = new TreeFiller();
		fill.setFile("words.txt");
	}
	
	public void run() {
		if(remove_one) {
			System.out.println("---------Start Remove One Test----------");
			removeOne();
			System.out.println("----------End Remove One Test-----------");

		}
		
		if(remove_all_order) {
			System.out.println("---------Start Remove All Test----------");
			System.out.println("-------        In Order         --------");
			removeAllInOrder();
			System.out.println("----------End Remove All Test-----------");
		}
		
		if(remove_hundred_order) {
			System.out.println("-------Start Remove Hundred Test--------");
			System.out.println("-------        In Order         --------");
			removeHundredInOrder();
			System.out.println("--------End Remove Hundred Test---------");
		}
	}
	
	/**
	 * Test remove a single element from the tree.
	 */
	public void removeOne() {
		
	}
	
	/**
	 * Test remove all elements from the tree.
	 */
	public void removeAllInOrder() {
	    ArrayList<String> words;
	    BTree tree;
	    int word_count;
	    
	    fill.newTree();
	    word_count = fill.fillTree(600);
	    words = fill.getWordsRead();
	    tree = fill.getTree();
	    
	    System.out.println("Read " + word_count + " Words:");
	    System.out.println(words);
	    int removed = 0;
        for(String w : words){
        	System.out.print(removed + " Removing: " + w);
        	removed += 1;
        	tree.remove(w);
        	System.out.print(" Successful.");
        	System.out.println();
        }
        
        int not_removed = 0;
        for(String w : words) {
        	if(tree.contains(w)) {
        		System.out.println("Found: " + w);
        		not_removed += 1;
        	}
        }
        
        if(not_removed != 0) {
        	System.out.println("Remove all Test FAILED");
        } else {
        	System.out.println("Remove all Test PASSED");
        }                   
	}
	
	public void removeHundredInOrder() {
	    ArrayList<String> words;
	    BTree tree;
	    int word_count;
	    
	    fill.newTree();
	    word_count = fill.fillTree(100);
	    words = fill.getWordsRead();
	    tree = fill.getTree();
	    
	    System.out.println("Read " + word_count + " Words:");
	    System.out.println(words);
	    int removed = 0;
        for(String w : words){
        	System.out.print(removed + " Removing: " + w);
        	removed += 1;
        	tree.remove(w);
        	System.out.print(" Successful.");
        	System.out.println();
        }
        
        int not_removed = 0;
        for(String w : words) {
        	if(tree.contains(w)) {
        		System.out.println("Found: " + w);
        		not_removed += 1;
        	}
        }
        
        if(not_removed != 0) {
        	System.out.println("Remove hundred Test FAILED");
        } else {
        	System.out.println("Remove hundred Test PASSED");
        }     
	}
}