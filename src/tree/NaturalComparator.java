package tree;
//Import Statements
//Local Imports
//External Imports
import java.util.Comparator;

public class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {

	public int compare(T a, T b) {
		return a.compareTo(b);
	}
}
