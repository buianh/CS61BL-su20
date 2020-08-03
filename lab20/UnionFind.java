public class UnionFind {

    /* TODO: Add instance variables here. */
    int[] djs;
    int capacity;

    /* Creates a UnionFind data structure holding N vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int N) {
        // TODO: YOUR CODE HERE
        capacity = N;
        djs = new int[capacity];
        for (int i=0;i<capacity;i++){
            djs[i]=-1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        // TODO: YOUR CODE HERE
        return -djs[find(v)];
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        // TODO: YOUR CODE HERE
        int parent = find(v);
        if (parent >= 0) {
            return parent;
        } else {
            return djs[parent];
        }
    }

    /* Returns true if nodes V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO: YOUR CODE HERE
        return find(v1)==find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid vertices are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        // TODO: YOUR CODE HERE
        if (v<0||v>=capacity){
            throw new IllegalArgumentException();
        }
        int parent = djs[v];
        if (parent < 0) {
            parent=v;
        }
        while (parent>=0){
            find(parent);
        }
        return parent;
    }

    /* Connects two elements V1 and V2 together. V1 and V2 can be any element,
       and a union-by-size heuristic is used. If the sizes of the sets are
       equal, tie break by connecting V1's root to V2's root. Union-ing a vertex
       with itself or vertices that are already connected should not change the
       structure. */
    public void union(int v1, int v2) {
        // TODO: YOUR CODE HERE
        if (!connected(v1,v2)){
            int v1_size = sizeOf(v1);
            int v2_size = sizeOf(v2);
            if (v1_size>= v2_size){
                djs[find(v2)]=find(v1);
                djs[find(v1)]-= sizeOf(v2);
            } else {
                djs[find(v1)]=find(v2);
                djs[find(v2)]-= sizeOf(v1);
            }
        }
    }
}
