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
