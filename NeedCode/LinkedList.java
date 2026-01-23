package NeedCode;
import java.util.ArrayList;

class LinkedList {

    ArrayList<Integer> list = null;
    public LinkedList() {
        list = new ArrayList<>();
    }

    public int get(int index) {
        return (index < list.size()) ? list.get(index) : -1;
    }

    public void insertHead(int val) {
         list.add(0,val);
    }

    public void insertTail(int val) {
        list.add(val);
    }

    public boolean remove(int index) {
        return (index < list.size()) ? list.remove(list.get(index)) : false;
    }

    public ArrayList<Integer> getValues() {
        return list;
    }
}
