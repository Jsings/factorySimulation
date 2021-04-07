import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class simulation extends Thread{
	public static void main(String[] args) {

		// TODO Auto-generated method stub
        ArrayList<String> servinsp1 = makeArrayList("servinsp1.txt");
		ArrayList<String> servinsp22 = makeArrayList("servinsp22.txt");
		ArrayList<String> servinsp23 = makeArrayList("servinsp23.txt");
		ArrayList<String> ws1 = makeArrayList("ws1.txt");
		ArrayList<String> ws2 = makeArrayList("ws2.txt");
		ArrayList<String> ws3 = makeArrayList("ws3.txt");
		Thread w1,w2,w3,inspector1,inspector2;
        buffers b11 ,b12, b13,b22,b23; 
        b11=new buffers();
        b12=new buffers();
        b13=new buffers();
        b22=new buffers();
        b23=new buffers();
		 
		inspector1 = new Thread(new Inspector(servinsp1,b11,b12,b13),"Inspector1");
		inspector2 = new Thread(new Inspector(servinsp22,servinsp23,b22,b23),"Inspector2");  
        w1 = new Thread(new Workstation(ws1,b11,b12,b13,b22,b23),"Workstation1");
		w2 = new Thread(new Workstation(ws2,b11,b12,b13,b22,b23),"Workstation2");
		w3 = new Thread(new Workstation(ws3,b11,b12,b13,b22,b23),"Workstation3");

        // Create the producer and consumer threads, passing each thread
        // a reference to the shared BoundedBuffer object.
		inspector1.start();
		inspector2.start();
        w1.start();
		w2.start();
		w3.start();

	}
    public static ArrayList<String> makeArrayList(String file){
		ArrayList<String> lines = null;
		try {
		    lines = new ArrayList<>(Files.readAllLines(Paths.get(file)));
		}
		catch (IOException e) {
		    // Handle a potential exception
		}
		return lines;
		//for(int i=0;i<lines.size();i++) {
		//	System.out.println(lines.get(i));
		//}
	}


}