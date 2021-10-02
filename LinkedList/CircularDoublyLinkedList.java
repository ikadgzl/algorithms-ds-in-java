package LinkedList;

public class CircularDoublyLinkedList {
  public Node head;
  public Node tail;


  public void push(int data) {
    Node newNode = new Node(data);

    if(head == null) {
      head = newNode;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
    }

    tail = newNode;
    tail.next = head;
    head.prev = tail;
  }

  public void insertAfter(Node prevNode, int data) {
    if (prevNode == null) {
      System.out.println("Invalid node.");
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
    tail.next = newNode;

    newNode.next = head;
    newNode.prev = tail;

    head = newNode;
  }

  public void deleteNode(int key) {
    Node temp = head;

    if (head != null && head.data == key) {
      Node nextNode = head.next;

      nextNode.prev = tail;
      tail.next = nextNode;

      head.next = null;
      head.prev = null;

      head = nextNode;

      return;
    }

    if (tail != null && tail.data == key) {
      Node prevNode = tail.prev;

      prevNode.next = head;
      head.prev = prevNode;

      tail.next = null;
      tail.prev = null;

      tail = prevNode;

      return;
    }

    while (temp != null && temp.data != key) {
      if (temp.next == head) {
        System.out.println("Node with the provided data not found.");
        return;
      }

      temp = temp.next;
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
      System.out.println("Invalid position.");
      return;
    }

    if (position == 0) {
      Node nextNode = head.next;

      nextNode.prev = tail;
      tail.next = nextNode;

      head.next = null;
      head.prev = null;

      head = nextNode;

      return;
    }

    if (position == listLength - 1) {
      Node prevNode = tail.prev;

      prevNode.next = head;
      head.prev = prevNode;

      tail.next = null;
      tail.prev = null;

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

  public void deleteList() {
    head = null;
    tail = null;
  }

  public int getCount() {
    Node temp = head.next;

    int count = 1;
    do {
      count++;

      temp = temp.next;
    } while (temp != head);

    return count;
  }

  public boolean search(int key) {
    Node current = head;

    while (current.data != key) {
      if (current.next == head) {
        return false;
      }

      current = current.next;
    }

    return true;
  }

  public int getNthNode(int n) {
    Node current = head;

    int count = 0;
    while (current.next != head) {
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

    if (n > linkedListLength || n < 1) return -1;

    Node temp = head;

    for (int i = 0; i < linkedListLength - n; i++) {
      temp = temp.next;
    }

    return temp.data;
  }

  public void sortCircularLinkedList() {
    Node current = head;
    Node nextNode;

    int temp;
    while (current.next != head) {
      nextNode = current.next;
      while (nextNode.next != head) {
        if (current.data > nextNode.data) {
          temp = current.data;
          current.data = nextNode.data;
          nextNode.data = temp;
        }

        nextNode = nextNode.next;
      }

      current = current.next;
    }
  }

  public void traverse() {
    Node current = head;

    if (current == null) {
      return;
    }

    do {
      System.out.print(current.data + " --> ");
      current = current.next;
    } while (current != head);
    System.out.print(current.data + "\n");

    current = tail;
    do {
      System.out.print(current.data + " --> ");
      current = current.prev;
    } while (current != tail);
    System.out.print(current.data);
  }
}
