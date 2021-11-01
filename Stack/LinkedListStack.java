package Stack;

import LinkedList.SinglyLinkedList;

public class LinkedListStack {
  private SinglyLinkedList stack;

  public LinkedListStack(SinglyLinkedList stack) {
    this.stack = stack;
  }

  public boolean isEmpty() {
    if(stack.head == null) {
      return true;
    }

    return false;
  }

  public void push(int data) {
    stack.push(data);

    System.out.println("Data { " + data + " }  successfully inserted to the stack");
  }

  public int pop() {
    if(isEmpty()) {
      System.out.println("Error occurred while popping, stack is empty");
      return -1;
    }

    int data = stack.head.data;
    stack.deleteNodeAt(0);

    return data;
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
      return -1;
    }

    return stack.head.data;
  }

  public void deleteStack() {
    stack.deleteList();

    System.out.println("Stack is deleted.");
  }

}
