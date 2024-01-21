package Test;
import doublyLinkedListPD.doublyLinkedList;
import java.util.ArrayList;
public class test {
	public static void main(String[] args) {
		
		doublyLinkedList<String> String; 
		doublyLinkedList countries = new doublyLinkedList<>(); 
		
		countries.addFirst("USA");
		countries.addLast("Germany");
		countries.addFirst("France");
		countries.addLast("England");
		countries.addFirst("Belgium");
		
		System.out.println("The list from last is" + countries.toArrayFromLast());
		System.out.println("The list from first is" + countries.toArrayFromFirst());
		System.out.println("The cloned list is" + countries.clone().toArrayFromFirst());
		
	}
}
