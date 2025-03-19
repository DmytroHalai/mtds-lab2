import com.example.java.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void testDoublyLinkedList(){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        assertNull(doublyLinkedList.head, "Head must be null");
        assertNull(doublyLinkedList.tail, "Tail must be null");
    }

    @Test
    void testLength(){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        int result = doublyLinkedList.length();
        assertEquals(0, result, "Empty list's length must be 0");

        doublyLinkedList.append('1');
        doublyLinkedList.append('1');
        doublyLinkedList.append('1');
        doublyLinkedList.append('1');
        result = doublyLinkedList.length();
        assertEquals(4, result, "Length of list of 4 elements must be 4");
    }

    @Test
    void testAppend(){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        assertEquals(1, doublyLinkedList.length(), "Length must be 1");

        doublyLinkedList.append('2');
        assertEquals(2, doublyLinkedList.length(), "Length must be 2");
        assertEquals('1', doublyLinkedList.head.data, "Head data must be '1'");
        assertEquals('2', doublyLinkedList.tail.data, "Tail data must be '2'");
    }

    @Test
    void testInsert() throws Exception {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insert('1', 0);
        assertEquals(1, doublyLinkedList.length(), "Length must be 1");
        assertEquals('1', doublyLinkedList.head.data, "Head data must be 1");

        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.insert('2', 3));
    }
}
