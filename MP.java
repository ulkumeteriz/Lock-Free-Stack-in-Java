import java.io.IOException;

public class MP {
	
	public static void main(String[] args) throws IOException {
		
		Stack<Integer> s = new Stack<Integer>();
		
		Operator o1 = new Operator(s);
		Operator o2 = new Operator(s);
		Operator o3 = new Operator(s);
		Operator o4 = new Operator(s);
		
		// Press any key to terminate the threads life cycle.
		System.in.read();
		o1.cont = false;
		o2.cont = false;
		o3.cont = false;
		o4.cont = false;	
	}
}


