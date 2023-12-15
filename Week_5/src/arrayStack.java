public class arrayStack {
    private String[] s;
    private int N = 0;
    public arrayStack(int capacity){
        s = new String[capacity];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public void push(String item){
        s[N++] = item;
    }
    public String pop(){
        return s[--N];
    }
    public void print(){
        for(int i = 0; i < N; i++){
            System.out.println(s[i]);
        }
    }
}
