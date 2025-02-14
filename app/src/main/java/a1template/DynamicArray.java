// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class DynamicArray<T> implements IndexAccess<T>{
    
    // What instance variables do you need?
    private T[] array;
    private int offset;
    private int low; //lowest valid index
    private int high; //heighest valid index

    // Write a constructor to make a new DynamicArray Object from an array
    @SuppressWarnings("unchecked")
    public DynamicArray(int len, T[] array){
        array = (T[])(new Object[len]);
        this.offset = 0;
        low = 0;
        high = len-1;
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(DynamicArray<T> orig){
        array = (T[])(new Object[orig.array.length]);
        offset = orig.offset;
        low = orig.low;
        high = orig.high;
        for (int i = low; i <= high; i++){
            set(i, orig.get(i));
        }
    }

    // Now implement the methods from IndexAccess?
    //get, set
    public T get(int i){
        if (i < 0 || i > high) {
            throw new ArrayIndexOutOfBoundsException(i);
        }else{
            return array[i+offset];
        }
    }

    public T get(int i, int offset){
        int newIndex = i + offset;
        if (newIndex < 0 || newIndex > high) {
            throw new ArrayIndexOutOfBoundsException(newIndex);
        }else{
            return array[newIndex];
        }
    }
    
    public void set(int i, T value){
        if (i < 0 || i >= high) {
            throw new ArrayIndexOutOfBoundsException(i);
        }else{
            array[i+offset] = value;
        }
    }


}