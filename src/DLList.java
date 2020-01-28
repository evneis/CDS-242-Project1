public class DLList<T> implements List<T> {

    private int n;

    private class Node<T>{
        T x;
        Node<T> next, prev;

        public Node(T x, Node<T> next, Node<T> prev){
            this.x = x;
            this.next = next;
            this.prev = prev;
        }

        public Node(){
            this.x = null;
            this.next = null;
            this.prev = null;
        }
    }
    private Node<T> dummy;

    public DLList(){
        dummy = new Node<>();
        dummy.prev = dummy;
        dummy.next = dummy;
        n = 0;
    }
    @Override
    public boolean add(int i, T x) {
        int j = 0;
        Node<T> addNode = new Node<>();
        addNode.x = x;
        for(Node<T> cur = dummy.next; dummy.next != dummy; cur = cur.next){
            if(j == i){
                cur.prev.next = addNode;
                cur.next.prev = addNode;
                addNode.prev = cur.prev;
                addNode.next = cur.next;
            }
            j++;
        }
        n++;
        return true;
    }

    @Override
    public void set(int i, T x) {
        int j = 0;
        for(Node<T> cur = dummy.next; cur.next != null; cur = cur.next){
            if(j == i){
                cur.x = x;
            }
            j++;
        }
    }

    @Override
    public T remove(int i) {
        return null;
    }

    @Override
    public boolean addFront(T x) {
        Node<T> addNode = new Node<>();
        addNode.x = x;
        addNode.next = dummy.next;
        dummy.next = addNode;
        addNode.prev = dummy;
        n++;
        return true;
    }

    @Override
    public boolean addBack(T x) {
        Node<T> addNode = new Node<>();
        addNode.x = x;
        addNode.prev = dummy.prev;
        dummy.prev = addNode;
        addNode.next = dummy;
        n++;
        return true;

    }

    @Override
    public T removeFront() {
        T oldx = dummy.next.x;
        dummy.next = dummy.next.next;
        n--;
        return oldx;
    }

    @Override
    public T removeBack() {
        T oldx = dummy.prev.x;
        dummy.prev = dummy.prev.prev;
        n--;
        return oldx;
    }

    @Override
    public T find(T x) {
        for(Node<T> cur = dummy; cur.next != dummy; cur = cur.next){
            if(cur.x == x)
                return cur.x;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if(n == 0) { return true;}
        else {return false;}
    }

    @Override
    public int size() {return n;}

    @Override
    public void clear() {
        
    }

    @Override
    public void zip(List<T> other) {

    }

    @Override
    public void removeDuplicates() {

    }

    @Override
    public void concatenate(List<T> other) {

    }

    @Override
    public List<T> prefix(int i) {
        return null;
    }

    @Override
    public void promote(int i) {

    }

    @Override
    public void diff(List<T> A, List<T> B) {

    }
}
