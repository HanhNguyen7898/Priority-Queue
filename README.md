# Priority-Queue
For this assignment, you will write two implementations of a Priority Queue. For this ADT, 
removal operations always return the object in the queue of highest priority, and if multiple 
objects have the same priority, the one in the queue the longest shall be returned. That is, no 
object of a given priority is ever removed as long as the queue contains one or more object of 
a higher priority. Within a given priority FIFO order must be preserved. This property is 
called stable sorting in a sorting algorithm, where two objects with equal keys will need to 
appear in the same sorted order as they appear in the unsorted order. 
Your implementations will be:  
1.  Ordered Array 
2.  Unordered Array 
3.  Binary Heap 
All implementations must have identical behavior, and must implement the PriorityQueue  
interface (provided). The implementations must have two constructors, a default constructor 
with no arguments that uses the DEFAULT_MAX_CAPACITY constant from  
the PriorityQueue interface, and a constructor that takes a single integer parameter that 
represents the maximum capacity of the priority queue. 
 
The PriorityQueue interface follows:  
   
/* The PriorityQueue ADT may store objects in any order. However, 
** removal of objects from the PQ must follow specific criteria. The 
** object of highest priority must be the one returned by the  
** remove() method; and if multiple objects have the same priority, 
** the one in the queue the longest shall be returned, ie, FIFO 
** return order must be preserved for objects of identical priority.  **     ** Ranking of objects by priority is determined by the Comparable<E> 
** interface. All objects inserted into the PQ must implement this 
** interface. */      package data_structures;  
 import java.util.Iterator;  
  public interface PriorityQueue<E extends Comparable <E>> extends Iterable<E> {  
public static final int DEFAULT_MAX_CAPACITY = 1000; 
      //  Inserts a new object into the priority queue.  Returns true if      //  the insertion is successful.  If the PQ is full, the insertion     //  is aborted, and the method returns false. 
    public boolean insert(E object); 
         //  The object of highest priority must be the one returned by the  
    //  remove() method; and if multiple objects have the same priority, 
    //  the one in the queue the longest shall be returned, ie, FIFO 
    //  return order must be preserved for objects of identical priority. 
    //  Returns null if the PQ is empty. 
    public E remove();  
          //  Deletes all instances of the parameter obj from the PQ if found, 
    //  and returns true. Returns false if no match to the parameter obj 
    //  is found. 
    public boolean delete(E obj);  
         //  Returns the object of highest priority in the PQ; if multiple 
    //  objects have the same highest priority, return the one that has  
    //  been in the PQ the longest, but does NOT remove it.       //  Returns null if the PQ is empty. 
    public E peek();     
          //  Returns true if the priority queue contains the specified element      //  false otherwise.      
    public boolean contains(E obj);   
         //  Returns the number of objects currently in the PQ.      
    public int size();  
            //  Returns the PQ to an empty state.      
    public void clear();  
         //  Returns true if the PQ is empty, otherwise false      
    public boolean isEmpty();  
         //  Returns true if the PQ is full, otherwise false.  List based      //  implementations should always return false.      
    public boolean isFull();    
          //  Returns an iterator of the objects in the PQ, in no particular      //  order. 
    public Iterator<E> iterator();               
     
}   
  
Thus, your project will consist of the following files. You must use exactly these filenames.  
• PriorityQueue.java The ADT interface (provided above)  
• OrderedArrayPriorityQueue.java The ordered array implementation.  
• UnorderedArrayPriorityQueue.java The unordered array implementation. 
• BinaryHeapPriorityQueue.java The binary heap implementation.  
  
  
Additional Details:  
• Each method must be as efficient as possible. That is, a O(n) is unacceptable if the 
method could be written with O(log n) complexity. Accordingly, the ordered array 
implementation must use binary search where possible, such as the contains(), the 
delete(E obj) method and also to identify the correct insertion point for new 
additions. For binary heap implementation, both insert() and remove() must be 
O(log n). 
• By convention, a lower number=higher priority. If there are five priorities for a 
given object, 1 .. 5, then 1 is the highest priority, and 5 the lowest priority.  
• You BinaryHeap must be stable, i.e., able to determine the oldest entry among those 
with identical priority. 
• Your project must consist of only the three files specified (not including the provided 
interface), no additional source code files are permitted. (Do not hand in a copy of 
PriorityQueue.java, as it is provided to you).  
• You may not make any modifications to the PriorityQueue interface provided. I will 
grade your project with my copy of this file.  
• All source code files must have your name and class account number at the beginning 
of the file.  
• All of the above classes must be in a package named 'data_structures'.  
• You may import java.util.Iterator, and java.util.NoSuchElementException. If you 
feel that you need to import anything else, let me know. You are expected to write all 
of the code yourself, and you may not use the Java API for any containers.  
• Your code must not print anything.  
• Your code should never crash, but must handle any/all error conditions gracefully. i.e. 
if the user attempts to call the clear() method on an empty PQ, or remove an item from 
an empty PQ, the program should not crash. Be sure to follow the specifications for all 
methods.  
• You must write generic code according to the interface provided. You may not add 
any public methods to the implementations, but you may add private ones, if needed.  
• Your code may generate unchecked cast warnings when compiled, but it must compile 
and run correctly on edoras to receive any credit.  
• A sample tester/driver program might be provided to help you test your code. I will 
use my test/driver program to run and grade your assignment. In addition, you may 
write your own test program to verify other functionalities as intended. 
• Allowing sufficient time for testing on edoras is essential.  Use your sandbox with the 
following directory structure:  
 
  
 
 
Turning in your project:  
To submit your project, you must copy your Java source code files into your ~/handin/pa2 
subdirectory on edoras. Be sure to check the Program Submission Guidelines page.  
IMPORTANT NOTE: Do not recreate the data_structures subdirectory in the handin 
subdirectory--just copy the following three files into the handin/pa2/ directory itself on 
edoras:   
~/handin/pa2     OrderedArrayPriorityQueue.java 
   UnorderedArrayPriorityQueue.java     BinaryHeapPriorityQueue.java  
  
Cheating Policy  
There is a zero tolerance policy on cheating in this course. You are expected to complete all 
programming assignments on your own. Collaboration with other students in the course is 
not permitted. You may discuss ideas or solutions in general terms with other students, but 
you must not exchange code. During the grading process I will examine your code carefully. 
Anyone caught cheating on a programming assignment (or on an exam) will receive an "F" 
in the course, and a referral to Judicial Procedures.  
  
~/sandbox/pa2/ 
      TestDriverProgram.java 
      data_structures/ 
            PriorityQueue.java 
            OrderedArrayPriorityQueue.java 
            UnorderedArrayPriorityQueue.java 
            BinaryHeapPriorityQueue.java 
 • You must write generic code according to the interface provided. You may not add 
any public methods to the implementations, but you may add private ones, if needed.  
• Your code may generate unchecked cast warnings when compiled, but it must compile 
and run correctly on edoras to receive any credit.  
• A sample tester/driver program might be provided to help you test your code. I will 
use my test/driver program to run and grade your assignment. In addition, you may 
write your own test program to verify other functionalities as intended. 
• Allowing sufficient time for testing on edoras is essential.  Use your sandbox with the 
following directory structure:  
 
  
 
