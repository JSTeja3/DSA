import java.util.Objects;

public class DynamicArray<T>{


    private static final int DEFAULT_CAPACITY = 10;

    private T[] arr;
    private int size;


    @SuppressWarnings("unchecked")
    public DynamicArray(){
        size = 0;
        arr = (T[])  new Object[DEFAULT_CAPACITY];
    }


    //Return size of Array
    public int size(){
        return size;
    }

    //Check is array is empty
    public boolean isEmpty(){
        return size==0;
    }


    //Add value to dynamic array
    public void add(T value){
        if(size == arr.length){
            resize();
        }

        arr[size++] = value;
    }

    //Remove by index
    public void remove(int index){
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
        for(int i=index; i<size-1; i++){
            arr[i] = arr[i+1];
        }
        arr[size-1] = null;
        size--;
    }

    //Get the value by index
    public T get(int index){
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
        return arr[index];
    }

    //Set value by index
    public void set(int index, T value){
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
        arr[index] = value;
    }

    //Resize the array
    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp  = (T[])  new Object[(arr.length*2)];
        for(int i=0; i<size; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    //Insert value at index
    public void insert(int index, T value){
        if(index < 0 || index >size){
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
        if(size == arr.length){
            resize();
        }
        for(int i=size ; i>index; i--){
            arr[i] = arr[i-1]; 
        }
        arr[index] = value;
        size++;
    }

    //Checks if value is present in array
    public boolean contains(T value){
        return indexOf(value) != -1;
    }

    //Returns first index of value if present in array
    public int indexOf(T value){
        for(int i=0; i<size; i++){
            if(Objects.equals(arr[i], value)){
                return i;
            }
        }
        return -1;
    }

    //Removes all values from array
    public void clear(){
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    //Convert array values to string
    public String toString(){
        if (size == 0) {
            return "[]";
        }
        
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(arr[i]);
            if (i != size - 1) {
                result.append(", ");
            }

        }
        result.append("]");
        return result.toString();
    }


}