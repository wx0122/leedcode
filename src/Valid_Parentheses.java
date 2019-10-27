public class Valid_Parentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		char[] arr = s.toCharArray();
		char temp = ' ';

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
				stack.push(arr[i]);
			} else {
				if (stack.isEmpty()) {
					return false;
				} 
				
				if (arr[i] == ')' ) {
					temp = stack.pop();
					if (temp != '(') {
						return false;
					}
				}

				if (arr[i] == ']') {
					temp = stack.pop();
					if (temp != '[') {
						return false;
					}
				}

				if (arr[i] == '}') {
					temp = stack.pop();
					if (temp != '{') {
						return false;
					}
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		}

		return false;
	}
}