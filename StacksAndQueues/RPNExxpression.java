public class RPNExpression{

	public static int eval(String rpn){
		Deque<Integer> intermediateResults = new ArrayDeque<>();

		String delimiter = ","; // if delimiter is not , then it becomes problematic when we want to differentiate 2-42+ from 2,-42,+
		String[] symbols = rpn.split(delimiter);

		for(String symbol : symbols){
			//if symbol is mathematical symbol
			//it should be 1 in length and it should be part of +-*/ string
			if(symbol.length()==1 && "+-*/".contains(token)){
				//pop the top two numbers
				int y = intermediateResults.removeFirst();
				int x = intermediateResults.removeFirst();
				//now we can evaluate "x +-*/ y"

				switch(symbol.charAt(0)){
					case '+':
						intermediateResults.addFirst(x+y);
						break;
					case '-':
						intermediateResults.addFirst(x-y);
						break;
					case '*':
						intermediateResults.addFirst(x*y);
						break;
					case '/':
						intermediateResults.addFirst(x/y);
						break;
					default :
						//throw exception
				}
			} else {
				intermediateResults.addFirst(Integer.parseInt(symbol)); //when token is number
				//we push it into the stack.
			}
		}
		return intermediateResults.removeFirst(); // now that the expression is
		//evaluated, we can return the leftover (evaluated expression)
	} 
}