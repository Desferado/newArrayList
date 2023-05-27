package org.example;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList{
    public String item;
    public int length ;
    public int number = 0;
    private String [] stringArray;

    public StringListImpl(int length){
        this.length = length;
        this.stringArray = new String[length];
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "stringArray=" + Arrays.toString(stringArray) +
                '}';
    }

    @Override
    public String add(String item) {
        if (item==null) {
            throw new NullPointerException();
        }
        if(number == stringArray.length){
          String [] stringArray2 = new String[stringArray.length*2];
            System.arraycopy(stringArray, 0, stringArray2, 0, stringArray.length);
            stringArray = stringArray2;
        }
        stringArray[number] = item;
        number++;
         return item;
    }

    @Override
    public String add(int index, String item) {
        if (item==null||index<0||index >= stringArray.length) {
            throw new NullPointerException();
        }
        for (int i = stringArray.length-1; i >= index; i--) {
            String[] stringArray2 = new String[stringArray.length * 2];
            System.arraycopy(stringArray, 0, stringArray2, 0, stringArray.length);
            stringArray = stringArray2;
            stringArray[i + 1] = stringArray[i];
        }
        stringArray[index] = item;
        number++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item==null||index<0||index >= stringArray.length) {
            throw new NullPointerException();
        }
        if (index > stringArray.length-1){
            throw new ArrayIndexOutOfBoundsException();
        }
        stringArray[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null ||Arrays.stream(stringArray).noneMatch(i -> Objects.equals(i, item))) {
            throw new NullPointerException();
        }
        if(Arrays.stream(stringArray).anyMatch(i -> Objects.equals(i, item))){
            int num = 0;
            for (int i = 0; i <= stringArray.length-1; i++) {
                if(Objects.equals(stringArray[i], item)) {
                    num = i;
                    for (int j = num; j <= stringArray.length-2; j++) {
                        stringArray[j] = stringArray[j + 1];
                        if (j == stringArray.length) {
                            stringArray[j] = null;
                        }
                    }
                }
            }
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index < 0 ||stringArray[index] == null){
            throw new NullPointerException();
        }
        item = stringArray[index];
        for (int j = index; j <= stringArray.length-2; j++) {
            stringArray[j] = stringArray[j + 1];
            if (j == stringArray.length) {
                stringArray[j] = null;
            }
        }
       return item;
    }

    @Override
    public boolean contains(String item) {
        if (item==null) {
            throw new NullPointerException();
        }
        return Arrays.stream(stringArray).anyMatch(i -> Objects.equals(i, item));
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < stringArray.length; i++) {
                if (item.equals(stringArray[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        int lastIndex = -1;
        if (item == null) {
            for (int i = 0; i < stringArray.length; i++) {
                if (stringArray[i] == null) {
                    lastIndex = i;
                }
            }
            return lastIndex;
        } else {
            for (int i = 0; i < stringArray.length; i++) {
                if (item.equals(stringArray[i])) {
                    lastIndex = i;
                }
            }
        }
        return lastIndex;
    }

    @Override
    public String get(int index) {
        if (index < 0){
            throw new NullPointerException();
        }
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
        for (int i = 0; i < stringArray.length-1; i++) {
            if(stringArray[i] != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(stringArray, null);
    }

    @Override
    public String[] toArray() {
        String[] stringArray2 = new String[stringArray.length];
        System.arraycopy(stringArray, 0, stringArray2, 0, stringArray.length);
        return stringArray2;
    }
}

