public class LinkedListDeque<T> {
    public class Node {
        private T item;
        private Node pre;
        private Node next;

        /** constructor for Node. */
        public Node(T n, Node ppre, Node nnext){
            item = n;
            pre = ppre;
            next = nnext;
        }

        /** constructor for Node.(especially for sentinel node). */
        public Node(Node ppre, Node nnext){
            pre = ppre;
            next = nnext;
        }
    }
    /** sentinel node. */
    private Node sentinel;
    /** size of the deque. */
    private int size;

    /** constructor for Node. */
    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }


    public void addFirst(T item) {
        Node newList = new Node(item, sentinel, sentinel);
        sentinel.next.pre = newList;
        sentinel.next = newList;
        size++;
    }

    public void addLast(T item) {
        Node newList = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newList;
        sentinel.pre = newList;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    /** 从当前哨兵节点的下一个节点循环，如果不为null就打印. */
    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return item;
    }

    public T removeLast() {
        if (size == 0){
            return null;
        }

        T item = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return item;
    }

    public T get(int index) {
        if (index > size) {
            return null;
        }
        // 如果不是从哨兵节点开始，那么第一个节点会被跳过
        Node ptr = sentinel;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    private T getRecursiveHelp(Node start, int index){
        // base case
        if (index ==0) {
            return start.item;
        }
        return getRecursiveHelp(start.next, index -1);
    }


    public T getRecursive(int index) {
        if (index > size) {
            return  null;
        }

        return getRecursiveHelp(sentinel.next, index);
    }
}

