import java.util.Random;

public class Operator extends Thread {
	
	public void random()
	{
		Random rand = new Random();
		int n = rand.nextInt(50);
		int s = rand.nextInt(500) + 500;
		
		while(cont)
		{
			if(n%2 == 0)
			{
				if(stack.Push(n))
					System.out.println(this.getName() + " : " + n + " is pushed.");
				try {
					sleep(s);
				} catch (InterruptedException e) {}
			}
			else
			{
				Integer p = stack.Pop();
				System.out.println(this.getName() + " : " + p + " is popped.");
				try {
					sleep(s);
				} catch (InterruptedException e) {}
			}
			
			n = rand.nextInt(50);
			s = rand.nextInt(1000) + 500;
		}
	}
	
	public void run()
	{
		random();
	}
	
	public Operator(Stack<Integer> s)
	{
		stack = s;
		cont = true;
		this.start();
	}
	
	public Stack<Integer> stack;
	boolean cont;
	
}

