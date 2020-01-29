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

    public void print(){
        Node<T> cur = dummy.next;
        for(int i = 0; i < n; i++){
            System.out.println(cur.x);
        }
    }
    @Override
    public boolean add(int i, T x) {
        if(i > n || i < 0)
            throw new IndexOutOfBoundsException();
        Node<T> addNode = new Node<>();
        addNode.x = x;
        if(i == 1 && n == 1){
            dummy.prev = addNode;
            addNode.next = dummy;
            addNode.prev = dummy.next;
            dummy.next.next = addNode;
        }
        if(i >= n/2){
            Node<T> p = dummy.prev;
            for(int j = n; j > i; j--){
                p = p.prev;
            }
            addNode.next = p;
            addNode.prev = p.prev;
            p.prev.next = addNode;
            p.prev = addNode;


            n++;
            return true;
        }
        else if(i < n/2){
            Node<T> p = dummy.next;
            for(int j = 0; j < i; j++){
                p = p.next;
            }
            addNode.next = p;
            addNode.prev = p.prev;
            p.prev.next = addNode;
            p.prev = addNode;
            n++;
            return true;
        }
        return false;
    }

    @Override
    public void set(int i, T x) {
        if(i > n || i < 0)
            throw new IndexOutOfBoundsException();
        Node<T> p;
        if(i < n/2) {
            p = dummy.next;
            for (int j = 0; j < i; j++) {
                p = p.next;
            }
            p.x = x;
        }
        else if(i >= n/2){
            p = dummy.prev;
            for (int j = n; j > i; j--) {
                p = p.prev;
            }
            p.x = x;
        }
    }

    @Override
    public T remove(int i) {
        if(i >= n/2){
            Node<T> p = dummy.prev;
            for(int j = 0; j < i; j++){
                p = p.prev;
            }
            p.prev.next = p.next;
            p.next.prev = p.prev;
            n--;
            return p.x;
        }
        else if(i < n/2){
            Node<T> p = dummy.next;
            for(int j = 0; j < i; j++){
                p = p.next;
            }
            p.prev.next = p.next;
            p.next.prev = p.prev;
            n--;
            return p.x;
        }
        return null;
    }

    @Override
    public boolean addFront(T x) {
        return add(0, x);
    }

    @Override
    public boolean addBack(T x) {
        return add(n, x);

    }

    @Override
    public T removeFront() {
       return remove(0);
    }

    @Override
    public T removeBack() {
        return remove(n);
    }

    @Override
    public T find(T x) {
        Node<T> p = dummy.next;
        for(int i = 0; i < n; i++){
            System.out.println(p.x);
            if(p.x == x)
                return p.x;
            p = p.next;
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
        dummy.next = dummy;
        dummy.prev = dummy;
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
