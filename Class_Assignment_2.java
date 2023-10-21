public class Class_Assignment_2 {
    // Question 1
    public static void reverse_Circular_Queue(){
        /*
         * Dequeue all elements from the circular queue and push them onto a stack.
         * Then pop all elements from the stack and enqueue them back into the circular queue.
        */
        circularQueue queue = new circularQueue(5);
        Stack ss = new Stack(queue.size);
        while(!queue.isEmpty()){
            stack.push(queue.dequeue());
        }
        while(!ss.isEmpty()){
            queue.enqueue(stack.pop());
        }
    }

    // Question 2 Making a queue using 2 Stacks
    public static void queue(){

    }

    // Question 3 remove and append zeros at the end of the array
    public static void move_Zeros(){

    }

    // Question 4  move even nodes to the end of the linked list in reverse order
    public static void move_LinkedList(){

    }

    // Question 5 Leader Selection
}
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
