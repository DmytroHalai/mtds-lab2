import com.example.java.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublyLinkedListTest {

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
}
