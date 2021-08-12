package dsa.list.algo;

import org.junit.Test;

public class Reverse_A_Linked_List {
	public class Node{
        int value;
        Node next;
        Node(int key){
            this.value = key;
            next = null;
        }
        Node(){
        	next = null;
        }
    }
	
    public Node addNode(int key) {
        return new Node(key);
    }
    
    public void printAllNodes(Node node) {
        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
    Node reverse = new Node();
    Node tmp = reverse;
	private Node reverseTheGivenList(Node head) {
		Node currentNode = head;
		while(currentNode != null) {
			tmp.next = currentNode;
			currentNode = currentNode.next;
		}
		tmp = tmp.next;
		reverseTheGivenList(head.next);
		return reverse.next;
	} 
    
    @Test //To Create a linked list
    public void addNodes() {
    	Node head = new Node(1);
    	head.next = addNode(2);
    	head.next.next = addNode(3);
    	head.next.next.next = addNode(4);
    	printAllNodes(reverseTheGivenList(head));
 

  }
}
