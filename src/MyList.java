import java.util.Arrays;
public class MyList<T> {
    private T[] arr;
    private int capacity;
    private int size;

    MyList(){
        this.size = 0;
        this.capacity = 10;
        this.arr = (T[]) new Object[capacity];
    }

    MyList(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(T data){
        if(this.size < this.capacity){
            this.arr[this.size] = data;
            this.size++;
        }else{
            this.capacity *=2;
            System.out.println("Array capacity increase double due to not enough capacity!");
        }
    }

    public T get(int index){
        if(index > this.size){
            return null;
        }
        return this.arr[index];
    }

    public void remove(int index){
        for(int i = index; i < arr.length-1; i++){
            this.arr[i] = this.arr[i+1];
        }
        arr[arr.length-1] = null;
        size--;
    }


    public T set(int index, T data){
        return arr[index] = data;
    }

    public void print(){
        System.out.print("[ ");
        for (T t : arr) {
            if (t != null) {
                System.out.print(t + " ");
            }
        }
        System.out.print("]");

    }

    public int indexOf(T data){
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] == data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        int counter = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == data){
                counter = i;
            }
        }
        return counter;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public T[] toArray(){
        return Arrays.copyOf(arr,size);
    }

    public void clear(){
        arr = (T[]) new Object[10];
        size = 0;
    }

    public MyList<T> sublist(int start, int finish){
        MyList<T> subList = new MyList<>(finish-start+1);
        for(int i = start; i <=finish; i++){
            subList.add(this.get(i));
        }
        return subList;
    }

    public boolean contains(T data){
        return indexOf(data) != -1;
    }
}

