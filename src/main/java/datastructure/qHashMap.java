package datastructure;


/**
 * @author QuyenH
 *
 * @implementation: create an Array, each element contain a LinkedList (Key, Value)
 * Normally each LinkedList only has 1 node. In case of collosion, LinkedList will have more than one nodes
 * How to find the array index for each (Key, Value) pair: hash the Key then % (Array length - 1)
 */
public class qHashMap<K, V> {
	
	private Entry<K, V>[] map;
	private int mapIndex;	
	private final int INITIAL_CAPACITY = 50;
	private int len; // length of map
	private int size; // number of entries inside the map
	
	
	public qHashMap() {
		this.map = new Entry[INITIAL_CAPACITY];
		setLen(INITIAL_CAPACITY);
	}
	
	public qHashMap(int capacity) {
		this.map = new Entry[capacity*2]; // double-size to avoid collision
		setLen(capacity*2);
	}
	
	public void put(K key, V value) {
		Entry<K, V> entry = new Entry<>(key, value, null);
		mapIndex = hashKey(key) % (getLen()-1);
		
		if(map[mapIndex] == null) {
			map[mapIndex] = entry;
			setSize(getSize()+1);
		} else {
			Entry<K, V> existing = map[mapIndex];
			while(existing.getNext()!=null) {

				if(existing.getKey()==key) {
					existing.setValue(value);
					return;
				}
				existing = existing.getNext();
			}
			
			existing.setNext(entry);
			setSize(getSize()+1);
		}
	}
	
	public V get(String key) {
		int index = hashKey((K) key) % getLen();
		
		if(map[index].getKey()==key) {
			return map[index].getValue();
		} else if (map[index].getNext()!=null) {
			Entry<K, V> findEntry = map[index].getNext();
			while(map[index].getNext()!=null) {
				if(map[index].getKey()==key) {
					return map[index].getValue();
				}
				findEntry = findEntry.getNext();
			}		
			System.out.println("Something wrong with the hash function. There is no key in the table");
			return null;
		} else {
			System.out.println("Something wrong with the hash function. There is no key in the table");
			return null;
		}
	}
	
	private int hashKey(K key) {
		int hash=0;		
		char[] charArray = ((String) key).toCharArray();
		
		for(int i=0; i< charArray.length; i++) {
			hash+= charArray[i]*i;
		}
		
		return hash;
	}	
	
	public void displayMap() {
		for(int i=0;i< map.length;i++) {
			if(map[i]==null) {
				continue;
			}
			
			if(map[i].getNext()==null) {
				System.out.printf("Key: %s | Value: %s |\n", map[i].getKey(),map[i].getValue());
			} else {
				Entry currentNode = map[i];

				while(currentNode.getNext()!=null) {
					System.out.printf("Key: %s | Value: %s | ", currentNode.getKey(), currentNode.getValue());
					currentNode=currentNode.getNext();
				}
				System.out.printf("Key: %s | Value: %s | ", currentNode.getKey(), currentNode.getValue());
				System.out.println();
			}
		}
	}

	public Entry<K, V>[] getNodes() {
		return map;
	}

	public void setNodes(Entry<K, V>[] nodes) {
		this.map = nodes;
	}

	public int getMapIndex() {
		return mapIndex;
	}

	public void setMapIndex(int mapIndex) {
		this.mapIndex = mapIndex;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	private static class Entry<K, V>{
		K key;
		V value;
		Entry<K, V> next;
		
		Entry(K key, V value, Entry<K, V> next){
			this.key = key;
			this.value = value;
			this.next = null;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}			
	}
	
	
}
