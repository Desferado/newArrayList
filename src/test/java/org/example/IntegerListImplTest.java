package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.TestConstans.*;
import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    IntegerList integerList = new IntegerListImpl(integerList1);

    @Test
    void add() {
        Integer actual = integerList.add(SIZE);
        Assertions.assertEquals(SIZE, actual);
    }

    @Test
    void testAdd() {
        Integer actual = integerList.add(0,SIZE);
        Assertions.assertEquals(SIZE, actual);
    }

    @Test
    void set() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
    }

    @Test
    void testContains() {
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
}