public class Main{
    public static void main(String[] args){

    }
}
class Node{
    int data;
    Node next;
    public Node(){
        this.data = 0;
        this.next = null;
    }
    public Node(int value){
        this.data = value;
        this.next = null;
    }
}

class Queue_Linked{
    Node front;
    Node rear;

    public boolean enqueue(int v){
        try{
            Node temp = new Node(v);
            if(rear == null){    // Empty LinkedList
                rear = front = temp;
            }
            else if (front == rear){
                front.next = temp;
                rear = temp;
            }
            else{
                rear.next= temp;
                rear = temp;
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public Node dequeue(){
        if(front == null)
            return null;
        else{
            Node temp = front;
            front = front.next;
            return temp;
        }
    }

    boolean isFull(){
        return false;
    }

    boolean isEmpty(){
        return (front==null);
    }

    public String toString(){
        Node curr = front;
        String to_Return = "";
        while(curr != null){
            to_Return = to_Return+ " "+ curr.data;
            curr = curr.next;
        }
        return to_Return;
    }

    public Node getFront(){
        return front;
    }
}