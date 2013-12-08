package tree;
//Import Statements
//Local Imports
//External Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeFiller {
	ArrayList<String> words_read;
	BTree tree;
	String fileName;
	File file;
	int repeats, added;
	
	public TreeFiller() {
		tree = null;
		fileName = null;
	}
	
	public TreeFiller(BTree tree, String fileName) {
		this.tree = tree;
		this.fileName = fileName;
	}
	
	public BTree getTree() {
		return tree;
	}
	
	public void setTree(BTree tree) {
		this.tree = tree;
	}
	
	public void setFile(String fileName) {
		this.fileName = fileName;
	}
	
	public int getRepeatCount() {
		return repeats;
	}
	
	public ArrayList<String> getWordsRead() {
		return words_read;
	}
	
	public void newTree() {
		tree = new BTree();
	}
	
	public int fillTree() {
		if(tree == null) {
			tree = new BTree();
		}
		file = new File(fileName);
		added = 0;
		repeats = 0;
		words_read = new ArrayList<String>();
		try {

			Scanner sc = new Scanner(file);
			String word = null;
			while(sc.hasNext()) {
				word = sc.next();
				words_read.add(word);
				if(tree.contains(word)) {
					repeats += 1;
				} else {
					tree.add(word);
					added += 1;
				}
			}
			
			System.out.println("Added: " + added + " Repeats: " + repeats);
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error. Word File Not Found.");
		}
		return added;
	}
	
	public int fillTree(int size) {
		if(tree == null) {
			tree = new BTree();
		}
		file = new File(fileName);
		int loop_count = 0;
		repeats = 0;
		added = 0;
		words_read = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(file);
			String word = null;
			while(sc.hasNext() && loop_count < size) {
				word = sc.next();
				words_read.add(word);
				if(tree.contains(word)) {
					repeats += 1;
				} else {
					tree.add(word);
					added += 1;
				}
				loop_count += 1;
			}
			
			System.out.println("Added: " + added + " Repeats: " + repeats);
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error. Word File Not Found.");
		}
		return added;
	}
	

}