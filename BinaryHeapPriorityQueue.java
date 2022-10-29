package data_structures;

/* Name: Hanh Tran Dieu Nguyen 
 * RedID: 826051324
 * Account number: cssc0242
 * Course: CS210-02_CS496-03-CX-Spring2022
 * Prof. Louie Lu 
 * Date: 03-30-2022
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryHeapPriorityQueue <E extends Comparable<E>> implements PriorityQueue<E>{

	private E[] myArray; 
	private int counter;
	final int CAPACITY;
	private int step;
	
	// Constructor
	@SuppressWarnings("unchecked")
	public BinaryHeapPriorityQueue() {
		CAPACITY = DEFAULT_MAX_CAPACITY;
		myArray = (E[]) new Comparable [CAPACITY];
		counter = 0;
	}
	
	@SuppressWarnings("unchecked")
	public BinaryHeapPriorityQueue(int capacity) {
		CAPACITY = capacity;
		myArray = (E[]) new Comparable [CAPACITY];
		counter = 0;
		step = 0;
	}
	
	//  Inserts a new object into the priority queue.  Returns true if 
    //  the insertion is successful.  If the PQ is full, the insertion
    //  is aborted, and the method returns false.
	@Override
	public boolean insert(E object) {
		if(isFull()) {
			return false;
		}
		myArray[counter]=object;
		counter++; 
		heapSort(counter - 1); 
		return true;
    }
	
	private void heapSort(int index) {
		int previous = (index - 1)/2; 
		if(myArray[previous].compareTo(myArray[index]) > 0) {
			E temp = myArray[previous]; 
			myArray[previous] = myArray[index]; 
			myArray[index] = temp; 
			heapSort(previous);
		}
	}
 
	//  The object of highest priority must be the one returned by the 
    //  remove() method; and if multiple objects have the same priority,
    //  the one in the queue the longest shall be returned, ie, FIFO
    //  return order must be preserved for objects of identical priority.
    //  Returns null if the PQ is empty.
	@Override
    public E remove() {
		if(isEmpty()) {
			return null;
		}
		int position = 0; 
		E temp = myArray[0]; 
		for(int i = 1; i < counter; i++) {
			if(temp.compareTo(myArray[i]) > 0) {
				temp = myArray[i]; 
				position = i; 
			}
		}
		for(int i = position; i < counter -1; i++) {
			myArray[i] = myArray[i+1]; 
		}
		counter --; 
		return temp;	
    }
	
	//  Deletes all instances of the parameter obj from the PQ if found, and     
    //  returns true.  Returns false if no match to the parameter obj is found.
	@Override
    public boolean delete(E obj) {
    	if(!contains(obj)) {
    		return false;
    	}
    	int size = counter;
    	BinaryHeapPriorityQueue<E> newArray = new BinaryHeapPriorityQueue<E>(counter);
    	for(int i=0; i < size; i++) {
    		E value = remove();
    		if(value.compareTo(obj) != 0) {
    			newArray.insert(value);
    		}
    	}
    	this.myArray = newArray.myArray;
    	this.counter = newArray.counter;
    	this.step = newArray.step;
    	return true;
    }
   
	//  Returns the object of highest priority in the PQ; if multiple
    //  objects have the same highest priority, return the one that has 
    //  been in the PQ the longest, but does NOT remove it.  
    //  Returns null if the PQ is empty.
	@Override
    public E peek() {
    	if(isEmpty()) {
    		return null;
    	}
    	return myArray[0];
    }
    
	//  Returns true if the priority queue contains the specified element 
    //  false otherwise.
	@Override
    public boolean contains(E obj) {
		for(int i = 0; i < counter; i++) {
			if(myArray[i] == obj) {
				return true;
			}
		}
		return false;
    }
   
	//  Returns the number of objects currently in the PQ.  
	@Override
	public int size() {
		return counter;
	}

	//  Returns the PQ to an empty state.     
	@Override
	public void clear() {
		counter = 0;
	}

	//  Returns true if the PQ is empty, otherwise false   
	@Override
	public boolean isEmpty() {
		return (counter == 0);
	}

	//  Returns true if the PQ is full, otherwise false.  List based 
    //  implementations should always return false.  
	@Override
	public boolean isFull() {
		return (counter == CAPACITY);
	}
	
	//  Returns an iterator of the objects in the PQ, in no particular 
    //  order.
	@Override
    public Iterator<E> iterator(){ 
		return new IteratorProgram();
	}
	
	private class IteratorProgram implements Iterator<E>{
		int index;
		@Override
		public boolean hasNext() {
			return index != counter;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return myArray[index++];
		}
	}
}
