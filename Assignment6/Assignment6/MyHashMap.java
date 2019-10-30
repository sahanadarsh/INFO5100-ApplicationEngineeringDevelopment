package Assignment6;

import java.util.ArrayList;

/*Design a HashMap without using any built-in hash table libraries.
 * To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.
 */


public class MyHashMap {

	int numOfOp = 10000;

	ArrayList<Node> hashList;

	public MyHashMap() {
		hashList = new ArrayList<>();
		for(int i = 0; i < numOfOp; i++) {
			hashList.add(new Node(-1, -1));
		}
	}

	public int hashFunction(int key) {
		return key % numOfOp;
	}

	public void put(int key, int value) {
		int idx = hashFunction(key);
		Node temp = hashList.get(idx);
		if(temp.key == -1 && temp.value == -1) {
			temp.key = key;
			temp.value = value;
		}else if( temp.key ==key) {
			temp.value = value;
		}else {
			while(temp.key != key && temp.next !=null ) {
				temp = temp.next;
			}
			if(temp.key == key) {
				temp.value = value;
			} else {
				temp.next = new Node(key, value);
			}
		}		
	}

	public int get(int key) {
		int idx = hashFunction(key);
		Node temp = hashList.get(idx);
		if(temp.key == -1 && temp.value == -1) {
			return -1;
		}else if(temp.key ==key) {
			return temp.value;
		}else {
			while(temp.key != key && temp.next !=null ) {
				temp = temp.next;
			}
			if(temp.key == key) {
				return temp.value;
			}else {
				return -1;
			}
		}
	}

	public void remove(int key) {
		int idx = hashFunction(key);
		Node temp = hashList.get(idx);
		if(temp.key == -1) {
			return;
		}else if(temp.key ==key) {
			if(temp.next != null) {
				hashList.set(idx, temp.next);
			}else {
				temp.key = -1;
			}
			temp.key = -1;
			temp.value = -1;
		}else if(temp.next != null){
			Node current = temp.next;
			Node previous = temp;	
			while(current.key != key && current.next !=null ) {
				previous = current;
				current = current.next;
			}
			if(current.key == key) {
				previous.next = current.next;
			}
		}
	}

	public class Node{
		int key;
		int value;
		Node next;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);  
		System.out.println(hashMap.get(1));            // returns 1
		System.out.println(hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 1);                             // update the existing value
		System.out.println(hashMap.get(2));            // returns 1 
		hashMap.remove(2);                             // remove the mapping for 2
		System.out.println(hashMap.get(2));            // returns -1 (not found) 
	}
}
