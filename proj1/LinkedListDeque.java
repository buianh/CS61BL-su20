class LinkedListDeque<T> {
    public T item;
    public  LinkedListDeque next;

    //Constructs a LinkedList Deque to store item and next
    public LinkedListDeque(T item, LinkedListDeque next) {
        this.item = item;
        this.next = next;
    }

    public LinkedListDeque (T item) {
        this(item,null);
    }

    public void addFirst(T item) {
        this.next = this;
        this.item = item;
    }
}