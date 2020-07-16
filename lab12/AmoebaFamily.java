import java.util.*;

/* An AmoebaFamily is a tree, where nodes are Amoebas, each of which can have
   any number of children. */
public class AmoebaFamily implements Iterable<AmoebaFamily.Amoeba> {

    /* ROOT is the root amoeba of this AmoebaFamily */
    private Amoeba root = null;

    /* Creates an AmoebaFamily, where the first Amoeba's name is NAME. */
    public AmoebaFamily(String name) {
        root = new Amoeba(name, null);
    }

    /* Adds a new Amoeba with CHILDNAME to this AmoebaFamily as the youngest
       child of the Amoeba named PARENTNAME. This AmoebaFamily must contain an
       Amoeba named PARENTNAME. */
    public void addChild(String parentName, String childName) {
        if (root != null) {
            root.addChildHelper(parentName, childName);
        }
    }

    /* Prints the name of all Amoebas in this AmoebaFamily in preorder, with
       the ROOT Amoeba printed first. Each Amoeba should be indented four spaces
       more than its parent. */
    public void print() {
        // TODO: YOUR CODE HERE
        System.out.println(root.name);
        for (Amoeba a : root.children) {
            a.printHelper(0);
        }
    }

    /* Returns the length of the longest name in this AmoebaFamily. */
    public int longestNameLength() {
        if (root != null) {
            return root.longestNameLengthHelper();
        }
        return 0;
    }

    /* Returns the longest name in this AmoebaFamily. */
    public String longestName() {
        // TODO: YOUR CODE HERE
        return root.longestNamehelper();
    }

    /* Returns an Iterator for this AmoebaFamily. */
    public Iterator<Amoeba> iterator() {
        return new AmoebaDFSIterator();
    }

    public Iterator<Amoeba> bfsiterator() {
        return new AmoebaBFSIterator();
    }

    /* Creates a new AmoebaFamily and prints it out. */
    public static void main(String[] args) {
        AmoebaFamily family = new AmoebaFamily("Amos McCoy");
        family.addChild("Amos McCoy", "mom/dad");
        family.addChild("Amos McCoy", "auntie");
        family.addChild("mom/dad", "me");
        family.addChild("mom/dad", "Fred");
        family.addChild("mom/dad", "Wilma");
        family.addChild("me", "Mike");
        family.addChild("me", "Homer");
        family.addChild("me", "Marge");
        family.addChild("Mike", "Bart");
        family.addChild("Mike", "Lisa");
        family.addChild("Marge", "Bill");
        family.addChild("Marge", "Hilary");
        System.out.println("Here's the family:");
        family.print();
        System.out.println(family.longestName());
        System.out.println(family.longestNameLength());
        AmoebaDFSIterator dfs = (AmoebaDFSIterator) family.iterator();
        while (dfs.hasNext()) {
            Amoeba x = dfs.next();
            System.out.println(x);
        }
        AmoebaBFSIterator bfs = (AmoebaBFSIterator) family.bfsiterator();
        while (bfs.hasNext()) {
            Amoeba x = bfs.next();
            System.out.println(x);
        }

    }

    /* An Amoeba is a node of an AmoebaFamily. */
    public static class Amoeba {

        private String name;
        private Amoeba parent;
        private ArrayList<Amoeba> children;

        public Amoeba(String name, Amoeba parent) {
            this.name = name;
            this.parent = parent;
            this.children = new ArrayList<Amoeba>();
        }

        public String toString() {
            return name;
        }

        public Amoeba getParent() {
            return parent;
        }

        public ArrayList<Amoeba> getChildren() {
            return children;
        }

        /* Adds child with name CHILDNAME to an Amoeba with name PARENTNAME. */
        public void addChildHelper(String parentName, String childName) {
            if (name.equals(parentName)) {
                Amoeba child = new Amoeba(childName, this);
                children.add(child);
            } else {
                for (Amoeba a : children) {
                    a.addChildHelper(parentName, childName);
                }
            }
        }

        /* Returns the length of the longest name between this Amoeba and its
           children. */
        public int longestNameLengthHelper() {
            int maxLengthSeen = name.length();
            for (Amoeba a : children) {
                maxLengthSeen = Math.max(maxLengthSeen,
                                         a.longestNameLengthHelper());
            }
            return maxLengthSeen;
        }

        // TODO: ADD HELPER FUNCTIONS HERE
        public void printHelper(int i) {
            for (int j = 0; j <= i; j++) {
                System.out.print("    ");
            }
            System.out.println(this.name);
            for (Amoeba a : children) {
                a.printHelper(i + 1);
            }
        }

        public String longestNamehelper() {
            String name_output = name;
            for (Amoeba a: children){
                if (a.longestNamehelper().length()>name.length()){
                    name_output=a.longestNamehelper();
                }
            }
            return name_output;
        }

    }

    /* An Iterator class for the AmoebaFamily, running a DFS traversal on the
       AmoebaFamily. Complete enumeration of a family of N Amoebas should take
       O(N) operations. */
    public class AmoebaDFSIterator implements Iterator<Amoeba> {

        // TODO: IMPLEMENT THE CLASS HERE
        private Stack<Amoeba> fringe = new Stack<Amoeba>();

        /* AmoebaDFSIterator constructor. Sets up all of the initial information
           for the AmoebaDFSIterator. */
        public AmoebaDFSIterator() {
            if (root != null) {
                fringe.push(root);
            }
        }

        /* Returns true if there is a next element to return. */
        public boolean hasNext() {
            return !fringe.isEmpty();
        }

        /* Returns the next element. */
        public Amoeba next() {
            if (!hasNext()){
                throw new NoSuchElementException("Amoeba Family runs out of elements");
            }
            Amoeba node = fringe.pop();
            for (int i = node.children.size() - 1; i >= 0; i--){
                fringe.push(node.children.get(i));
            }
            return node;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* An Iterator class for the AmoebaFamily, running a BFS traversal on the
       AmoebaFamily. Complete enumeration of a family of N Amoebas should take
       O(N) operations. */
    public class AmoebaBFSIterator implements Iterator<Amoeba> {

        // TODO: IMPLEMENT THE CLASS HERE
        private Queue<Amoeba> fringe = new LinkedList<>(
        );

        /* AmoebaBFSIterator constructor. Sets up all of the initial information
           for the AmoebaBFSIterator. */
        public AmoebaBFSIterator() {
            if (root != null) {
                fringe.add(root);
            }
            Amoeba root_new = root;
            for (Amoeba a: root_new.children) {
                fringe.add(a);
            }
        }

        /* Returns true if there is a next element to return. */
        public boolean hasNext() {
            return !fringe.isEmpty();
        }

        /* Returns the next element. */
        public Amoeba next() {
            if (!hasNext()){
                throw new NoSuchElementException("Amoeba Family runs out of elements");
            }
            Amoeba node = fringe.remove();
            return node;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
