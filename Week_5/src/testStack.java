public class testStack {
    public static void main(String[] args) {
        linkedStack Stack = new linkedStack();
        System.out.println(Stack.isEmpty());
        Stack.push("123");
        Stack.push("432");
        Stack.push("789");
        Stack.pop();
        Stack.print();
        System.out.println(Stack.isEmpty());
    }
}
