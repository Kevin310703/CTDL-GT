public class linkedStack {
    private Node head = null;
    private class Node{
        String item;
        Node next;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(String item){
        Node oldhead = head;
        head = new Node();
        head.item = item;
        head.next = oldhead;
    }
    public String pop(){
        String item = head.item;
        head = head.next;
        return item;
    }
    public void print(){
        while(head != null){
            System.out.println(head.item);
            head = head.next;
        }
    }
}
