package test;

public class TreeTests {
	//Boolean Flags
	public boolean add_tests = false;
	public boolean remove_tests = true;
	//Sub Flags
	public boolean remove_all = true;
	
	public TreeTests() {
		
	}
	
	public void runTreeTests() {
		if(add_tests) {
			System.out.println("------------Start Add Tests------------");
			AddTests add = new AddTests();
				add.root_split = true;
				add.run();
			System.out.println("------------ End Add Tests ------------");
		}
		
		if(remove_tests) {
			System.out.println("-----------Start Remove Tests-----------");
			RemoveTests remove = new RemoveTests();
				remove.remove_all = remove_all;
				remove.run();
			System.out.println("----------- End Remove Tests -----------");
		}
	}
}