package org.example;

import java.util.Arrays;
import java.util.Collections;

public class IntegerListImpl implements IntegerList{
    public Integer item;
    public int size;

    private Integer [] integerArray;

    public IntegerListImpl(int length){
        integerArray = new Integer[length];
    }
    public IntegerListImpl(Integer [] integerArray){
       this.integerArray = integerArray;
    }
    @Override
    public String toString() {
        return "StringListImpl{" +
                "stringArray=" + Arrays.toString(integerArray) +
                '}';
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        validateLength();
        integerArray[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateLength();
        validateIndex(index);
        validateItem(item);
        if(index == size){
            integerArray[size++] = item;
            return item;
        }
        System.arraycopy(integerArray, index, integerArray, index+1, size-index);
        integerArray[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integerArray[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1){
            throw new ElementNotFoundException();
        }
        if (index!= size) {
            System.arraycopy(integerArray, index + 1, integerArray, index, size - index);
        }
        size--;

        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = integerArray[index];
        if (index!= size) {
            System.arraycopy(integerArray, index + 1, integerArray, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item);
//        sortSelection(integerArray);
        quickSort(integerArray, 0, integerArray.length - 1);
        return contains(integerArray,item);
    }
    public static boolean contains (Integer [] arr, Integer element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(integerArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = size -1; i >= 0; i--) {
            if (item.equals(integerArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return integerArray[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        boolean  eq = false;
        boolean eq1 = true;
        int counter = 0;
        for (int i = 0; i < integerArray.length-1; i++) {
            if(integerArray[i] != null){
                counter++;
            }
        }
        if (counter != otherList.size()) {
            return false;
        }
        for (int i = 0; i < integerArray.length; i++) {
            if(integerArray[i]!=null&&otherList.get(i)!=null){
                if (!integerArray[i].equals(otherList.get(i))) {
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
        for (int i = 0; i < integerArray.length-1; i++) {
            if(integerArray[i] != null){
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
    public Integer [] toArray() {
        Integer[] integerArray2 = new Integer[integerArray.length];
        System.arraycopy(integerArray, 0, integerArray2, 0, integerArray.length);
        return integerArray2;
    }
    private void validateItem(Integer item){
        if(item==null){
            throw new NullItemException();
        }
    }
    private void validateLength(){
        if(size == integerArray.length){
            grow();
        }
    }
    private void validateIndex(int index){
        if(index<0||index > size){
            throw new InvalidIndexException();
        }
    }
    public static void sortBubble(Integer [] integerArray) {
        for (int i = 0; i < integerArray.length - 1; i++) {
            for (int j = 0; j < integerArray.length - 1 - i; j++) {
                if (integerArray[j] > integerArray[j + 1]) {
                    swapElements(integerArray, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(Integer [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }
    public static Integer [] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
    private static void swapElements (Integer [] integerArray, int index1, int index2) {
        Integer temp = integerArray[index1];
        integerArray[index1] = integerArray[index2];
        integerArray[index2] = temp;
    }
    private Integer [] grow(){
       integerArray = new Integer[integerArray.length + integerArray.length / 2];
        return integerArray;
    }
}
