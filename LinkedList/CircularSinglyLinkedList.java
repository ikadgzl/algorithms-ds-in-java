package LinkedList;

public class CircularSinglyLinkedList {
  public Node head;
  public Node tail;

  public void push(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }

    tail = newNode;
    tail.next = head;
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

    newNode.next = prevNode.next;
    prevNode.next = newNode;
  }

  public void append(int data) {
    Node newNode = new Node(data);

    newNode.next = head;
    head = newNode;
    tail.next = newNode;
  }

  public void deleteNode(int key) {
    Node temp = head;
    Node prev = null;

    if (temp != null && temp.data == key) {
      head = temp.next;
      tail.next = head;

      return;
    }

    while (temp.data != key) {
      if (temp.next == head) {
        System.out.println("Node with the provided data not found.");
        return;
      }

      prev = temp;
      temp = temp.next;
    }

    prev.next = temp.next;
    temp.next = null;

  }

  public void deleteNodeAt(int position) {
    Node temp = head;
    Node prev = null;

    if (head == null) {
      return;
    }

    int listLength = getCount();
    if (position > listLength - 1 || position < 0) {
      System.out.println("Invalid position.");
      return;
    }

    if (position == 0) {
      head = temp.next;
      tail.next = head;
      return;
    }

    for (int i = 0; i < position; i++) {
      prev = temp;
      temp = temp.next;
    }

    prev.next = temp.next;
    temp.next = null;
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

    System.out.print(current.data);
  }

  public void traverseLoop() {
    Node temp = head;

    while (temp != null) {
      System.out.print(temp.data + " --> ");

      temp = temp.next;
    }
    System.out.print(" NULL ");
  }
}
