package Stack;

public class ArrayStack {
  private int[] stack;
  private int topOfStack;

  public ArrayStack(int stackSize) {
    stack = new int[stackSize];
    topOfStack = -1;
    System.out.println("Stack is created with the size of " + stackSize);
  }

  public boolean isEmpty() {
    if (topOfStack == -1) {
      return true;
    }

    return false;
  }

  public boolean isFull() {
    if (stack.length - 1 == topOfStack) {
      return true;
    }

    return false;
  }

  public void push(int data) {
    if (isFull()) {
      System.out.println("Error occurred while pushing, stack is full");
      return;
    }

    stack[++topOfStack] = data;
    System.out.println("Data has inserted to the stack successfully");
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("Error occurred while popping, stack is empty");
      return -1;
    }

    int data = stack[topOfStack--];
    System.out.println("Data has popped successfully, the data is: " + data);

    return data;
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
      return -1;
    }

    return stack[topOfStack];
  }

  public void deleteStack() {
    stack = null;

    System.out.println("Stack is deleted.");
  }
}
