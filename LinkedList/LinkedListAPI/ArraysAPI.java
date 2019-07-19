import java.util.Arrays;
import java.util.List;
class Node{
	int data;
	public Node(int data){
		this.data = data;
	}
}
public class ArraysAPI{
	public static void main(String[] args){
		//Arrays class only contain static methods.
		List array = Arrays.asList(1,2,3);
		List nodes = Arrays.asList(new Node(1), new Node(2), new Node(3));
		List nodes2 = Arrays.asList(new int[]{1,2,3},1);
		Arrays.public static <T,U> T[] copyOf(U[] original,
               int newLength,
               Class<? extends T[]> newType)

	}
}

//Two array references are considered deeply equal if both are null, 
//or if they refer to arrays that contain the same number of elements 
//and all corresponding pairs of elements in the two arrays are deeply equal. 


/**
* List of methods in Arrays
1. asList
2. binarySearch
3. copyOf
4. copyOfRange
5. deepEquals
6. deepHashCode
7. deepToString - toString of the "deep contents" of the array
8. equals
9. fill
10. hashCode
11. sort
12. toString
**/

/**
* More questions:
1. deepEquals vs equals
**/