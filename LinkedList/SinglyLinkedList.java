package LinkedList;

public class SinglyLinkedList {
  public Node head;

  public void printList() {
    Node n = head;

    while (n != null) {
      System.out.println(n.data);
      n = n.next;
    }
  }

  public void push(int data) {
    Node newNode = new Node(data);

    newNode.next = head;
    head = newNode;
  }

  public void insertAfter(Node prevNode, int data) {
    if (prevNode == null) {
      System.out.println("Invalid node.");
      return;
    }

    Node newNode = new Node(data);

    newNode.next = prevNode.next;
    prevNode.next = newNode;
  }

  public void append(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      return;
    }

    Node lastNode = head;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }

    lastNode.next = newNode;
  }

  public void deleteNode(int key) {
    Node temp = head;
    Node prev = null;

    if (temp != null && temp.data == key) {
      head = temp.next;
      return;
    }

    while (temp != null && temp.data != key) {
      prev = temp;
      temp = temp.next;
    }

    if (temp == null) {
      return;
    }

    prev.next = temp.next;
  }

  public void deleteNodeAt(int position) {
    Node temp = head;

    if (head == null) {
      return;
    }

    if (position == 0) {
      head = temp.next;
      return;
    }

    for (int i = 0; temp != null && i < position - 1; i++) {
      temp = temp.next;
    }

    if (temp == null || temp.next == null) {
      return;
    }

    temp.next = temp.next.next;
  }

  public void deleteList() {
    head = null;
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

  public void traverse() {
    Node temp = head;

    while (temp != null) {
      System.out.print(temp.data + " --> ");

      temp = temp.next;
    }
    System.out.print(" NULL ");

  }

  public boolean search(Node head, int key) {
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
