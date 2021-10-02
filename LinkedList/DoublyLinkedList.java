package LinkedList;

public class DoublyLinkedList {
  public Node head;
  public Node tail;

  public void traverse() {
    Node temp = head;

    System.out.print("NULL <-- ");
    while (temp != null) {
      System.out.print(temp.data + " --> ");

      temp = temp.next;
    }
    System.out.println("NULL");

    System.out.print("NULL");

    temp = tail;
    while (temp != null) {
      System.out.print(" <-- " + temp.data);

      temp = temp.prev;
    }
    System.out.print(" <-- NULL ");

  }

  public void push(int data) {
    Node newNode = new Node(data);

    newNode.next = null;

    if (head == null) {
      newNode.prev = null;
      head = newNode;
      tail = newNode;
      return;
    }

    newNode.prev = tail;
    tail.next = newNode;
    tail = newNode;
  }

  public void insertAfter(Node prevNode, int data) {
    if (prevNode == null) {
      System.out.println("Invalid node");
      return;
    }

    if (prevNode == head) {
      append(data);
      return;
    }

    if (prevNode == tail) {
      push(data);
      return;
    }

    Node newNode = new Node(data);

    newNode.prev = prevNode;
    newNode.next = prevNode.next;

    prevNode.next.prev = newNode;
    prevNode.next = newNode;
  }

  public void append(int data) {
    Node newNode = new Node(data);

    head.prev = newNode;

    newNode.prev = null;
    newNode.next = head;

    head = newNode;
  }

  public void deleteNode(int key) {
    Node temp = head;

    if (head != null && head.data == key) {
      Node nextNode = head.next;

      nextNode.prev = null;
      head.next = null;

      head = nextNode;

      return;
    }

    if (tail != null && tail.data == key) {
      Node prevNode = tail.prev;

      prevNode.next = null;
      tail.prev = null;

      tail = prevNode;

      return;
    }

    while (temp != null && temp.data != key) {
      temp = temp.next;
    }

    if (temp == null) {
      System.out.println("Node with the provided key not found in the list!");
      return;
    }

    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;

    temp.next = null;
    temp.prev = null;

  }

  public void deleteNodeAt(int position) {
    Node temp = head;

    if (head == null) {
      return;
    }

    int listLength = getCount();
    if (position > listLength - 1 || position < 0) {
      System.out.println("Invalid position");
      return;
    }

    if (position == 0) {
      temp = head.next;

      head.next = null;
      temp.prev = null;

      head = temp;

      return;
    }

    if (position == listLength - 1) {
      Node prevNode = tail.prev;

      tail.prev = null;
      prevNode.next = null;

      tail = prevNode;

      return;
    }

    for (int i = 0; i < position; i++) {
      temp = temp.next;
    }

    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;

    temp.next = null;
    temp.prev = null;
  }

  public int getCount() {
    Node temp = head;

    int count = 0;
    while (temp != null) {
      count++;

      temp = temp.next;
    }

    return count;
  }

  public void deleteList() {
    tail = null;
    head = null;
  }

  public boolean search(int key) {
    Node current = head;

    while (current != null) {
      if (current.data == key) {
        return true;
      }

      current = current.next;
    }

    return false;
  }

  public int getNthNode(int n) {
    Node current = head;

    int count = 0;
    while (current != null) {
      if (count == n) {
        return current.data;
      }

      count++;
      current = current.next;
    }

    return -1;
  }

  public int getNthFromEnd(int n) {
    int linkedListLength = this.getCount();

    if (n > linkedListLength) return -1;

    Node temp = head;

    for (int i = 0; i < linkedListLength - n; i++) {
      temp = temp.next;
    }

    return temp.data;
  }

  public void sortLinkedList() {
    Node current = head;
    Node index;

    if (head == null) return;

    int temp;
    while (current != null) {
      index = current.next;
      while (index != null) {
        if (current.data > index.data) {
          temp = current.data;
          current.data = index.data;
          index.data = temp;
        }
        index = index.next;
      }
      current = current.next;
    }
  }
}
