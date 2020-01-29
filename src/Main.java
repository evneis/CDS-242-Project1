public class Main {
    public static void main(String[] args){
        DLList<Integer> testList = new DLList<>();

        testList.addFront(9);
        testList.addBack(120);
        testList.add(1, 130);
        System.out.println(testList.size());
        testList.removeBack();
        System.out.println(testList.size());
    }
}
