public class List_Test {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.append("1");
        System.out.println(list);
        list.addFirst("2");
        System.out.println(list);
        list.addFirst("3");
        System.out.println(list);
        list.append("4");
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }
}
