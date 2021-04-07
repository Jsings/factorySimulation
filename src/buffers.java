import java.util.ArrayList;

public class buffers {
    public static ArrayList<String> buffer = new ArrayList<>(2);

    public synchronized int getSize(){
        return buffer.size();
    }

    public synchronized void makeProduct(){
        if(!buffer.isEmpty()){
        System.out.println("size of buffer is " + buffer.size());
        buffer.remove(0);
        System.out.println("size of buffer is a " + buffer.size());
        }
    }

    public synchronized void addComponent(String C){
        if (buffer.size()<2){
            buffer.add(C);
        }
    }
    public Boolean isFull(){
        if(buffer.size() ==2){
            return true;
        }
        return false;


    }
}
