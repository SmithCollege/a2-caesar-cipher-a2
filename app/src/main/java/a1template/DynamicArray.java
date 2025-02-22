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
    public DynamicArray(int offset, T[] inputArray){
        array = (T[])(new Object[inputArray.length]);
        this.offset = offset;
        low = 0;
        high = inputArray.length-1;
        for (int i = low; i <= high; i++){
            array[i] = inputArray[i];
        }
    }

    // Now implement the methods from IndexAccess?
    //get, set
    public T get(int i){
        if (i >= low || i <= high) {
            return array[i];
        }else{
            throw new ArrayIndexOutOfBoundsException(i);
        }
        
    }

    public T get(int i, int offset){
        int newIndex = i + offset;
        if (newIndex < 0 || newIndex > high) {
            throw new ArrayIndexOutOfBoundsException(newIndex);
        }
        return array[newIndex];
    }
    
    public void set(int i, T value){
        if (i < 0 || i >= high) {
            throw new ArrayIndexOutOfBoundsException(i);
        }else{
            array[i+offset] = value;
        }
    }


}