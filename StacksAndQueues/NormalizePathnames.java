public class NormalizePathnames{
	public static String shortestEquivalentPath(String path){
		if(path.equals("")){
			//throw exception or return path depending on whether "" is a valid path or not
		}

		Deque<String> pathNames = new ArrayDeque<>();
		if(path.startWith("/")){
			// absolute path
			pathNames.addFirst("/");
		}

		//iterate through each token
		for(String token : path.split("/")){
			if(token.equals("..")){
				//is pathNames is empty, that means we need to record .. because we can't 
				//go one level up, because we don't know what's one level up. this
				//case will only happen if we are not reading an absolute path
				//absolute path will have / in pathNames 
				//we will also record if pathNames.has .. because it means
				//we are recording ..
				//we will only encounter .. if we are doing a relative path
				if(pathNames.isEmpty() || pathNames.peekFirst().equals("..")){
					pathNames.addFirst(token); //put it at top
				}else {
					if(pathNames.peekFirst().equals("/"))//we have reached the root since / can only be added if its root, otherwise it gets filtered out by split method
					{
						//throw exception
					}
					pathNames.removeFirst();//remove the top element since .. means we are going one level back
				}
			} else if (!token.equals(".") || !token.isEmpty()){
				pathNames.addFirst(token);
			}

			//the following code is redundant
			if(token.equals(".")){
				continue; //if current directory then skip it
			}
		}

		StringBuilder result = new StringBuilder();
		if(!pathNames.isEmpty()){
			Iterator<String> it = pathNames.descendingIterator();
			//we need to descending iterator, since it returns element from last to first
			//this is because the last element in the stack is actually the
			//start of the address
			String prev = it.next(); //We store the first element (i.e. tail)
			result.append(prev)
			while(it.hasNext()){
				//First we need to make sure whether the previous
				//element is / or not, because if it is / then next element cannot be /
				//otherwise the previous element must have been a letter
				//so we can use / 
				if(!prev.equals("/")){
					result.append("/");
				}
				prev = it.next();
				result.append(prev);
			}

		}
		return result.toString();
	}
}