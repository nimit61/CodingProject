import java.util.List;

public class CacheList {

	CacheNode head;
	CacheNode last;

	int nodeCount;

	public CacheList() {
		this.head = null;
		this.nodeCount = 0;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void insertAtBeginning(CacheNode node) {
		node.next = this.head;
		if(this.head != null) {
			this.head.previous = node;
		}
		this.head = node;
		this.nodeCount++;
		if (this.head.next == null) {
			this.last = head;
		}
	}

	public void deleteNodeGivenNode(CacheNode node) {
		if (node == null) {
			return;
		}
		if (node.next == null && node.previous == null) {
			this.head = null;// single node present in list
			this.last = null;
			node = null;
		} else if (node.previous == null) {
			node.next.previous = null;// deleting first node
			this.head = node.next;
			node.next = null;
			node = null;
		} else if (node.next == null) {
			node.previous.next = null; // deleting last node
			this.last = node.previous;
			node.previous = null;
			node = null;
		} else {
			// deleting middle node
			node.previous.next = node.next;
			node.next.previous = node.previous;
			node.next = null;
			node.previous = null;
			node = null;
		}
		this.nodeCount--;
	}

	public void deleteLastNode() {
		deleteNodeGivenNode(this.last);
	}
	
	public CacheNode getLastNode() {
		return this.last;
	}
}
