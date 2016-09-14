
public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cache cache = new Cache(3);
		cache.set(1, 100);
		cache.set(2, 101);
		
		cache.set(3, 103);
		cache.set(4, 104);
		cache.set(5, 106);
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(5));
		
	}

}
