package test;
//Import Statements
//Local Imports
import tree.BTree;
import tree.TreeNode;
//External Imports
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BTreeTests
{
	public static void main(String[] args)
	{
		//order 4tests
		// testAddRoot();
		//RootSplitTest();
		//testSplitValues();
		//testAddBtree();
		//testGetMid();	    
		//testMakeNodeLink();
		//testFillKeys();
		//testDoubleSplit1();
		//order 8 tests
	//	addAllWordTest();
		//findMissingWords();
		//findMissingWordsQuick();
        //mutated with maxkeys having a value of 2
        ////**************************these tests are mutated*** |
        //testRemoveFromRootBrain();                       //  V
        //testRemoveFromRootBrainWithLeafRepairs();
        //testRemoveFromRootBrainWithInternalRepairs();
        //testRemoveBrainLeaf();
          //****************************end mutated Tests
       RemoveAllWordsTest();
	}// end main

	public static void testAddRoot()
	{

	}

	public static void RootSplitTest()
	{
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
                
                autoPrint(myNode, 16);

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

		if(result)
		{
			System.out.println("test split passed"); 
		}
		else
		{
		throw new RuntimeException("test split faild");
		}
	}

	public static void testSplitValues()
	{
		// this test is to check if 
		// the links are going in the 
		// right location in the insert method 
		BTree myTree = new BTree();
		TreeNode myNode = new TreeNode();

		myTree.add("hello"); 
		myTree.add("lovely"); 
		myTree.add("queen");
		myTree.add("finding");

		myNode = myTree.getRoot();
		String a,b,c,d; 
		a = myNode.getKeys().get(0);
	System.out.println("SplitValuesKeys: "+ myNode.getKeys()); 
	System.out.println("SplitValueLeftLink: "+ myNode.getLinks().get(0).getKeys()); 
	System.out.println("SplitValueRightLink: "+ myNode.getLinks().get(1).getKeys()); 
		b = myNode.getLinks().get(0).getKeys().get(0);
		c = myNode.getLinks().get(0).getKeys().get(1);
		d = myNode.getLinks().get(1).getKeys().get(0);

		boolean result = a.equals("lovely") && b.equals("finding") && c.equals("hello") && d.equals("queen");

		if(result)
		{
			System.out.println("test link values passed");
		}
		else
		{
			throw new RuntimeException("test link values faild");
		}
	}

	public static void testAddBtree()
	{
		// this test is going to test the add method
		// and place the node in the proper location

		BTree myTree = new BTree();
		TreeNode myNode = new TreeNode();
		//System.out.println(myNode.getKeys());
		//System.out.println(myNode.getLinks().get(0).getKeys());
		//System.out.println(myNode.getLinks().get(1).getKeys());

		myTree.add("hello"); 
		myTree.add("lovely"); 
		myTree.add("queen");
		myTree.add("finding");
		myTree.add("juniper");

		myNode = myTree.getRoot();

		String a,b,c,d,e; 
		System.out.println("keys: "+ myNode.getKeys());
		System.out.println("leftlink: "+ myNode.getLinks().get(0).getKeys());
		System.out.println("rightLink: "+ myNode.getLinks().get(1).getKeys());

		a = myNode.getKeys().get(0);
		b = myNode.getLinks().get(0).getKeys().get(0);
		c = myNode.getLinks().get(0).getKeys().get(1);
		d = myNode.getLinks().get(0).getKeys().get(2);
		e = myNode.getLinks().get(1).getKeys().get(0);

		boolean result = a.equals("lovely") && b.equals("finding") && c.equals("hello") && d.equals("juniper") && e.equals("queen");

		if(result)
		{
			System.out.println("proper add passed");
		}
		else
		{
			throw new RuntimeException("proper faild");
		}
	}
	public static void testGetMid()
	{
		BTree myTree = new BTree();
		TreeNode myNode = new TreeNode();

		myTree.add("hello"); 
		myTree.add("lovely"); 
		myTree.add("queen");
		myTree.add("finding");
		myTree.add("juniper");
		myTree.add("and");

		myNode = myTree.getRoot();

		String a,b,c,d,e,f; 
		System.out.println("getMidKeys: "+ myNode.getKeys());
		System.out.println("getMidLeftLink: " + myNode.getLinks().get(0).getKeys());
		System.out.println("getMidRightLink: " + myNode.getLinks().get(1).getKeys());
		a = myNode.getKeys().get(0);
		b = myNode.getKeys().get(1);
		c = myNode.getLinks().get(0).getKeys().get(0);
		d = myNode.getLinks().get(0).getKeys().get(1);
		e = myNode.getLinks().get(1).getKeys().get(0);
		f = myNode.getLinks().get(2).getKeys().get(0);

		boolean result = a.equals("hello") && b.equals("lovely") && c.equals("and") && d.equals("finding") && e.equals("juniper") && f.equals("queen");

		if(result)
		{
			System.out.println("get mid passed");
		}
		else
		{
			throw new RuntimeException("get mid faild");
		}
	}
	public static void testMakeNodeLink(){
		BTree myTree = new BTree();
		TreeNode myNode = new TreeNode();

		myTree.add("hello"); 
		myTree.add("lovely"); 
		myTree.add("queen");
		myTree.add("finding");
		myTree.add("juniper");
		myTree.add("and");

		myNode = myTree.getRoot();

		String a,b,c,d,e,f; 
		System.out.println("MakeNodeLinksKeys: "+ myNode.getKeys());
		System.out.println("MakeNodeLinksLeftLink: " + myNode.getLinks().get(0).getKeys());
		System.out.println("MakeNodeLinksLeftRightLink: "+myNode.getLinks().get(1).getKeys());
		System.out.println("getMidRightLink: " + myNode.getLinks().get(2).getKeys());
		a = myNode.getKeys().get(0);
		b = myNode.getKeys().get(1);
		c = myNode.getLinks().get(0).getKeys().get(0);
		d = myNode.getLinks().get(0).getKeys().get(1);
		e = myNode.getLinks().get(1).getKeys().get(0);
		f = myNode.getLinks().get(2).getKeys().get(0);

		boolean result = a.equals("hello") && b.equals("lovely") && c.equals("and") && d.equals("finding") && e.equals("juniper") && f.equals("queen");

		if(result)
		{
			System.out.println(" makeNodeLink passed");
		}
		else
		{
			throw new RuntimeException("makeNodeLink faild");
		}
	}
	public static void testFillKeys(){
		BTree myTree = new BTree();
		TreeNode myNode = new TreeNode();

		myTree.add("hello"); 
		myTree.add("lovely"); 
		myTree.add("queen");
		myTree.add("finding");
		myTree.add("juniper");
		myTree.add("and");
		myTree.add("grapes");
		myTree.add("by");

		myNode = myTree.getRoot();

		String a,b,c,d,e,f,g,h; 
		System.out.println("FillKeys-Keys: "+ myNode.getKeys());
		System.out.println("FillKeys-LeftLink: " + myNode.getLinks().get(0).getKeys());
		System.out.println("FillKeys-MidLeftLink: "+myNode.getLinks().get(1).getKeys());
		System.out.println("FillKeys-MidRightLink: "+myNode.getLinks().get(2).getKeys());
		System.out.println("FillKeys-RightLink: " + myNode.getLinks().get(3).getKeys());
		a = myNode.getKeys().get(0);
		b = myNode.getKeys().get(1);
		c = myNode.getKeys().get(2);
		d = myNode.getLinks().get(0).getKeys().get(0);
		e = myNode.getLinks().get(0).getKeys().get(1);
		f = myNode.getLinks().get(1).getKeys().get(0);
		g = myNode.getLinks().get(2).getKeys().get(0); 
		h = myNode.getLinks().get(3).getKeys().get(0);

		boolean result = a.equals("finding") && b.equals("hello") && c.equals("lovely") && d.equals("and") && e.equals("by") && f.equals("grapes") && g.equals("juniper") && h.equals("queen");

		if(result)
		{
			System.out.println(" FillKeys passed");
		}
		else
		{
			throw new RuntimeException("FillKeys faild");
		}
	}// end method
	public static void testDoubleSplit1(){
		BTree myTree = new BTree();
		TreeNode myNode = new TreeNode();
		myNode = myTree.root;

		myTree.add("hello"); 
		myTree.add("lovely"); 
		myTree.add("queen");
		myTree.add("finding");
		myTree.add("juniper");
		myTree.add("and");
		myTree.add("grapes");
		myTree.add("by");
		myTree.add("cards"); 
		myTree.add("during");
		String a,b,c,d,e,f,g,h,i,j; 


		// the root values
		System.out.println("DoubleSplitPt1-Keys: "+ myNode.getKeys());
		//left and right child 
		System.out.println("DoubleSplitPt1-RootLeftLink: " + myNode.getLinks().get(0).getKeys());
		System.out.println("DoubleSplitPt1-RootRightLink: " + myNode.getLinks().get(1).getKeys());
		//the left children
		System.out.println("DoubleSplitPt1-LeftChildLeft: " + myNode.getLinks().get(0).getLinks().get(0).getKeys());
		System.out.println("DoubleSplitPt1-LeftChildMid : " + myNode.getLinks().get(0).getLinks().get(1).getKeys());
		System.out.println("DoubleSplitPt1-LeftChildRight : " + myNode.getLinks().get(0).getLinks().get(2).getKeys());
		//the right children
		System.out.println("DoubleSplitPt1-RightChildLeft : " + myNode.getLinks().get(1).getLinks().get(0).getKeys()); 
		System.out.println("DoubleSplitPt1-RightChildRight : " + myNode.getLinks().get(1).getLinks().get(1).getKeys()); 

		a = myNode.getKeys().get(0);//h
		// root links
		b = myNode.getLinks().get(0).getKeys().get(0);//b
		c = myNode.getLinks().get(0).getKeys().get(1);//f
		//all links in the left
		d = myNode.getLinks().get(0).getLinks().get(0).getKeys().get(0);//a
		e = myNode.getLinks().get(0).getLinks().get(1).getKeys().get(0);//c
		f = myNode.getLinks().get(0).getLinks().get(1).getKeys().get(1);//d
		g = myNode.getLinks().get(0).getLinks().get(2).getKeys().get(0);//g
		h = myNode.getLinks().get(1).getKeys().get(0);//l
		i = myNode.getLinks().get(1).getLinks().get(0).getKeys().get(0);//j 
		j = myNode.getLinks().get(1).getLinks().get(1).getKeys().get(0);//q

		boolean result = a.equals("hello") && b.equals("by") 
			&& c.equals("finding") && d.equals("and") && e.equals("cards") 
			&& f.equals("during") && g.equals("grapes") && h.equals("lovely")
			&& i.equals("juniper") && j.equals("queen"); 

		if(result)
		{
			System.out.println(" DoubleSplitPt1 passed");
		}
		else
		{
			throw new RuntimeException("DoubleSplitPt1 faild");
		}
	}// end method
	public static void testContains(){
		BTree myTree = new BTree();
		TreeNode myNode = new TreeNode();
		myNode = myTree.root;

		myTree.add("hello"); 
		myTree.add("lovely"); 
		myTree.add("queen");
		myTree.add("finding");
		myTree.add("juniper");
		myTree.add("and");
		myTree.add("grapes");
		myTree.add("by");
		myTree.add("cards"); 
		myTree.add("during");
		String a,b,c,d,e,f,g,h,i,j; 


		// the root values
		System.out.println("DoubleSplitPt1-Keys: "+ myNode.getKeys());
		//left and right child 
		System.out.println("DoubleSplitPt1-RootLeftLink: " + myNode.getLinks().get(0).getKeys());
		System.out.println("DoubleSplitPt1-RootRightLink: " + myNode.getLinks().get(1).getKeys());
		//the left children
		System.out.println("DoubleSplitPt1-LeftChildLeft: " + myNode.getLinks().get(0).getLinks().get(0).getKeys());
		System.out.println("DoubleSplitPt1-LeftChildMid : " + myNode.getLinks().get(0).getLinks().get(1).getKeys());
		System.out.println("DoubleSplitPt1-LeftChildRight : " + myNode.getLinks().get(0).getLinks().get(2).getKeys());
		//the right children
		System.out.println("DoubleSplitPt1-RightChildLeft : " + myNode.getLinks().get(1).getLinks().get(0).getKeys()); 
		System.out.println("DoubleSplitPt1-RightChildRight : " + myNode.getLinks().get(1).getLinks().get(1).getKeys()); 

		a = myNode.getKeys().get(0);//h
		// root links
		b = myNode.getLinks().get(0).getKeys().get(0);//b
		c = myNode.getLinks().get(0).getKeys().get(1);//f
		//all links in the left
		d = myNode.getLinks().get(0).getLinks().get(0).getKeys().get(0);//a
		e = myNode.getLinks().get(0).getLinks().get(1).getKeys().get(0);//c
		f = myNode.getLinks().get(0).getLinks().get(1).getKeys().get(1);//d
		g = myNode.getLinks().get(0).getLinks().get(2).getKeys().get(0);//g
		h = myNode.getLinks().get(1).getKeys().get(0);//l
		i = myNode.getLinks().get(1).getLinks().get(0).getKeys().get(0);//j 
		j = myNode.getLinks().get(1).getLinks().get(1).getKeys().get(0);//q

		boolean result = a.equals("hello") && b.equals("by") 
			&& c.equals("finding") && d.equals("and") && e.equals("cards") 
			&& f.equals("during") && g.equals("grapes") && h.equals("lovely")
			&& i.equals("juniper") && j.equals("queen"); 

		if(result)
		{
			System.out.println(" DoubleSplitPt1 passed");
		}
		else
		{
			throw new RuntimeException("DoubleSplitPt1 faild");
		}
	}// end method


	public static void findMissingWords(){
		int addCount =0;
		int totalNodes =0;
		int resultRemander = 0;
		int result =0;	
		int pastResult =0;
		boolean found = true;
		String notFound ="";
		ArrayList<String>current = new ArrayList<String>();
		BTree myTree = new BTree();
	 try{	
		Scanner scan = new Scanner(new File("words.txt"));
		String word;
	     while(scan.hasNext()){
			word = scan.next();
			myTree.add(word);
			current.add(word);
			addCount++; 
			resultRemander = addCount%7; 
			result = addCount/7;
		if(resultRemander ==0 && result > pastResult){
			pastResult = result; 

			//for each string in current
			for(String array: current){
				if(myTree.contains(array)){
				 found = true; 	 
				}
				else{
					notFound = array;
					found = false; 
					break;//escape for
				}
				
			}//end for
		}
		if(!found){
			totalNodes = result +1;
		       System.out.println("words: "+ current);
		  System.out.println("numbWords: "+current.size());
		  System.out.println("not found: "+ notFound);
	       	  System.out.println("nodeNumber: "+ totalNodes);
		  break; //escape while
   		 }
			
	      }//end while
		scan.close();


		}//end try
			catch(Exception e){
				e.printStackTrace();
			}

		}//end findMissingWords
	public static void findMissingWordsQuick(){
		boolean found = true;
        int numbWords = 0;
		String notFound ="";
        TreeNode myNode;
		ArrayList<String>current = new ArrayList<String>();
		BTree myTree = new BTree();
        List<String> root = new ArrayList<String>();

	 try{	
		Scanner scan = new Scanner(new File("words.txt"));
		String word;
	     while(scan.hasNext()){
			word = scan.next();
			myTree.add(word);
			current.add(word); 

			//for each string in current
			for(String array: current){
				if(myTree.contains(array)){
				 found = true; 	 
				}
				else{
					notFound = array;
					found = false; 
					break;//escape for
				}
				
			}//end for
		
		if(!found){

		myNode = myTree.getRoot();
        
              numbWords = current.size();
		       System.out.println("words: "+ current);
		  System.out.println("numbWords: "+current.size());
		  System.out.println("not found: "+ notFound);

            //attempt at autoPrinting
            autoPrint(myNode,numbWords);
		  break; //escape while
   		 }
			
	      }//end while
		scan.close();
		}//end try
			catch(Exception e){
				e.printStackTrace();
			}
		}//end findMissingWordsQuick

       public static void autoPrint(TreeNode myNode,int maxWords){
           int countLink =0;
           ArrayList<TreeNode> Anode = new ArrayList<TreeNode>();
           ArrayList<TreeNode> allLinks = new ArrayList<TreeNode>();
           ArrayList<TreeNode> nodeLinks = new ArrayList<TreeNode>();
           int wordCount =0;
           int numbNodes =0;
           Anode.add(myNode);
           System.out.println("root value: "+ myNode.keys);
            wordCount+=  printKeys(Anode);
            while(wordCount< maxWords){
                   //for each node in collection of node     
                for(TreeNode node: Anode)     {
                    //for each link that node posses
                    System.out.println(node.getKeys());
                    numbNodes++;
                    for(TreeNode link: node.getLinks()){
                        //get all the links
                            allLinks.add(link);
                            nodeLinks.add(link);
                     }
                        
                    System.out.println("node: " +numbNodes);
                    wordCount+= printKeys(nodeLinks);
                    nodeLinks.clear();

                }
                numbNodes++;
               // wordCount+= printKeys(allLinks);
                Anode.clear();
                Anode.addAll(allLinks);
                allLinks.clear();
            }
       }

       public static int printKeys(ArrayList<TreeNode> myList){
           int numElements =0;
           int numbKeys =0;
           ArrayList<String> keys = new ArrayList<String>();
           while(myList.size() > numElements){
            for(TreeNode node: myList){
                numElements++;
                for(String key: node.getKeys()){
                    numbKeys++;
                    keys.add(key);
                 }
                System.out.println("links: "+keys);

                keys.clear();


            }//end for 

            //for(String key: myList.get(numElements).getKeys()){
            //    System.out.println(key);
            //    numbKeys++;
           // }//end for 
           }// end while

           return numbKeys;
       }

   public static void testRemoveFromRootBrain(){
       BTree myTree = new BTree();
       
       //makeing my Tree by Hand
       TreeNode myRoot = new TreeNode();
       TreeNode madeLeft = new TreeNode(); 
       TreeNode madeMid = new TreeNode(); 
       TreeNode madeRight = new TreeNode();

       //give root two values 
       myRoot.keys.add("c");
       myRoot.keys.add("f");

       //fill left 
       madeLeft.keys.add("a");
       madeLeft.keys.add("b");

       //fill mid
       madeMid.keys.add("d");
       madeMid.keys.add("e");

       //fill right 
       madeRight.keys.add("g");
       madeRight.keys.add("h");

       //hook links up to myRoot
       myRoot.links.add(madeLeft);
       myRoot.links.add(madeMid);
       myRoot.links.add(madeRight);
       
       //print out the tree
       System.out.println("Root keys: "+ myRoot.keys);
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);
       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //set the new root for my BTree
       myTree.setRoot(myRoot);

       //call remove on root value
       myTree.remove("c");

       //print out the tree
       System.out.println("Root keys: "+ myRoot.keys);
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);
       System.out.println("right keys: "+ myRoot.links.get(2).keys);


   }// end testRootRemoveBrain

    public static void testRemoveFromRootBrainWithLeafRepairs(){
       BTree myTree = new BTree();
       
       //makeing my Tree by Hand
       TreeNode myRoot = new TreeNode();
       TreeNode madeLeft = new TreeNode(); 
       TreeNode madeMid = new TreeNode(); 
       TreeNode madeRight = new TreeNode();

       //give root two values 
       myRoot.keys.add("c");
       myRoot.keys.add("f");

       //fill left 
       madeLeft.keys.add("a");
       madeLeft.keys.add("b");

       //fill mid
       madeMid.keys.add("d");
       madeMid.keys.add("e");

       //fill right 
       madeRight.keys.add("g");
       madeRight.keys.add("h");

       //hook links up to myRoot
       myRoot.links.add(madeLeft);
       myRoot.links.add(madeMid);
       myRoot.links.add(madeRight);
       
       //print out the tree
       System.out.println("Root keys: "+ myRoot.keys);
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);
       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //set the new root for my BTree
       myTree.setRoot(myRoot);

       //call remove on root value
       myTree.remove("c");

       //print out the tree
       System.out.println("Root keys: "+ myRoot.keys);
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);
       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       myTree.remove("b");

       //print out the tree
       System.out.println("Root keys: "+ myRoot.keys);
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);
       System.out.println("right keys: "+ myRoot.links.get(2).keys);



   }// end testRootRemoveBrain

