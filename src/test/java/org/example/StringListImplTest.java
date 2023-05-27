package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.example.TestConstans.*;

class StringListImplTest {
    StringList stringList = new StringListImpl(SIZE);

    @Test
    void shouldReturnItemWhenAddItem() {
        String actual = stringList.add(STR1);
        Assertions.assertEquals(STR1,actual);
    }
    @Test
    void shouldReturnExceptionWhenAddNull() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.add(STR_NULL));
    }

    @Test
    void shouldReturnItemWhenAddItemByIndex() {
        String actual = stringList.add(IND_POSITIVE, STR1);
        Assertions.assertEquals(STR1,actual);
    }

    @Test
    void shouldReturnExceptionWhenAddNullItemByIndex() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.add(IND_POSITIVE, STR_NULL));
    }
    @Test
    void shouldReturnExceptionWhenAddItemByNegativeIndex() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.add(IND_NEGATIVE, STR1));
    }
    @Test
    void shouldReturnExceptionWhenAddItemByIndexOverSize() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.add(OVER_SIZE, STR1));
    }

    @Test
    void shouldReturnItemWhenSetItemByIndex() {
        String actual = stringList.set(IND_POSITIVE, STR1);
        Assertions.assertEquals(STR1,actual);
    }
    @Test
    void shouldReturnExceptionWhenSetNullItemByIndex() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.set(IND_POSITIVE, STR_NULL));
    }
    @Test
    void shouldReturnExceptionWhenSetItemByNegativeIndex() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.set(IND_NEGATIVE, STR1));
    }
    @Test
    void shouldReturnExceptionWhenSetItemByIndexOverSize() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.set(OVER_SIZE, STR1));
    }

    @Test
    void shouldReturnItemWhenRemoveByItem() {
        stringList.add(STR1);
        String actual = stringList.remove(STR1);
        Assertions.assertEquals(STR1,actual);
    }
    @Test
    void shouldReturnItemWhenRemoveByIndex() {
        stringList.add(STR1);
        String actual = stringList.remove(0);
        Assertions.assertEquals(STR1,actual);
    }
    @Test
    void shouldReturnExceptionWhenRemoveByNullItem() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.remove(STR_NULL));
    }
    @Test
    void shouldReturnExceptionWhenRemoveByNegativeIndex() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.remove(IND_NEGATIVE));
    }

    @Test
    void shouldReturnTrueWhenContainsItem() {
        stringList.add(STR1);
        boolean actual = stringList.contains(STR1);
        Assertions.assertEquals(TRUE,actual);
    }
    @Test
    void shouldReturnFalseWhenNotContainsItem() {
        stringList.add(STR1);
        boolean actual = stringList.contains(STR2);
        Assertions.assertEquals(FALSE,actual);
    }
    @Test
    void shouldReturnExceptionContainsWhenNullItem() {
        Assertions.assertThrows(NullPointerException.class, () -> stringList.contains(STR_NULL));
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }
}