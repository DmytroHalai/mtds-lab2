import com.example.java.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void testDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        assertNull(doublyLinkedList.head, "Head must be null");
        assertNull(doublyLinkedList.tail, "Tail must be null");
    }

    @Test
    void testLength() {
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
    void testAppend() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        assertEquals(1, doublyLinkedList.length(), "Length must be 1");

        doublyLinkedList.append('2');
        assertEquals(2, doublyLinkedList.length(), "Length must be 2");
        assertEquals('1', doublyLinkedList.head.data, "Head data must be '1'");
        assertEquals('2', doublyLinkedList.tail.data, "Tail data must be '2'");
    }

    @Test
    void testInsert() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insert('1', 0);
        assertEquals(1, doublyLinkedList.length(), "Length must be 1");
        assertEquals('1', doublyLinkedList.head.data, "Head data must be 1");

        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.insert('2', 3));
    }

    @Test
    void testDelete() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        doublyLinkedList.append('2');
        doublyLinkedList.append('3');
        doublyLinkedList.append('4');
        doublyLinkedList.append('5');

        char deletedChar = doublyLinkedList.delete(2);
        assertEquals('3', deletedChar, "Deleted char must be '3'");
        assertEquals(4, doublyLinkedList.length(), "Length must be 4");
    }

    @Test
    void testDeleteAll() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        doublyLinkedList.append('2');
        doublyLinkedList.append('3');
        doublyLinkedList.append('4');
        doublyLinkedList.append('5');
        doublyLinkedList.append('2');
        doublyLinkedList.append('2');

        doublyLinkedList.deleteAll('2');
        assertEquals(4, doublyLinkedList.length(), "Length must be 4");

        doublyLinkedList.deleteAll('9');
        assertEquals(4, doublyLinkedList.length(), "Length must be 4");
    }

    @Test
    void testGet() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        doublyLinkedList.append('2');
        doublyLinkedList.append('3');
        doublyLinkedList.append('4');
        doublyLinkedList.append('5');

        assertEquals('3', doublyLinkedList.get(2), "Char under index 2 must be '3'");
        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.get(11));
    }

    @Test
    void testClone() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        DoublyLinkedList d2 = doublyLinkedList.clone();
        assertNull(d2.head);

        doublyLinkedList.append('1');
        doublyLinkedList.append('2');
        doublyLinkedList.append('3');
        doublyLinkedList.append('4');
        doublyLinkedList.append('5');

        d2 = doublyLinkedList.clone();
        assertEquals(5, d2.length());
    }

    @Test
    void testReverse(){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        doublyLinkedList.append('2');
        doublyLinkedList.append('3');
        doublyLinkedList.append('4');
        doublyLinkedList.append('5');

        doublyLinkedList.reverse();

        assertEquals('5', doublyLinkedList.head.data);
        assertEquals('1', doublyLinkedList.tail.data);
        assertEquals(5, doublyLinkedList.length());
    }

    @Test
    void testFindFirst() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        doublyLinkedList.append('2');
        doublyLinkedList.append('3');
        doublyLinkedList.append('4');
        doublyLinkedList.append('5');
        doublyLinkedList.append('5');
        doublyLinkedList.append('5');

        assertEquals(4, doublyLinkedList.findFirst('5'));
        assertEquals(-1, doublyLinkedList.findFirst('9'));
    }

    @Test
    void testFindLast() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        doublyLinkedList.append('2');
        doublyLinkedList.append('3');
        doublyLinkedList.append('4');
        doublyLinkedList.append('5');
        doublyLinkedList.append('1');
        doublyLinkedList.append('5');

        assertEquals(5, doublyLinkedList.findLast('1'));
        assertEquals(-1, doublyLinkedList.findLast('9'));
    }

    @Test
    void testClear() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        doublyLinkedList.append('2');
        doublyLinkedList.append('3');
        doublyLinkedList.append('4');
        doublyLinkedList.append('5');
        doublyLinkedList.append('1');
        doublyLinkedList.append('5');

        doublyLinkedList.clear();
        assertNull(doublyLinkedList.head);
        assertEquals(0, doublyLinkedList.length());
    }

    @Test
    void testExtend() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.append('1');
        doublyLinkedList.append('2');
        doublyLinkedList.append('3');
        doublyLinkedList.append('4');
        doublyLinkedList.append('5');
        doublyLinkedList.append('1');
        doublyLinkedList.append('5');

        DoublyLinkedList doublyLinkedList1 = new DoublyLinkedList();

        doublyLinkedList.extend(doublyLinkedList1);
        assertEquals(7, doublyLinkedList.length());
        assertEquals('4', doublyLinkedList.tail.data);

        doublyLinkedList1.append('2');
        doublyLinkedList1.append('2');
        doublyLinkedList1.append('2');
        doublyLinkedList1.append('2');
        doublyLinkedList1.append('2');

        doublyLinkedList.extend(doublyLinkedList1);

        assertEquals(12, doublyLinkedList.length());
        assertEquals('2', doublyLinkedList.tail.data);
    }

}
