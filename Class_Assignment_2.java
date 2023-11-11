import java.util.ArrayDeque;
import java.util.Deque;

public class Class_Assignment_2 {
    // Question 1
    public static void reverse_Circular_Queue(circularQueue queue){
        /*
         * Dequeue all elements from the circular queue and push them onto a stack.
         * Then pop all elements from the stack and enqueue them back into the circular queue.
        */
        
        Stack ss = new Stack();
        while(!queue.isEmpty()){
            ss.push(queue.dequeue());
        }
        while(!ss.isEmpty()){
            queue.enqueue(ss.pop());
        }
    }

    // Question 2 Making a queue using 2 Stacks
    class making_queue{
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        Stack temp_stack;
        public int dequeue(){
            if(s1.isEmpty()){
                return -1;
            }
            else{
                int temp=-1;
                while(!s1.isEmpty()){
                    temp = s1.pop();
                    if(!s1.isEmpty())
                        s2.push(temp);
                }
                temp_stack = s1;
                s1 = s2;
                s2 = temp_stack;
                return temp;
            }
        }
        public void enqueue(int value){
            s1.push(value);
        }
        public boolean isEmpty(){
            return s1.isEmpty();
        }
    }

    // Question 3 remove and append zeros at the end of the array
    public static int[] move_Zeros(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                for(int j=i;j<arr.length-1;j++){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    // Question 4  move even nodes to the end of the linked list in reverse order
    public static void move_LinkedList(LinkedList ll){
        Node curr  = ll.head;
        Node curr2 = curr.next;
        Stack ss = new Stack();
        while(curr2!=null){
            if(curr2.data % 2 == 0){
                ss.push(curr2.data);
                curr.next = curr.next.next;
                curr2 = curr2.next;
                continue;
            }
            curr = curr.next;
            curr2 = curr2.next;
        }
        while(!ss.isEmpty()){
            Node temp = new Node(ss.pop());
            ll.tail.next = temp;
            ll.tail = temp;
        }
    }
    public static boolean balance(String expr){
    // Question 5 Leader Selection
    Deque<Character> stack
            = new ArrayDeque<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    }
}

// Stack class
class Stack{
    Node top;
    int size;
    Stack(){
        this.size = 0;
        this.top = null;
    }
    Stack(int size){
        this.size = size;
        top = null;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void push(int v){
        Node newElement = new Node(v);
        newElement.next = top;
        top = newElement;
        size++;
    }
    public int pop(){
        if(top!=null){
        Node temp = top;
        top = top.next;
        size--;
        return temp.data;
        }
        else{
            return -1;
        }

    } 
}

// Linked List Class
class LinkedList {
    Node head;
    int size;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addAtStart(int element){            
        Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
            if (tail == null)
                tail=head ;
            size++;
    }

    public void addAtEnd(int element){
        Node newNode = new Node(element);
        size++;
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        else{
            tail.next = newNode;
            tail= newNode;
        }
        
    }

    public boolean addAtLocation(int location,int element){
        if(location>=0 &&location<=size){                       // Validation if location is valid or not
            if(location == 0)
                addAtStart(element);
            else if (location == size)
                addAtEnd(element);
            else{
                int counter = 0;
                Node curr = head;
                Node temp = new Node(element);
                while(curr.next!=null){
                    if (counter==location-1){
                        temp.next = curr.next;
                        curr.next = temp;
                        size++;
                    }
                    counter++;
                    curr = curr.next;
                }
            }
            return true;
        }
        else{
            System.out.println("Location is not Valid");
        }                        
        return false;
    }

    public void print(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "-> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public Node delAtEnd() {
        if (head == null){
            System.out.println("List is Empty\nCannot Perform this Action");
            return null;
        }
        else if (head == tail){
            head = null;
            tail = null;
            size--;
        }
        else{
            Node curr = head;
            while(curr.next!=tail){
                curr=curr.next;}
                Node Temp = tail;
                curr.next = null;
                tail = curr;
                size--;
                return Temp;
            
        }
        return null;
    }

    public Node delAtStart(){                               
        if (head==null){
                System.out.println("List is empty");
                return null;
        }
        Node currNode = head;
        head = currNode.next;
        size--;
        return currNode;
    }

    public Node delAtLocation(int location){
        Node removed = head;
        if(location>=0 && location<size){
            if (location==0)
                delAtStart();
            else if(location==size-1)
                delAtEnd();
            else{
                int counter = 0;
                Node curr = head;
                while(curr.next!=null){
                    if (counter==location-1){
                        if(curr.next.next!=null){
                            removed = curr.next;
                            curr.next = curr.next.next;
                        }
                        else{
                            removed = curr.next;
                            curr.next = null;
                        }     
                        size--;
                    }
                    counter++;
                    curr = curr.next;
                }
            }
        }
        else{
            System.out.println("Invalid Location");
            return null;
        }
        return removed;
    }
    
    public Node search(int element){
            if (head==null){
                System.out.println("List is empty");
                return null;
            }
            Node currNode = head;
            while(currNode!=null){
                if (currNode.data == element)
                    return currNode;
                currNode = currNode.next;
            }
            return null;
    } 

    public void sorting(int order){
            Node curr = head;
            Node curr2 = head;
            Node temp = new Node();
            while(curr2!=null){
                while(curr.next!=null){
                     if ((order == 1 && curr.data > curr.next.data) || (order == 2 && curr.data < curr.next.data)) {
                        temp.data = curr.data;
                        curr.data = curr.next.data;
                        curr.next.data = temp.data;
                    }
                    curr=curr.next;
                }
                curr = head;
                curr2 = curr2.next;
            }    
    }

    public void UpdatedLinkedList(int updatedValue,int elementToFind){
        Node result = search(elementToFind);
        if (result == null){
            System.out.println("List is empty");
            return;
        }
        else{
            Node currNode = head;
            while(currNode!=null){
                if (currNode == result)
                    currNode.data = updatedValue;
                currNode = currNode.next;
            }
        }

        }
    
    public Node removeDuplicatesFromSortedList(){
        if (head==null)
            return head;
        Node curr = head;
        while(curr.next!=null){
            if (curr.data == curr.next.data){
                curr.next = curr.next.next;
            }
            else
                curr = curr.next;
        }
        return head;
    }

}
