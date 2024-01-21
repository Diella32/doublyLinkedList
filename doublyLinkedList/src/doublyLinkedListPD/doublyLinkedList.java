package doublyLinkedListPD;

import java.util.ArrayList;

public class doublyLinkedList<E> {
	
 private static class Node<E>{
	 private E element;
	 private Node<E> previous;
	 private Node<E> next;
	 public Node(E e, Node<E> prev, Node<E> n) {
		 element = e;
		 previous = prev;
		 next = n; 
	 }
	 
	 public E getElement() {
		 return element; 
	 }
	 public Node<E> getPrevious(){
		 return previous;
	 }
	 public Node<E> getNext(){
		 return next;
	 }
	 public void setPrevious(Node<E> prev){
		 previous = prev;
	 }
	 public void setNext(Node<E> n){
		 next = n;
	 }
 }
 private Node<E> head;
 private Node<E> tail;
 private int size = 0; 
 public doublyLinkedList() {
	 head = new Node<>(null, null, null); 
	 tail = new Node<>(null, head, null);
	 head.setNext(tail);
 }
 public int size() {
	 return size; 
 }
 public boolean isEmpty() {
	return size == 0; 
 }
 public E first() {
	 if(isEmpty()) return null;
	 return head.getNext().getElement(); 
 }
 public E last() {
	 if(isEmpty()) return null;
	 return tail.getPrevious().getElement(); 
 }
 public void addFirst (E element) {
	 addBetween(element, head, head.getNext());
 }
 public void addLast (E element) {
	 addBetween(element, tail.getPrevious(), tail);
 }
 public E removeFirst() {
	 if(isEmpty()) return null;
	 return remove(head.getNext()); 
 }
 public E removeLast() {
	 if(isEmpty()) return null;
	 return remove(tail.getPrevious()); 
 }
 private void addBetween (E element, Node<E> before, Node<E> after) {
	 Node<E> newest = new Node<>(element, before, after);
	 before.setNext(newest);
	 after.setPrevious(newest);
	 size++; 
 }
 private E remove(Node<E> node) {
	 Node<E> before = node.getPrevious();
	 Node<E> after = node.getNext();
	 before.setNext(after);
	 after.setPrevious(before);
	 size--; 
	 return node.getElement(); 
 }
 public ArrayList<E>toArrayFromFirst(){
	 Node<E> node= head.next; 
	 ArrayList<E> elementUsed = new ArrayList<E>(); 
	 
	 while(node.next != null) {
		 elementUsed.add(node.getElement()); 
		 node = node.next; 
	 }
		 return elementUsed; 
}
 public ArrayList<E>toArrayFromLast(){
	 Node<E> nodeUsed= tail.getPrevious(); 
	 
	 ArrayList<E> elementUsedTwo = new ArrayList<E>(); 

	 while(nodeUsed.previous != null) {
		 //System.out.println("Goes");
		 elementUsedTwo.add(nodeUsed.getElement());
		 nodeUsed = nodeUsed.previous;
		 
	 }
	 
		 return elementUsedTwo; 
}
 
 public doublyLinkedList clone() {
	doublyLinkedList listClone  = new doublyLinkedList();
	Node<E> node = head.next; 
	
	while(node.getElement() != null) {
		listClone.addLast(node.getElement());
		node = node.next; 
	}
	return listClone; 

 }
 
}
