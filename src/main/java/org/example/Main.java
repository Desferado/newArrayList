package org.example;

public class Main {

    public static void main(String[] args) {
        StringList stringList = new StringListImpl(10);
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");
        stringList.add("six");
        stringList.add("five");
        stringList.add("one");
        stringList.add("two");

        stringList.set(2, "test");
        System.out.println(stringList);
        stringList.remove("five");
        System.out.println(stringList);
        stringList.remove(3);
        System.out.println(stringList);
        System.out.println(stringList.contains("test"));
        System.out.println(stringList.indexOf("six"));
        System.out.println(stringList.indexOf("nine"));
        System.out.println(stringList.lastIndexOf("one"));
        System.out.println(stringList.lastIndexOf("nine"));
        System.out.println(stringList.get(0));
        StringList otherList = new StringListImpl(10);
        otherList.add("one");
        otherList.add("two");
        otherList.add("test");
        otherList.add("six");
        otherList.add("one");
        otherList.add("two");
        System.out.println(otherList);
        System.out.println(otherList.size());
        System.out.println(stringList.size());
        System.out.println("stringList.equals(otherList) = " + stringList.equals(otherList));
        stringList.add("five");
        stringList.add("one");
        stringList.add("two");
        System.out.println(stringList.toString());
        StringList otherList2 = new StringListImpl(10);
        System.out.println(stringList.isEmpty());
        System.out.println(otherList2.isEmpty());
        stringList.clear();
        System.out.println(stringList);

    }
}