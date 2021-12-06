package Queue;


import LinkedList.SinglyLinkedList;

public class LinkedListQueue {
    public SinglyLinkedList queue;

  public LinkedListQueue() {
    this.queue = new SinglyLinkedList();
  }

  public boolean isEmpty() {
    return queue.head == null;
  }

  public void enQueue(int data){
    queue.append(data);

    System.out.println("The data { " + data + " } has enqueued successfully.");
  }

  public int deQeueu() {
    if(isEmpty()) {
      System.out.println("Queue is empty");

      return -1;
    }

    int value = queue.head.data;
    queue.deleteNodeAt(0);

    return value;
  }

  public int peek() {
    if(isEmpty()) {
      System.out.println("Queue is empty");

      return -1;
    }

    return queue.head.data;
  }

  public void deleteQueue() {
    queue.head = null;
  }
}
