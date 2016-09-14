
public class CacheNode {

	int key;
	int value;
	CacheNode previous;
	CacheNode next;
	
	public CacheNode(int key, int value) {
		this.key = key;
		this.value = value;
		this.previous = null;
		this.next = null;
	}
	
	public int getValue() {
		return this.value;
	}

	public int getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}
}
