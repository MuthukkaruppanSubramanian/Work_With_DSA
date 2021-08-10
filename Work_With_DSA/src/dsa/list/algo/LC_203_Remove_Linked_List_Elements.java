package dsa.list.algo;

import java.util.HashSet;

import org.junit.Test;

import dsa.list.algo.RemoveDuplicates.Node;

public class LC_203_Remove_Linked_List_Elements {
	public class Node{
		int value;
		Node next;
		Node(int key){
			this.value = key;
			next = null;
		}
		Node(){
//			next = null;
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

	public Node removeGivenNode(Node head, int val) {
		// Write your code here
		Node outputNode = new Node();
		Node tmp = outputNode;
		while(head!=null){
			if(val == head.value){
				head = head.next;
				tmp.next = null;
			}else{
				tmp.next = head;
				head = head.next;
				tmp = tmp.next;
			}

		}
		return outputNode.next;  
	}
	Node outputNode = new Node();
	Node tmp = outputNode;
	public Node removeGivenNodeRecursively(Node head, int val) {
		// Write your code here
		if(head == null) return head;
		if(head.next == null) return head.next;
		
		if(head.value != val) {
			tmp.next = head;
			tmp = tmp.next;
			head = head.next;
		}
		else {
			head = head.next;
			tmp.next = null;
		}
		removeGivenNodeRecursively(head, val);
		if(head.next!=null && head.next.value == val)head.next=null;
		return outputNode.next;   
	}
	
	@Test //Remove duplicates
	public void removeNode() {
		Node head1 = new Node();
//		head1.next = addNode(1);
//		head1.next.next = addNode(6);
//		head1.next.next.next = addNode(2);
//		head1.next.next.next.next = addNode(6);
//		head1.next.next.next.next.next = addNode(1);
//		head1.next.next.next.next.next.next = addNode(2);
//		head1.next.next.next.next.next.next.next = addNode(6);
		Node output = removeGivenNodeRecursively(head1,1);
		printAllNodes(output);
	}
}
