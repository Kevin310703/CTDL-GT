public class MyList {
    MyNode head;
    public void addFirst(String data){
        head = new MyNode(data, head);
    }
    public void print(){
        MyNode p = head;
        while(p != null){
            p = p.next;
        }
    }
    public String toString(){
        String result = "[";
        MyNode p = head;
        while(p != null){
            result += " " + p.data;
            p = p.next;
        }
        return result + " ]";
    }
    public void append(String data){
        if(head == null){
            head = new MyNode(data, null);
        }
        else{
            MyNode p = head;
            while(p.next != null)   p = p.next;
            p.next = new MyNode(data, null);
        }
    }
    public void removeLast(){
        if(head == null)    return;
        if(head.next == null)   head = null;
        else{
            MyNode p = head;
            while(p.next.next != null)  p = p.next;
            p.next = null;
        }
    }

    public MyNode removeFirst(String data, MyNode node){
        if(node == null)    return null;
        if(node.data.equals(data)) return node.next;
        node.next = removeFirst(data, node.next);
        return node;
    }

    public MyNode removeAll(String data, MyNode node){
        if(node == null) return null;
        if(node.data.equals(data)){
            return removeAll(data, node.next);
        }
        node.next = removeAll(data, node.next);
        return node;
    }
}
