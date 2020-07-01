import java.util.Objects;

//Invariants:
//nextFirst: index to add new element at front
//nextLast: index to add new item at back
public class ArrayDeque<T> implements Deque<T> {
    public T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T []) new Object[8];
        nextFirst = 0;
        nextLast=1;
        size = 0;
    }

    private void resize(int cap) {
        T[] a = (T []) new Objects[cap];
        System.arraycopy(items, 0, a, 0,size);
        items = a;
    }
    @Override
    public void addFirst(T x){
        if (size == items.length){
            resize(size*2);
        }
        items[nextFirst] = x;
        nextFirst = (nextFirst-1+items.length) % items.length;
        size+=1;
    }
    @Override
    public void addLast(T x){
        if (size == items.length){
            resize(size*2);
        }
        items[nextLast] = x;
        nextLast = (nextLast+1) % items.length;
        size+=1;
    }
    @Override
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        return false;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque(){
        for (int i = 0; i<items.length-1; i++){
            System.out.print(items[i]+ " ");
        }
        System.out.println(items[items.length-1]);
    }
    @Override
    public T removeFirst() {
        nextFirst = (nextFirst + 1) % items.length;
        T item = items[nextFirst];
        items[nextFirst] = null;
        size -=1;
        return item;
    }
    @Override
    public T removeLast() {
        nextLast = (nextLast - 1 + items.length) % items.length;
        T item = items[nextLast];
        items[nextLast] = null;
        size -=1;
        return item;
    }
    @Override
    public T get(int index){
        return items[index];
    }





    public static void main(String[] args) {
        ArrayDeque p = new ArrayDeque();
        p.addFirst(1);
        p.addLast(2);
        p.addLast(3);
        p.printDeque();
        p.removeFirst();
        p.printDeque();
        p.removeLast();
        p.printDeque();
        //p.printDeque();
        /*for (int i=0; i< 8; i++) {
            System.out.println(p.items[i]);
        }
        System.out.println(p.size);
        p.printDeque();*/
    }






}
