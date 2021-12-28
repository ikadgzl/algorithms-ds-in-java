package Stack.StackQuestions;

public class StackQuestions {
  // Three in One, implement single array for three separate stacks

  private final int NUMBER_OF_STACKS = 3;
  private int stackCapacity;
  public int[] valuesInStack;
  private int[] eachStack;

  public StackQuestions(int stackSize) {
    this.stackCapacity = stackSize;
    this.valuesInStack = new int[stackSize * NUMBER_OF_STACKS];
    this.eachStack = new int[NUMBER_OF_STACKS];
  }

  public boolean isFull(int stackNumber) {
    return eachStack[stackNumber] == stackCapacity;
  }

  public boolean isEmpty(int stackNumber) {
    return eachStack[stackNumber] == 0;
  }

  private int indexOfTop(int stackNumber) {
    int offset = stackNumber * stackCapacity;
    int topOfStack = eachStack[stackNumber];

    return offset + topOfStack - 1;
  }

  public void push(int stackNumber, int value) {
    if (isFull(stackNumber)) {
      System.out.println("The stack is full");
    } else {
      eachStack[stackNumber]++;
      valuesInStack[indexOfTop(stackNumber)] = value;
    }
  }

  public int pop(int stackNumber) {
    if (isEmpty(stackNumber)) {
      System.out.println("Stack is already empty");
      return -1;
    } else {
      int index = indexOfTop(stackNumber);
      int value = valuesInStack[index];

      valuesInStack[index] = 0;
      eachStack[stackNumber]--;

      return value;
    }
  }

  public int peek(int stackNumber) {
    if (isEmpty(stackNumber)) {
      System.out.println("Stack is already empty");
      return -1;
    } else {
      return valuesInStack[indexOfTop(stackNumber)];
    }
  }
}
