import java.util.Random;
import java.util.ArrayList;

public class Inspector implements Runnable {
	
	String[] components =new String[] {"C1","C2","C3"};//ingredients the agent has to offer
	String[] chosenComponents = new String[2]; // ingredients that will be put on table
    private boolean state;
    private ArrayList<String> workTime;
    private ArrayList<String> workTime2;
    private ArrayList<String> workTime3;
    private String c1 = "C1";
    private String c;
    private String[] C2 = {"C2","C3"};
    Random rand = new Random();
    private volatile static buffers b11;
    private volatile static buffers b12;
    private volatile static buffers b13; 
    private volatile static buffers b22; 
    private volatile static buffers b23; 

    public Inspector(ArrayList<String> workTime,buffers b11,buffers b12,buffers b13){
        this.workTime= workTime;
        this.b11=b11;
        this.b12=b12;
        this.b13=b13;
        c=c1;
    }

    public Inspector(ArrayList<String> workTime,ArrayList<String> workTime2,buffers b22,buffers b23){
        this.workTime= workTime;
        this.workTime= workTime2;
        this.b22=b22;
        this.b23=b23;
        c="poo";
    }

    private String ranComp(String[] c2){
    	int compNum = rand.nextInt(2);//random number from 1-2 to chose ingredients in the array
    	return c2[compNum];
    }

    //public static Boolean getState(){
   //     return state;
   // }

   // public static void setState(Boolean s){
   //     state = s;
   // }
    public synchronized void chooseBuffer() throws NullPointerException{ 
        if(c.equals("C1")){
            if(b11.isFull()&&b12.isFull()&&b13.isFull()){
                System.out.println(Thread.currentThread().getName() + " blocked");
                //state=true;
                block();
            }
            else if(b11.getSize()<=b12.getSize()&&b11.getSize()<=b13.getSize()){
                b11.addComponent(c);
                //System.out.println("size of buffer is" + b11.getSize());
                System.out.println(Thread.currentThread().getName()+" added to b11");
                
            }            
            else if(b11.getSize()>b12.getSize()&&b12.getSize()<=b13.getSize()) {
                b12.addComponent(c);
                System.out.println(Thread.currentThread().getName() + " added to b12");
            }
            else{
                b13.addComponent(c);
                System.out.println(Thread.currentThread().getName()+" added to b13");
            }
            return;
        }
        c=ranComp(C2);
        if(c.equals("C2") && Workstation.workstation2Ready()){
            b22.addComponent(c);
            System.out.println(Thread.currentThread().getName()+" added to b22");
        }
        else if(c.equals("C3") && Workstation.workstation3Ready()){
            b23.addComponent(c);
            System.out.println(Thread.currentThread().getName() + " added to b23");
        }
        else{
            System.out.println(Thread.currentThread().getName()+ " blocked");
            //state=true;
            block();
        }
    }

    public synchronized void block(){
        while(true){
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    public synchronized ArrayList<String> inspectionTime() {
		String sleep = workTime.get(0);
		float num = Float.parseFloat(sleep);
		num *= 1000;
		int i = Math.round(num);
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);
		workTime.remove(0);
		return workTime;
	}

    public void run()
    {
    	for(int j = 1; j<=20;j++){//run 20 times
            //check which buffer gets the component
            //add component to buffer
            workTime = inspectionTime();
            chooseBuffer();
            //try {
            //    Thread.sleep(1000); // change to 100 to see difference
            //} catch (InterruptedException e) {}
     }
     System.out.println("Inspector Fin");
    }
}
