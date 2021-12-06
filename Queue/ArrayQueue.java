package Queue;

public class ArrayQueue {
  public int[] queue;
  int topOfQ;
  int beginningOfQ;

  public ArrayQueue(int size) {
    this.queue = new int[size];
    this.topOfQ = -1;
    this.beginningOfQ = -1;
  }

  public boolean isFull() {
    return topOfQ == queue.length - 1;
  }

  public boolean isEmpty() {
    return beginningOfQ == -1 || beginningOfQ == queue.length;
  }

  // util func for enqueue not to duplicate code.
  public void insert(int data) {
    topOfQ++;
    queue[topOfQ] = data;

    System.out.println("The data { " + data + " } has enqueued successfully.");
  }

  public void enQueue(int data) {
    if (isFull()) {
      System.out.println("Error: Queue is full");
    } else if (isEmpty()) {
      beginningOfQ = 0;

      this.insert(data);
    } else {
      this.insert(data);
    }
  }

  public int deQueue() {
    if (isEmpty()) {
      System.out.println("Error: Queue is empty");

      return -1;
    } else {
      int extracted = queue[beginningOfQ];
      beginningOfQ++;

      if (beginningOfQ > topOfQ) {
        beginningOfQ = -1;
        topOfQ = -1;
      }

      return extracted;
    }
  }

  public int peek() {
    if (!isEmpty()) {
      return queue[beginningOfQ];
    } else {
      System.out.println("Queue is empty.");

      return -1;
    }
  }

  public void delete() {
    queue = null;

    System.out.println("Queue deleted.");
  }
}
