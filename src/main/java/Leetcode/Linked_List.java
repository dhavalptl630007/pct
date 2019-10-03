package Leetcode;


class ListNode
{
	int data;
	ListNode next;
	
	ListNode(int data)
	{
		this.data = data;
		this.next = null;
	}
	
}


public class Linked_List {

	public static void main(String[] args) {
		
	}

	private static void traverse(ListNode head) {}

	private static void createlinkedlist(ListNode head, int data) {
		
		if (head.next == null)
		{
			ListNode node = new ListNode(data);
			head.next = node;
			return;
		}
		
		else
		{
			createlinkedlist(head.next, data);	
		}
		
	}

}
