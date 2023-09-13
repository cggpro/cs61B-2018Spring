public class ArrayDeque<T> {
    /** sava array data. */
    private T[] array;

    /** size of the deque. */
    private int size;

    /** size of the array. */
    private int length;

    /** front index. */
    private int front;

    /** last index. */
    private int last;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        length = 8;
        front = 4;
        last = 4;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    /** return the "index - 1". */
    private int minusOne(int index) {
        if (index == 0) {
            return length -1;
        }
        return index - 1;
    }


    /** return the "index + 1". */
    private int plusOne(int index, int module) {
        index %= module;
        if (index == module - 1) {
            return 0;
        }
        return index + 1;
    }

    /** 扩容数组 length*2. */
    private void grow() {
        T[] newArray = (T[]) new Object[length * 2];
        int pt1 = front;
        int pt2 = length;

        while (pt1 != last) {
            newArray[pt2] = array[pt1];
            pt1 = plusOne(pt1, length);
            pt2 = plusOne(pt2, length * 2);
        }

        front = length;
        last = pt2;
        array = newArray;
        length *= 2;
    }

    /** 缩小数组 数组使用率低于25%则缩小数组长度为原来的一半 */
    private void shrink() {
        T[] newArray = (T[]) new Object[length / 2];
        int ptr1 = front;
        int ptr2 = length / 4;
        while (ptr1 != last) {
            newArray[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length / 2);
        }
        front = length / 4;
        last = ptr2;
        array = newArray;
        length /= 2;
    }



    /** add one item at the front of the deque.
     * @param item the item we want to add
     */
    public void addFirst(T item){
        if (size == array.length - 1) {
            grow();
        }

        front = minusOne(front);
        array[front] = item;
        size++;
    }

    /**
     * add one item at the last of the deque.
     * @param item the item we want to add
     */
    public void addLast(T item) {
        if (size == array.length - 1) {
            grow();
        }

        array[last] = item;
        last = plusOne(last, length);
        size++;
    }


    /**
     * remove one item at the first of the deque.
     * @return the removed first item
     */
    public T removeFirst() {
        if (length > 16 && length / size >= 4) {
            shrink();
        }

        if (size == 0) {
            return null;
        }
        T ret = array[front];
        front = plusOne(front, length);
        size--;
        return ret;
    }


    public T removeLast() {
        if (length > 16 && length / size >= 4) {
            shrink();
        }

        if (size == 0) {
            return null;
        }

        last = minusOne(last);
        size--;
        return array[last];
    }

    public T get(int index) {

        int ptr = front;
        for (int i = 0; i < index; i++) {
            ptr = plusOne(ptr, length);
        }
        return array[ptr];
    }

    public void printDeque() {
        int ptr = front;
        while (ptr != last) {
            System.out.println(array[ptr]);
            ptr = plusOne(ptr, length);
        }
    }
}

