package com.example.study.stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {
    static void showpush(Stack<Integer> st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String args[]) {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack-start: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);
        Integer peek = st.peek();
        System.out.println("peek:"+peek);
        boolean empty = st.empty();
        System.out.println("empty:"+empty);
        int search = st.search(new Integer(42));
        int search1 = st.search(new Integer(66));
/*        showpop(st);
        showpop(st);*/
        System.out.println("search: " + search);
        System.out.println("1: " + search1);
        System.out.println("stack-end: " + st);

        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}
