package hr.fer.oop.introduction;

/**
 * @author OOP course
 * @version 1.0
 */
public class CustomLinkedList{

  /**
   * This method is called once the program is run. Arguments are described below
   * It creates linked list with few names in C/C++ manner (not in object oriented programming manner)
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    Node head = null; // similar to Node *head = null in C/C++

    head = add(head, "Ana");
    head = add(head, "Ivana");
    head = add(head, "Jasna");

	printList(head);

	//delete list
    while(head != null) {
      Node temp = head;
      head = head.next;
      System.out.println("Removed element: "+temp.value);
    }
  }
  
  /**
   * add string to the end of the list
   * @param head head of the list
   * @param name element to add
   * @return new head of the list if list was empty or previous head of the list
   */
  static Node add(Node head, String name) {
    if (head == null){
		head = new Node();
		head.value = name;
		head.next = null;
	}
	else{
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new Node();
		temp.next.value = name;
		temp.next.next = null;
	}
	return head;
  }

  /**
   * print list content
   * @param head head of the list
   */
  static void printList(Node head){	
	int pos=1;
	while(head != null){
		System.out.format("%d. %s%n", pos++, head.value);
		head = head.next;
	}
  } 

}
