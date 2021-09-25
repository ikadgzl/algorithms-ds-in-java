package com.company;


import LinkedList.DoublyLinkedList;

public class Main {

  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();

    dll.push(1);
    dll.push(2);
    dll.push(3);
    dll.push(4);
    dll.push(5);

    dll.append(44);
    dll.push(84);

    dll.insertAfter(dll.head.next.next, 123);

    dll.traverse();

    System.out.println();
    System.out.println();

    dll.sortLinkedList();

    dll.traverse();


  }
}
