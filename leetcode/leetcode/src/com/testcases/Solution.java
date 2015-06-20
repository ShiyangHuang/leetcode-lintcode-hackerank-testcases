import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    private ArrayList<Character> sym = new ArrayList<Character>();
    private ArrayList<Character> leftSym = new ArrayList<Character>();
    public void addSyms(String input) {
        // "(){}[]<>/\"
        for (int i = 0; i < input.length(); i++) {
            sym.add(input.charAt(i));
            if (i % 2 == 0) {
                leftSym.add(input.charAt(i));
            }
        }
    }
    public boolean validString(String input) {
        Stack<Character> stk = new Stack<Character>();
        if (input == null) {
            return false;
        }
        if (input.length() == 0) {
            return true;
        }

        for (int i = 0; i < input.length(); i++) {
            if (leftSym.contains(input.charAt(i))) {
                stk.push(input.charAt(i));
            } else
            {
                for (int j = 0; j < sym.size(); j += 2) {
                    if (input.charAt(i) == sym.get(j + 1)) {
                        if (!stk.empty() && stk.pop() != sym.get(j)) {
                            break;
                        }
                    }
                    if (j == sym.size() - 2) {
                        return false;
                    }

                }
            }

        }
        if (stk.empty()) {
            return true;
        }
        else {
            return false;
        }
    }
    public String reverseStr(String input) {
        String[] sepInput = input.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sepInput.length; i++) {
            sb.append(reverseString(sepInput[i]));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String reverseString(String input) {
        StringBuffer sb = new StringBuffer();
        for (int i = input.length() - 1; i >= 0 ; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add(")");
        strings.add("(");
        strings.add("([])");
        strings.add("([)]");
        strings.add("[]{}(()){}");
        strings.add("");
        Solution solution = new Solution();
        solution.addSyms("()[]{}<>/\\");
        for (String string : strings) {
            System.out.println(solution.validString(string));
        }
    }
}

// "( [ { } ] ) < > / \ "

// "([])" --> TRUE
// "([)]" --> FALSE
// "()" --> TRUE
// "(]" --> FALSE
