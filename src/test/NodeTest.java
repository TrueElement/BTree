package test;

import tree.BTree;
import tree.TreeNode;


public class NodeTest {
	public boolean split_test;
	public boolean add_test;
	
	public NodeTest() {
		
	}
	
	public void run() {
		if(split_test) {
			
		} else if(add_test) {
			
		}
	}
	
	/**
	 * Method to test adding elements to a node.
	 */
	public void addTest() {
		TreeNode node = new TreeNode();

		node.insertKey("AAAAA"); 
		node.insertKey("BBBBB"); 
		node.insertKey("CCCCC");

		String a,b,c; 
		a = node.getKeys().get(0);
		b = node.getKeys().get(1);
		c = node.getKeys().get(2);

		boolean result = a.equals("AAAAA") && b.equals("BBBBB") && c.equals("CCCCC");

		if(result) {
			System.out.println("Add to Node Test Passed.");
		} else {
			System.out.println("Add to Node Test Failed");
		}
	}
	
	/**
	 * Method to test splitting of a node in a tree.
	 */
	public void splitTest() {
		// this test is to see if 
		// i can split the root
		BTree  myTree = new BTree();
		TreeNode myNode;
                
		myTree.add("Abe");
		myTree.add("Abo");
		myTree.add("Abu");
		myTree.add("Ada");
                myTree.add("Al");
		myTree.add("Ali");
		myTree.add("Amy");
		myTree.add("Ann");
                myTree.add("Ben");
		myTree.add("DEC");
		myTree.add("Dan");
		myTree.add("Dar");
                myTree.add("De");
//		myTree.add("Dee");
//		myTree.add("Del");
//		myTree.add("Des");

		myNode = myTree.getRoot();
                
                

		String a;
		TreeNode b,c;

		a = myNode.getKeys().get(0);
		b = myNode.getLinks().get(0);
		c = myNode.getLinks().get(1); 

//                System.out.println("root: "+ myNode.keys);
//                System.out.println("left: "+ myNode.links.get(0).keys);
//                System.out.println("midleft: "+ myNode.links.get(1).keys);
               // System.out.println("midright: "+ myNode.links.get(2).keys);
             //   System.out.println("right: "+ myNode.links.get(3).keys);
		boolean result = a!=null && b!=null && c!=null;
	}
	

}