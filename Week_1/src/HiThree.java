public class HiThree {
    public static void main(String[] args) {
        // Kiểm tra đối số
        if (args.length == 3) {
            // Đảo ngược thứ tự của các tên và in ra câu chào
            System.out.println("Hi " + args[2] + ", " + args[1] + ", and " + args[0] + ".");
        } else {
            System.out.println("Usage: java HiThree <name1> <name2> <name3>");
        }
    }
}
