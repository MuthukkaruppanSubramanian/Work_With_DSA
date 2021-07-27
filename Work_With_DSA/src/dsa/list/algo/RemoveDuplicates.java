package dsa.list.algo;

import java.util.HashSet;

import org.junit.Test;

public class RemoveDuplicates {
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
    
    public Node condense(Node head) {
    // Write your code here
	    Node outputNode = new Node();  
	    Node tmp = outputNode;
        HashSet<Integer> set = new HashSet<>();
        while(head!=null){
              if(set.contains(head.value)){
                  head = head.next;
                  tmp.next = null;
              }else{
                  set.add(head.value);
                  tmp.next = head;
                  head = head.next;
                  tmp = tmp.next;
              }
              
          }
        return outputNode.next;    
    }
    
    @Test //Remove duplicates
    public void removeDuplicates() {
    	Node head1 = new Node(3);
    	head1.next = addNode(4);
    	head1.next.next = addNode(3);
    	head1.next.next.next = addNode(2);
    	head1.next.next.next.next = addNode(6);
    	head1.next.next.next.next.next = addNode(1);
    	head1.next.next.next.next.next.next = addNode(2);
    	head1.next.next.next.next.next.next.next = addNode(6);
    	printAllNodes(condense(head1));
    }
}
