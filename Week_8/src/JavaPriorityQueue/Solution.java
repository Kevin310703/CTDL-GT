package JavaPriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    static class Student implements Comparable<Student> {
        int id;
        String name;
        double CGPA;

        Student(String name, double CGPA, int id) {
            this.name = name;
            this.CGPA = CGPA;
            this.id = id;
        }

        @Override
        public int compareTo(Student o) {
            if (CGPA == o.CGPA) {
                if (name.equals(o.name)) {
                    return Integer.compare(id, o.id);
                }
                return name.compareTo(o.name);
            }
            return Double.compare(o.CGPA, CGPA);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Student> javaPQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String order = scanner.next();
            if (order.equals("ENTER")) {
                String name = scanner.next();
                String temp = scanner.next();
                Double CGPA = Double.parseDouble(temp);
                int id = scanner.nextInt();
                javaPQ.add(new Student(name, CGPA, id));
            } else {
                javaPQ.poll();
            }
        }
        if (javaPQ.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!javaPQ.isEmpty()) {
                System.out.println(javaPQ.poll().name);
            }
        }
    }
}