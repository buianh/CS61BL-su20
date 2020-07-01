class LinkedListDeque<T> implements Deque<T> {

    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    //The first item is at sentinel.next; the last item
    //is at sentinel.prev
    private Node sentinel;
    private int size;

    //An empty LLD
    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        sentinel.next =sentinel;
        sentinel.prev=sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new Node(null,null, null);
        Node firstNode = new Node(item,sentinel,sentinel);
        sentinel.next = firstNode;
        sentinel.prev = firstNode;
        size = 1;
    }

    //method to add item to front of Deque
    @Override
    public void addFirst(T item){
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next = newNode;
        newNode.next.prev = newNode;
        size += 1;
    }


    //method to add item last
    @Override
    public void addLast(T item){
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev = newNode;
        newNode.prev.next = newNode;
        size += 1;
    }
    @Override
    public boolean isEmpty() {
        if (this.sentinel.next==sentinel && this.sentinel.prev==sentinel){
            return true;
        }
        return false;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        Node newNode = sentinel.next;

        while (newNode != sentinel && newNode.next!=sentinel) {
            System.out.print(newNode.item+ " ");
            newNode = newNode.next;
        }
        System.out.println(newNode.item);
    }
    @Override
    public T removeFirst(){
        if (this.size() == 0){
            return null;
        }
        Node oldNode = sentinel.next;
        sentinel.next = oldNode.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return oldNode.item;
    }
    @Override
    public T removeLast(){
        if (this.size() == 0){
            return null;
        }
        Node oldNode = sentinel.prev;
        sentinel.prev= oldNode.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return oldNode.item;

    }
    @Override
    public T get(int index){
        Node newNode = sentinel.next;
        while (index > 0) {
            newNode = newNode.next;
            index -= 1;
        }
        return newNode.item;
    }

    public T getRecursive(int index) {
        Node newNode = sentinel;
        if (index == 0) {
            return newNode.next.item;
        } else {
        newNode = newNode.next;
        index -=1;
        return getRecursive(index);
        }

    }

    public static void main(String arg[]){
        LinkedListDeque p = new LinkedListDeque(2);
        p.addFirst(3);
        p.printDeque();
        System.out.println(p.get(0));
        System.out.println(p.getRecursive(0));

    }

}