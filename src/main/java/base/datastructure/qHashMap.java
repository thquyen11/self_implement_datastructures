package base.datastructure;

/**
 * @author QuyenH
 *
 * @implementation: create an Array, each element contain a LinkedList (Key, Value)
 * Normally each LinkedList only has 1 node. In case of collision, LinkedList will have more than one nodes.               
 * How to find the array index for each (Key, Value) pair: hash the Key then % (Array length - 1)                 
 */
public class qHashMap<K, V> {

	private Bucket<K, V>[] map;
	private int mapIndex;
	private final int INITIAL_CAPACITY = 50;
	private int len = 0; // length of map
	private int size = 0; // number of entries inside the map
	private int noOfColision = 0;

	public qHashMap() {
		this.map = new Bucket[INITIAL_CAPACITY];
		setLen(INITIAL_CAPACITY);
	}

	public qHashMap(int capacity) {
		this.map = new Bucket[capacity * 2]; // double-size to avoid collision
		setLen(capacity * 2);
	}

	public void put(K key, V value) {
		Bucket<K, V> entry = new Bucket<>(key, value, null);
		mapIndex = hashKey(key) % (getLen() - 1); // % (Mod) get the index in Array
		
		// empty map
		if (map[mapIndex] == null) {
			map[mapIndex] = entry;
			setSize(getSize() + 1);
		} 
		// non-empty map
		else {
			Bucket<K, V> existing = map[mapIndex];
			while (existing.getNext() != null) {

				if (existing.getKey() == key) {
					existing.setValue(value);
					return;
				}
				existing = existing.getNext();
			}

			existing.setNext(entry);
			setSize(getSize() + 1);
			setNoOfColision(getNoOfColision() + 1);
		}
	}

	public V get(String key) {
		int index = hashKey((K) key) % (getLen()-1);

		if (map[index].getKey() == key) {
			return map[index].getValue();
		} 
		// collision: there is more than one buckets at that node
		// Iterate through the bucket until find out the required key-value pair
		else if (map[index].getNext() != null) {
			Bucket<K, V> findEntry = map[index].getNext();
			while (map[index].getNext() != null) {
				if (map[index].getKey() == key) {
					return map[index].getValue();
				}
				findEntry = findEntry.getNext();
			}
			System.out.println("Something wrong with the hash function. There is no key in the table");
			return null;
		} 
		// Could not find the key in HashMap
		else {
			System.out.println("Something wrong with the hash function. There is no key in the table");
			return null;
		}
	}
	
	// get array of HashMap's keys
	public String[] keys() {
		String[] keys = new String[getSize() - getNoOfColision()];
		int keysIndex = 0;

		for (int i = 0; i < map.length; i++) {
			if (map[i] == null)
				continue;
			keys[keysIndex] = (String) map[i].getKey();
			keysIndex++;
		}

		return keys;
	}

	// get array of HashMap's values
	public String[] values() {
		String[] values = new String[getSize()];
		int valuesIndex = 0;

		for (int i = 0; i < map.length; i++) {
			if (map[i] == null) continue;
			values[valuesIndex] = (String) map[i].getValue();
			valuesIndex++;
			
			if(map[i].getNext()!=null) {
				Bucket<K, V> currentEntry = map[i];
				do {
					currentEntry = currentEntry.getNext();
					values[valuesIndex] = (String) currentEntry.getValue();
					valuesIndex++;
				} while(currentEntry.getNext()!=null);				
				
			}
		}
		
		return values;
	}

	// simple hash function
	private int hashKey(K key) {
		int hash = 0;
		char[] charArray = ((String) key).toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			hash += charArray[i] * i;
		}

		return hash;
	}

	public void displayMap() {
		for (int i = 0; i < map.length; i++) {
			if (map[i] == null) {
				continue;
			}

			if (map[i].getNext() == null) {
				System.out.printf("Key: %s | Value: %s |\n", map[i].getKey(), map[i].getValue());
			} else {
				Bucket currentNode = map[i];

				while (currentNode.getNext() != null) {
					System.out.printf("Key: %s | Value: %s | ", currentNode.getKey(), currentNode.getValue());
					currentNode = currentNode.getNext();
				}
				System.out.printf("Key: %s | Value: %s | ", currentNode.getKey(), currentNode.getValue());
				System.out.println();
			}
		}
	}

	public int getNoOfColision() {
		return noOfColision;
	}

	public void setNoOfColision(int noOfColision) {
		this.noOfColision = noOfColision;
	}

	public Bucket<K, V>[] getNodes() {
		return map;
	}

	public void setNodes(Bucket<K, V>[] nodes) {
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

	private static class Bucket<K, V> {
		K key;
		V value;
		Bucket<K, V> next;

		Bucket(K key, V value, Bucket<K, V> next) {
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

		public Bucket<K, V> getNext() {
			return next;
		}

		public void setNext(Bucket<K, V> next) {
			this.next = next;
		}
	}

}
