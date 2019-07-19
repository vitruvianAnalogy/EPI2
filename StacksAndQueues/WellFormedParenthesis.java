public class WellFormedParenthesis{
	public static boolean isWellFormed(String s){
		Deque<Character> leftChars = new ArrayDeque<>();

		for(int i = 0; i<s.length(); ++i){
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
				leftChars.addFirst(s.charAt(i));
			} else {
				if(leftChars.isEmpty()){
					return false; // no left for "ELSE" condition
					//else condition means right ) } or ]
				}
				if(s.charAt(i) ==')' && s.peekFirst() != '(') 
					|| ( s.charAt(i) == '}' && s.peekFirst() != '{')
					|| ( s.charAt(i) == ']' && s.peekFirst() != '['){
						return false; //mismatched opening and closing
				}
				leftChars.removeFirst(); //once matching has happened, remove the left
			}
		}

		return leftChars.isEmpty(); // if true that means everything matched
		//else something is remaining in leftChars, hence not well-formed
	}
}