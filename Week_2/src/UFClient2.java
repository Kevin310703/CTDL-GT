import edu.princeton.cs.algs4.*;
public class UFClient2 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);

        // Kiểm tra xem toàn bộ N đối tượng đã liên thông chưa
        boolean allConnected = false;

        int count = 0;
        while (!allConnected && !StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            uf.union(p, q);

            // Kiểm tra xem toàn bộ N đối tượng đã liên thông chưa
            allConnected = uf.count() == 1;

            count++;
        }

        // In kết quả
        if (allConnected) {
            System.out.println(count);
        } else {
            System.out.println("FAILED");
        }
    }
}
