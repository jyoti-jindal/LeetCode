package string;

import java.util.Stack;

public class RemoveAllAdjDuplicates1047 {
    public static void main(String[] args) {
        RemoveAllAdjDuplicates1047 removeAllAdjDuplicates = new RemoveAllAdjDuplicates1047();
        System.out.println(removeAllAdjDuplicates.removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<Character>();
        char ch[] = s.toCharArray();
        for(char c : ch) {
            if(!st.isEmpty() && (st.peek() == c)) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        int n = st.size();
        ch = new char[n];
        for(int i=0; i<n; i++) {
            ch[n-1-i] = st.pop();
        }
        return String. valueOf(ch);
        //return s;
    }
}
