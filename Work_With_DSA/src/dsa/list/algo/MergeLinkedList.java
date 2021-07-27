package dsa.list.algo;

import java.util.Collections;
import java.util.*;

import org.junit.Test;

public class MergeLinkedList {
	
	
	/*
	 * LinkedList : 1 -> 3 -> 5 LinkedList : 2 -> 4 -> 6 
	 * Sorted LinkedList -> Merge Both LinkedList 
	 * Return the sorted Linked List !! 1 -> 2 -> 3 -> 4 -> 5 ->
	 * 6
	 */

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
    
    //Time Complexity O(n) / Space Complexity O(n)
    public Node mergeNodesLinearApproach(Node node1, Node node2) {
    	Node mergedNode = new Node();
    	Node current = mergedNode;
    	while(node1!= null && node2!= null) {
    		if(node1.value < node2.value) {
    			current.next = node1;
    			node1 = node1.next;
    		}else {
    			current.next = node2;
    			node2 = node2.next;
    		}
    		current = current.next;
    	}
    	current.next = (node1==null)? node2 : node1;
    	return mergedNode.next;
    }
    
  //Time Complexity O(n) / Space Complexity O(1)
    public Node mergeNodesRecursionApproach(Node node1, Node node2) {
    	
    	//If any of the node value is null return the other node
    	if(node1 == null)
    		return node2;
    	if(node2==null)
    		return node1;
    	
    	//Compare the node1 and node 2 value
    	if(node1.value < node2.value) {
    		node1.next = mergeNodesRecursionApproach(node1.next, node2);
    		return node1;
    	}else {
    		node2.next = mergeNodesRecursionApproach(node1, node2.next);
    		return node2;
    	}
    }
    
//    public Node reorderNodesRecursionApproach(Node node1) {
//    	Node left = node1.next;
//    	Node right = node1.next.next;
//    	while(node1 !=null) {
//    		if((right.value & 1) == 0) {
//    			node1.next = node1.next;
//    		}else {
//    			node1.next = right;
//    			node1.next.next= left;
//    			left = left.next;
//    			right = right.next.next;
//    		}
//    	}
//    	return node1;
//    }
    
    //@Test //To Create a linked list
    public void addNodes() {
    	Node head = new Node(1);
    	head.next = addNode(2);
    	head.next.next = addNode(3);
    	head.next.next.next = addNode(4);
    	printAllNodes(head);
    }
    
    @Test //Merge Two nodes and return a new Node
    public void mergeTwoNodes() {
    	Node head1 = new Node(1);
    	head1.next = addNode(3);
    	head1.next.next = addNode(5);
    	
    	Node head2 = new Node(2);
    	head2.next = addNode(4);
    	head2.next.next = addNode(6);
    	
    	Node head3 = new Node();
    	Node n = head3.next;
    	
    	//printAllNodes(mergeNodesLinearApproach(head1, head2));
    	printAllNodes(mergeNodesRecursionApproach(head1, head2));
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
        return outputNode;    
    }
    
    
    
    @Test //Re order the new node with odd followed by even
    public void reOrderNodes() {
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
    
    //sort array and difference
    public static int minDiff(List<Integer> arr) {
    // Write your code here
        int sum = 0;
        Collections.sort(arr);
        for (int i = 0; i < arr.size()-1; i++) {
            sum += Math.abs(arr.get(i+1) - arr.get(i));
            System.out.println(sum);
        }
        return sum;
    }
}
