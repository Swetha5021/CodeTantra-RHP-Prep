/*
P1: Given two sorted linked lists consisting of N and M nodes respectively. The task is to merge both of the lists (in place) and return the head of the merged list.
Examples:
Input: a: 5->10->15, b: 2->3->20
Output: 2->3->5->10->15->20
Input: a: 1->1, b: 2->4
Output: 1->1->2->4
*/

import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class MergeLists {
	Node head;
	/* Method to insert a node at
	the end of the linked list */
	public void addToTheLast(Node node)
	{
		if (head == null) {
			head = node;
		}
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	/* Method to print linked list */
	void printList()
	{
		System.out.println("Merged Linked List is:");
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// Driver Code
	public static void main(String args[])
	{
	    Scanner sc = new Scanner(System.in);
	    int n=sc.nextInt();
		MergeLists list1 = new MergeLists();
		MergeLists list2 = new MergeLists();
		
		for(int i=0;i<n;i++)
		list1.addToTheLast(new Node(sc.nextInt()));
		
		int m=sc.nextInt();
		for(int i=0;i<m;i++)
		list2.addToTheLast(new Node(sc.nextInt()));

		list1.head = new Merge().sortedMerge(list1.head,
											list2.head);
		list1.printList();
	}
}

class Merge {

	public Node sortedMerge(Node A, Node B)
	{
		if (A == null)
			return B;
		if (B == null)
			return A;

		if (A.data < B.data) {
			A.next = sortedMerge(A.next, B);
			return A;
		}
		else {
			B.next = sortedMerge(A, B.next);
			return B;
		}
	}
}

