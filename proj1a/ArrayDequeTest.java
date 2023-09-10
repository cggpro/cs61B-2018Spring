import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> newArray = new ArrayDeque<>();
        newArray.addFirst(5);
        newArray.addFirst(4);
        newArray.addFirst(3);
        newArray.addFirst(2);
        newArray.addFirst(1);
    }

    @Test
    public void removeFirstTest() {
        ArrayDeque<Integer> newArray = new ArrayDeque<>();
        newArray.addFirst(3);
        newArray.addFirst(2);
        newArray.addFirst(1);
        int item =  newArray.removeFirst();
        System.out.println(item);
    }



    @Test
    public void removeLastTest() {
        ArrayDeque<Integer> newArray = new ArrayDeque<>();
        newArray.addFirst(3);
        newArray.addFirst(2);
        newArray.addFirst(1);
        int item =  newArray.removeLast();
        System.out.println(item);
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> newArray = new ArrayDeque<>();
        newArray.addFirst(3);
        newArray.addFirst(2);
        newArray.addFirst(1);
        int item =  newArray.get(2);
        System.out.println(item);
    }
}

