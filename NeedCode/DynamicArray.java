package NeedCode;

class DynamicArray {

    int [] array = null;
    int size = 0;

    public DynamicArray(int capacity) {
        array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == array.length) {
            resize();
        }
        array[size] = n;
        size++;
    }

    public int popback() {
        int result = array[size - 1];
        size--;
        return result;
    }

    public void resize() {
        int [] tempArray = new int[array.length * 2];
        for(int i = 0 ; i < array.length; i++){
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }
}