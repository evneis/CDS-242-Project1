public class Main {
    public static void main(String[] args) {

        DLList<Integer> two = new DLList<>();
        two.add(0, 0);
        two.add(1, 1);
        two.add(2, 2);
        two.add(3, 3);
        two.add(2, 99);
        two.addBack(45);
        two.addFront(46);
        two.set(0, 47);
        System.out.println(two.find(98765));
    }
}