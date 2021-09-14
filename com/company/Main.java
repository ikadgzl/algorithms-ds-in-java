package com.company;


import LinkedList.CircularSinglyLinkedList;

public class Main {

  public static void main(String[] args) {
    CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();

    circularSinglyLinkedList.push(3);
    circularSinglyLinkedList.push(5);
    circularSinglyLinkedList.push(2);
    circularSinglyLinkedList.push(7);
    circularSinglyLinkedList.push(6);
    circularSinglyLinkedList.push(9);
    circularSinglyLinkedList.push(8);
    circularSinglyLinkedList.push(4);



    System.out.println("\n//TRAVERSING//");
    circularSinglyLinkedList.traverse();


    System.out.println("\n//SORTED TRAVERSING//");
    circularSinglyLinkedList.sortCircularLinkedList();
    circularSinglyLinkedList.traverse();


  }
}
