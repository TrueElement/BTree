package test;

public class TreeTests {
	//Boolean Flags
	public boolean add_tests = false;
	public boolean remove_tests = true;
	//Sub Flags
	public boolean remove_all_order = true;
	public boolean remove_hundred_order = false;
	
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
				remove.remove_all_order = remove_all_order;
				remove.remove_hundred_order = remove_hundred_order;
				remove.run();
			System.out.println("----------- End Remove Tests -----------");
		}
	}
}