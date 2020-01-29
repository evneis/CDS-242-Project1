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
        if(i > n || i < 0)
            throw new IndexOutOfBoundsException();
        if(i < n/2) {
            int j = 0;
            Node<T> addNode = new Node<>();
            addNode.x = x;
            for (Node<T> cur = dummy.next; cur.next != dummy; cur = cur.next) {
                if (j == i) {
                    cur.prev.next = addNode;
                    cur.next.prev = addNode;
                    addNode.prev = cur.prev;
                    addNode.next = cur.next;
                    break;
                }
                j++;
            }
            n++;
        }
        if(i >= n/2){
            int j = 0;
            Node<T> addNode = new Node<>();
            addNode.x = x;
            for (Node<T> cur = dummy.prev; cur.prev != dummy; cur = cur.prev) {
                if (j == i) {
                    cur.prev.next = addNode;
                    cur.next.prev = addNode;
                    addNode.prev = cur.prev;
                    addNode.next = cur.next;
                    break;
                }
                j++;
            }
            n++;
        }
        return true;
    }

    @Override
    public void set(int i, T x) {
        if(i > n || i < 0)
            throw new IndexOutOfBoundsException();
        if(i < n/2) {
            int j = 0;
            for (Node<T> cur = dummy.next; cur.next != null; cur = cur.next) {
                if (j == i) {
                    cur.x = x;
                }
                j++;
            }
        }
        else if(i >= n/2){
            int j = 0;
            for (Node<T> cur = dummy.prev; cur.prev != null; cur = cur.prev) {
                if (j == i) {
                    cur.x = x;
                }
                j++;
            }
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
        add(0, x);
        return true;
    }

    @Override
    public boolean addBack(T x) {
//        Node<T> addNode = new Node<>();
//        addNode.x = x;
//        addNode.prev = dummy.prev;
//        dummy.prev = addNode;
//        addNode.next = dummy;
//        addNode.prev.next = addNode;
//        n++;
        add(n, x);
        return true;

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
