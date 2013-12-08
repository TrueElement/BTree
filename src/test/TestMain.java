package test;

public class TestMain {
	public boolean node_tests = false;
	public boolean tree_tests = true;

	public TestMain() {
		
	}
	
	public static void main(String[] args) {
		TestMain tst = new TestMain();
			tst.runTests();
	}
	
	public void runTests() {
		if(node_tests) {
			System.out.println("------------Start Node Tests------------");
			NodeTest node = new NodeTest();
				node.run();
			System.out.println("------------End   Node Tests------------");
		}
		
		if(tree_tests) {
			System.out.println("------------Start Tree Tests------------");
			TreeTests tree = new TreeTests();
				tree.add_tests = false;
				tree.remove_tests = true;
				tree.runTreeTests();
			System.out.println("------------End   Tree Tests------------");
		}
	}
	

	
	
}