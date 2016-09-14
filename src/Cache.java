import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {
	
	CacheList cacheList;
	Map<Integer, CacheNode> cacheMap;
	int capacity;
	
	public Cache(int capacity) {
		this.cacheList = new CacheList();
		this.cacheMap = new HashMap<Integer, CacheNode>();
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if(!cacheMap.containsKey(key)) {
			return -1;
		}
		CacheNode cachedNode = cacheMap.get(key);
		cacheList.insertAtBeginning(cachedNode);
		cacheList.deleteNodeGivenNode(cachedNode);
		return cachedNode.getValue();
	}
	
	public void set(int key, int value) {
		if(cacheMap.containsKey(key)) {
			return;
		}
		CacheNode node = new CacheNode(key, value);
		if(cacheList.getNodeCount() == capacity) {
			cacheList.deleteLastNode();
		} 
		cacheList.insertAtBeginning(node);
		cacheMap.put(key, node);
	}

}
