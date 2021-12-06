package Queue;

import java.awt.*;

// for memory efficiency
public class CircularQueue {
  public int[] queue;
  int topOfQ;
  int beginningOfQ;
  int size;

  public CircularQueue(int size) {
    this.queue = new int[size];
    this.size = size;
    this.topOfQ = -1;
    this.beginningOfQ = -1;
  }

  public boolean isFull() {
    return (topOfQ + 1 == beginningOfQ) || (beginningOfQ == 0 && topOfQ + 1 == size);
  }

  public boolean isEmpty() {
    return topOfQ == -1;
  }

  public void insert(int data) {
    queue[topOfQ] = data;
    System.out.println("The data { " + data + " } has enqueued successfully.");
  }

  public void enQueue(int data) {
    if (isFull()) {
      System.out.println("Queue is full");
    } else if (isEmpty()) {
      beginningOfQ = 0;
      topOfQ++;

      insert(data);
    } else {
      if (topOfQ + 1 == size) {
        topOfQ = 0;
      } else {
        topOfQ++;
      }

      insert(data);
    }
  }

  public int deQueue() {
    if (isEmpty()) {
      System.out.println("Queue is empty");

      return -1;
    }

    int extracted = queue[beginningOfQ];
    queue[beginningOfQ] = 0;

    if (beginningOfQ == topOfQ) {
      beginningOfQ = -1;
      topOfQ = -1;
    } else if (beginningOfQ + 1 == size) {
      beginningOfQ = 0;
    } else {
      beginningOfQ++;
    }

    return extracted;
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
