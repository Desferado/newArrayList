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
    void shouldReturnItemWhenAddItemByIndex() {
        String actual = stringList.add(0, STR1);
        Assertions.assertEquals(STR1,actual);
    }

    @Test
    void shouldReturnItemWhenSetItemByIndex() {
        String actual = stringList.set(0, STR1);
        Assertions.assertEquals(STR1,actual);
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

//    @Test
//    void indexOf() {
//    }
//
//    @Test
//    void lastIndexOf() {
//    }
//
//    @Test
//    void get() {
//    }
//
//    @Test
//    void testEquals() {
//    }
//
//    @Test
//    void size() {
    }