public static void testRemoveFromRootBrainWithInternalRepairs(){
       BTree myTree = new BTree();
       
       //makeing my Tree by Hand
       //the root of my tree
       TreeNode myRoot = new TreeNode();

       //left of root
       TreeNode madeLeft = new TreeNode();

       //lefts children
       TreeNode madeLeftLeft = new TreeNode();
       TreeNode madeLeftMid = new TreeNode();
       TreeNode madeLeftRight = new TreeNode();
        
       //roots mid
       TreeNode madeMid = new TreeNode(); 

       //mids children 
       TreeNode madeMidLeft = new TreeNode(); 
       TreeNode madeMidMid = new TreeNode(); 
       TreeNode madeMidRight = new TreeNode(); 

       //roots Right
       TreeNode madeRight = new TreeNode();

       //rightsChildren
       TreeNode madeRightLeft = new TreeNode();
       TreeNode madeRightMid = new TreeNode();
       TreeNode madeRightRight = new TreeNode();

       //give root two values 
       myRoot.keys.add("9");
       myRoot.keys.add("18");

       //fill left 
       madeLeft.keys.add("3");
       madeLeft.keys.add("6");

       //fill lefts left
       madeLeftLeft.keys.add("1");
       madeLeftLeft.keys.add("2");

       //fill lefts Mid 
       madeLeftMid.keys.add("4");
       madeLeftMid.keys.add("5"); 

       //fill lefts Right
       madeLeftRight.keys.add("7");
       madeLeftRight.keys.add("8");

       //fill mid
       madeMid.keys.add("12");
       madeMid.keys.add("15");

       //fill mids left 
       madeMidLeft.keys.add("10");
       madeMidLeft.keys.add("11"); 

       //fill mids Mid
       madeMidMid.keys.add("13");
       madeMidMid.keys.add("14");

       //fill mids Right
       madeMidRight.keys.add("16");
       madeMidRight.keys.add("17");

       //fill right 
       madeRight.keys.add("21");
       madeRight.keys.add("24");

       //fill rights left
       madeRightLeft.keys.add("19");
       madeRightLeft.keys.add("20");

       //fill rights mid 
       madeRightMid.keys.add("22");
       madeRightMid.keys.add("23");

       //fill right right
       madeRightRight.keys.add("25");
       madeRightRight.keys.add("26");

       //hook children upto links 
       //hook up the lefts links
       madeLeft.links.add(madeLeftLeft);
       madeLeft.links.add(madeLeftMid);
       madeLeft.links.add(madeLeftRight);

       //hook children upto links 
       //hook up the mid links
       madeMid.links.add(madeMidLeft);
       madeMid.links.add(madeMidMid);
       madeMid.links.add(madeMidRight);

       //hoot children uptp links 
       //hook up rights mid links
       madeRight.links.add(madeRightLeft);
       madeRight.links.add(madeRightMid);
       madeRight.links.add(madeRightRight);

       //hook links up to myRoot
       myRoot.links.add(madeLeft);
       myRoot.links.add(madeMid);
       myRoot.links.add(madeRight);
       
       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid
       System.out.println("left keys mid: "
               + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right
       System.out.println("left keys right: "
               + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right
       System.out.println("mid keys right: "
               + myRoot.links.get(1).links.get(2).keys);


       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left
       System.out.println("right keys left: "
               + myRoot.links.get(2).links.get(0).keys);
        
       //print out right keys mid
       System.out.println("right keys mid: "
               + myRoot.links.get(2).links.get(1).keys);

       //print out right keys right
       System.out.println("right keys right: "
               + myRoot.links.get(2).links.get(2).keys);


       //set the new root for my BTree
       myTree.setRoot(myRoot);

        myTree.remove("9");   

        System.out.println("**** 9 removed****"+"\n");


       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid
       System.out.println("left keys mid: "
               + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right
       System.out.println("left keys right: "
               + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right
       System.out.println("mid keys right: "
               + myRoot.links.get(1).links.get(2).keys);


       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left
       System.out.println("right keys left: "
               + myRoot.links.get(2).links.get(0).keys);
        
       //print out right keys mid
       System.out.println("right keys mid: "
               + myRoot.links.get(2).links.get(1).keys);

       //print out right keys right
       System.out.println("right keys right: "
               + myRoot.links.get(2).links.get(2).keys);

        myTree.remove("8");   

        System.out.println("**** 8 removed****"+"\n");


       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid
       System.out.println("left keys mid: "
               + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right
       System.out.println("left keys right: "
               + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right
       System.out.println("mid keys right: "
               + myRoot.links.get(1).links.get(2).keys);


       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left
       System.out.println("right keys left: "
               + myRoot.links.get(2).links.get(0).keys);
        
       //print out right keys mid
       System.out.println("right keys mid: "
               + myRoot.links.get(2).links.get(1).keys);

       //print out right keys right
       System.out.println("right keys right: "
               + myRoot.links.get(2).links.get(2).keys);



        myTree.remove("7");   

        System.out.println("**** 7 removed****"+"\n");


       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid
       System.out.println("left keys mid: "
               + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right //does not exisit any more
       //System.out.println("left keys right: "
       //        + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right
       System.out.println("mid keys right: "
               + myRoot.links.get(1).links.get(2).keys);


       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left
       System.out.println("right keys left: "
               + myRoot.links.get(2).links.get(0).keys);
        
       //print out right keys mid
       System.out.println("right keys mid: "
               + myRoot.links.get(2).links.get(1).keys);

       //print out right keys right
       System.out.println("right keys right: "
               + myRoot.links.get(2).links.get(2).keys);


        myTree.remove("6");   

        System.out.println("**** 6 removed****"+"\n");


       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid
       System.out.println("left keys mid: "
               + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right //does not exisit any more
       //System.out.println("left keys right: "
       //        + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right
       System.out.println("mid keys right: "
               + myRoot.links.get(1).links.get(2).keys);


       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left
       System.out.println("right keys left: "
               + myRoot.links.get(2).links.get(0).keys);
        
       //print out right keys mid
       System.out.println("right keys mid: "
               + myRoot.links.get(2).links.get(1).keys);

       //print out right keys right
       System.out.println("right keys right: "
               + myRoot.links.get(2).links.get(2).keys);


        myTree.remove("5");   

        System.out.println("**** 5 removed****"+"\n");


       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid
       System.out.println("left keys mid: "
               + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right //does not exisit any more
       //System.out.println("left keys right: "
       //        + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right
       System.out.println("mid keys right: "
               + myRoot.links.get(1).links.get(2).keys);


       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left
       System.out.println("right keys left: "
               + myRoot.links.get(2).links.get(0).keys);
        
       //print out right keys mid
       System.out.println("right keys mid: "
               + myRoot.links.get(2).links.get(1).keys);

       //print out right keys right
       System.out.println("right keys right: "
               + myRoot.links.get(2).links.get(2).keys);


        myTree.remove("4");   

        System.out.println("********1st internal Remove*******");
        System.out.println("**** 4 removed****"+"\n");


       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid // does not exsist anymore
       //System.out.println("left keys mid: "
       //        + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right //does not exisit any more
       //System.out.println("left keys right: "
       //        + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right //does not exisist any more
       //not in that postion
       //System.out.println("mid keys right: "
       //        + myRoot.links.get(1).links.get(2).keys);


       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left
       System.out.println("right keys left: "
               + myRoot.links.get(2).links.get(0).keys);
        
       //print out right keys mid
       System.out.println("right keys mid: "
               + myRoot.links.get(2).links.get(1).keys);

       //print out right keys right
       System.out.println("right keys right: "
               + myRoot.links.get(2).links.get(2).keys);



            myTree.remove("12");   

        System.out.println("**** 12 removed****"+"\n");


       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid // does not exsist anymore
       //System.out.println("left keys mid: "
       //        + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right //does not exisit any more
       //System.out.println("left keys right: "
       //        + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right //does not exisist any more
       //not in that postion
       //System.out.println("mid keys right: "
       //        + myRoot.links.get(1).links.get(2).keys);


       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left
       System.out.println("right keys left: "
               + myRoot.links.get(2).links.get(0).keys);
        
       //print out right keys mid
       System.out.println("right keys mid: "
               + myRoot.links.get(2).links.get(1).keys);

       //print out right keys right
       System.out.println("right keys right: "
               + myRoot.links.get(2).links.get(2).keys);


         myTree.remove("11");   

        System.out.println("**** 11 removed****"+"\n");


       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid // does not exsist anymore
       //System.out.println("left keys mid: "
       //        + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right //does not exisit any more
       //System.out.println("left keys right: "
       //        + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right //does not exisist any more
       //not in that postion
       //System.out.println("mid keys right: "
       //        + myRoot.links.get(1).links.get(2).keys);


       System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left
       System.out.println("right keys left: "
               + myRoot.links.get(2).links.get(0).keys);
        
       //print out right keys mid
       System.out.println("right keys mid: "
               + myRoot.links.get(2).links.get(1).keys);

       //print out right keys right
       System.out.println("right keys right: "
               + myRoot.links.get(2).links.get(2).keys);






        myTree.remove("10");   

        System.out.println("internal merge test!!***");
        System.out.println("**** 10 removed****"+"\n");


       //print out the tree
       //print out the root
       System.out.println("Root keys: "+ myRoot.keys);

       //print root left
       System.out.println("left keys: "+ myRoot.links.get(0).keys);
       
       //print out lefts left
       System.out.println("left keys left: "
               + myRoot.links.get(0).links.get(0).keys);
        
       //print out lefts mid // does not exsist anymore
       //System.out.println("left keys mid: "
       //        + myRoot.links.get(0).links.get(1).keys);

       //print out lefts right //does not exisit any more
       //System.out.println("left keys right: "
       //        + myRoot.links.get(0).links.get(2).keys);

       //print out mid keys values
       System.out.println("mid keys: "+ myRoot.links.get(1).keys);

       //print out mid left
       System.out.println("mid keys left: "
               + myRoot.links.get(1).links.get(0).keys);
        
       //print out mid keys mid
       System.out.println("mid keys mid: "
               + myRoot.links.get(1).links.get(1).keys);

       //print out mid keys right //does not exisist any more
       //not in that postion
       //System.out.println("mid keys right: "
       //        + myRoot.links.get(1).links.get(2).keys);

        
       //not in postion any more
       //System.out.println("right keys: "+ myRoot.links.get(2).keys);

       //print out right left //not in pos any more
       //System.out.println("right keys left: "
       //        + myRoot.links.get(2).links.get(0).keys);
       // 
       ////no in pos any more
       ////print out right keys mid
       //System.out.println("right keys mid: "
       //        + myRoot.links.get(2).links.get(1).keys);

       ////print out right keys right
       //System.out.println("right keys right: "
       //        + myRoot.links.get(2).links.get(2).keys);

   }// end testRootRemoveBrain
          public static void testRemoveBrainLeaf(){
              BTree myTree = new BTree();
              TreeNode myRoot = new TreeNode(); 
              TreeNode left = new TreeNode(); 
              TreeNode right = new TreeNode(); 
              TreeNode mid = new TreeNode(); 

              //add values to root
              myRoot.keys.add("3");
              myRoot.keys.add("6");

              //add left keys
              left.keys.add("1"); 
              left.keys.add("2"); 

              //add keys to mid
              mid.keys.add("4"); 
              mid.keys.add("5"); 

              //add keys to right
              right.keys.add("7");
              right.keys.add("8");

              //add links to root
                myRoot.links.add(left);
                myRoot.links.add(mid);
                myRoot.links.add(right);

              // make my root the tree root
              myTree.setRoot(myRoot);

             //remove 8 
             myTree.remove("8");
            
             //print out the nodes
             System.out.println("root: "+myRoot.keys);
             System.out.println("left: "+myRoot.links.get(0).keys);
             System.out.println("mid: "+myRoot.links.get(1).keys);
             System.out.println("right: "+myRoot.links.get(2).keys);
            
            //remove 7
             myTree.remove("7");
            
             //print out the nodes
             System.out.println("root: "+myRoot.keys);
             System.out.println("left: "+myRoot.links.get(0).keys);
             System.out.println("mid: "+myRoot.links.get(1).keys);
             System.out.println("right: "+myRoot.links.get(2).keys);
          }//end remove brain leaf


        public static void RemoveAllWordsTest(){
            int allWords = 0; 
		    ArrayList<String> load = new ArrayList<String>(); 

		    BTree myTree = new BTree();

		    //1st load of the file 
		    //allWords = LoadBtree(myTree,load); 

            //print out all the words
            System.out.println("all words: "+allWords);

            //add might not be adding properly
            autoPrint(myTree.getRoot(),40);

            //something wrong with the split in add
            //diving deeper 
            //links being copyed in other nodes 
            //need to stop copys

            //for each word in load array
            for(String value:load){
                System.out.println("here i am again");
                    myTree.remove(value);//failes to remove 
                    load.remove(load.indexOf(value));
                    System.out.println("words left: "+load.size());
            }//end for
                            
            if(load.isEmpty()){
                System.out.println(" all words removed passed"); 
             }
            else{
                System.out.println(" all words removed failed"); 
            }// end else
        }//end remove all words test
	}// end class
