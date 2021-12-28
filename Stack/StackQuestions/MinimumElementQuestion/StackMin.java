package Stack.StackQuestions.MinimumElementQuestion;

public class StackMin {
  Node top;
  Node min;

  public StackMin() {
    this.top = null;
    this.min = null;
  }

  public int min() {
    return min.value;
  }

  public void push(int value) {
    if (min == null || value < min.value) {
      min = new Node(value, min);
    }

    top = new Node(value, top);
  }

  public int pop() {
    int poppedValue = top.value;

    if (top.value == min.value) {
      min = min.next;
    }
    top = top.next;

    return poppedValue;
  }
}
