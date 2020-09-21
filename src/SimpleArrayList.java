import java.util.List;

public class SimpleArrayList {

    String[] items;
    public static int size;
    public static final int capacity = 10;

    public SimpleArrayList() {
        items = new String[capacity];
        size = 0;
    }

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        items = new String[initialCapacity];
        size = 0;
    }

    public SimpleArrayList (List<String> list) {
        if (list == null) throw new NullPointerException();
        items = new String[list.size()];
        items = list.toArray(items);
        size = items.length;
    }

    public void add(int index, String s) {
        if(size + 1 > items.length) {
            String[] temp = new String[items.length+capacity];
            for(int i = 0; i < items.length; i++) {
                temp[i] = items[i];
            }

            items = temp;
        }

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", " + "Size: " + size);
        }

        for(int i = items.length-2; i > index-1; i--) {
            items[i+1] = items[i];
        }
        items[index] = s;
        size ++;
    }

    public boolean add(String s) {
        if(size+1 > items.length) {
            String[] temp = new String[items.length+capacity];
            for(int i = 0; i < items.length; i++) {
                temp[i] = items[i];
            }

            items = temp;
        }

        items[size] = s;
        size ++;
        return true;
    }

    public void clear() {
        size = 0;
        items = new String[capacity];
        items[0] = null;
    }

    public boolean contains(String s) {
        int x = indexOf(s);
        if (x == -1) {
            return false;
        }

        return true;
    }

    public String get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds at " + size);
        }

        return items[index];
    }

    public int indexOf(String s) {
        for (int i = 0; i < size; i++) {
            if (items[i] == s) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public String remove (int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds at " + size);
        }

        String removed = items[index];
        for (int i = index; i < size-1; i++) {
            items[i] = items[i+1];
        }
        items[size -1] = null;
        size --;
        return removed;
    }

    public boolean remove(String s) {
        int index = indexOf(s);
        if(index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public String set(int index, String s) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds at " + size);
        }

        String previousItem = items[index];
        items[index] = s;
        return previousItem;
    }

    public int size() {
        return size;
    }

    public void trimToSize() {
        String[] temp = new String[size];
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public String toString() {
        String values = "" ;
        for (int i = 0; i < size -1; i++) {
            values += items[i];
            values += ", ";
        }
        if (size != 0) {
            values += items[size -1];
        }
        String finalString = "[" + values + "]";
        return finalString;
    }
}