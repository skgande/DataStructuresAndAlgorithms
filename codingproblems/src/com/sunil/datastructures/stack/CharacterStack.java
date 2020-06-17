package com.sunil.datastructures.stack;

/**
 * Stack data structure of type character.
 * <p>
 * push(): Can contains character.
 * pop(): Top of stack.
 * isEmpty(): stack is empty or not.
 */
public class CharacterStack {
    char[] ch = new char[100];
    int top;

    public CharacterStack() {
        top = -1;
    }

    public void push(char c) {
        if (top == 100) {
            System.out.println("Stack is overflow");
            return;
        }
        ch[++top] = c;
    }

    public char pop() {
        if(top == -1) {
            System.out.println("Stack is underflow");
            return '\0';
        }
        return ch[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
