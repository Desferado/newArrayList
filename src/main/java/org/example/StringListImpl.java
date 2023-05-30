package org.example;

import java.util.Arrays;

public class StringListImpl implements StringList{
    public String item;
    public int size;

    private final String [] stringArray;

    public StringListImpl(int length){
        stringArray = new String[length];
    }
    public StringListImpl(){
        stringArray = new String[10];
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "stringArray=" + Arrays.toString(stringArray) +
                '}';
    }

    @Override
    public String add(String item) {
        validateItem(item);
        validateLength();
        stringArray[size++] = item;
         return item;
    }

    @Override
    public String add(int index, String item) {
        validateLength();
        validateIndex(index);
        validateItem(item);
        if(index == size){
            stringArray[size++] = item;
            return item;
        }
        System.arraycopy(stringArray, index, stringArray, index+1, size-index);
            stringArray[index] = item;
            size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        stringArray[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1){
            throw new ElementNotFoundException();
        }
        if (index!= size) {
            System.arraycopy(stringArray, index + 1, stringArray, index, size - index);
        }
        size--;

        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = stringArray[index];
        if (index!= size) {
            System.arraycopy(stringArray, index + 1, stringArray, index, size - index);
        }
        size--;
       return item;
    }

    @Override
    public boolean contains(String item) {
        if (item==null) {
            throw new NullPointerException();
        }
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(stringArray[i])) {
               return i;
            }
        }
    return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = size -1; i >= 0; i--) {
            if (item.equals(stringArray[i])) {
                return i;
            }
        }
    return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return stringArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        boolean  eq = false;
        boolean eq1 = true;
        int counter = 0;
        for (int i = 0; i < stringArray.length-1; i++) {
            if(stringArray[i] != null){
                counter++;
            }
        }
        if (counter != otherList.size()) {
            return false;
        }
        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i]!=null&&otherList.get(i)!=null){
                if (!stringArray[i].equals(otherList.get(i))) {
                  eq1 = false;
                } else {
                  eq = true;
                }
            }
        }
      return eq==eq1;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < stringArray.length-1; i++) {
            if(stringArray[i] != null){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] stringArray2 = new String[stringArray.length];
        System.arraycopy(stringArray, 0, stringArray2, 0, stringArray.length);
        return stringArray2;
    }
    private void validateItem(String item){
        if(item==null){
            throw new NullItemException();
        }
    }
    private void validateLength(){
        if(size == stringArray.length){
            throw new StringArrayFullException();
        }
    }
    private void validateIndex(int index){
        if(index<0||index> size){
            throw new InvalidIndexException();
        }
    }
}

