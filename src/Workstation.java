import java.util.ArrayList;
//j
public class Workstation implements Runnable {

	private static ArrayList<String> workTime;
	int totalP;
    boolean ready;
	private static buffers b11;
    private static buffers b12;
    private static buffers b13; 
    private static buffers b22; 
    private static buffers b23; 
	// constructor for workstation
	public Workstation(ArrayList<String> workTime,buffers b11,buffers b12,buffers b13,buffers b22,buffers b23) {
		this.workTime = workTime;
        totalP=0;
        ready=false;
		this.b11=b11;
        this.b12=b12;
        this.b13=b13;
		this.b22=b22;
        this.b23=b23;
	}

	// get state of the workstation
	public boolean getState() {
		return ready;
	}

    //change state
    public void changeState(boolean s) {
		ready=s;
	}

	public synchronized void createProduct(){
		changeState(false);
		workTime = workstationTime();
		notifyAll();
	}

	//public ArrayList<Component> getComponents() {
	//	return components;
	//}

	// add the processing time for the worksation
	public synchronized ArrayList<String> workstationTime() {
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
	public int getProducts() {
		return totalP;
	}

	public boolean workstation1Ready(){
		if(b11.getSize()>=1){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean workstation2Ready(){
		if(b12.getSize()>=1 && b22.getSize()>=1){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean workstation3Ready(){
		if(b13.getSize()>=1 && b23.getSize()>=1){
			return true;
		}
		else{
			return false;
		}
	}

	public void run() {
		while(true){
			//if(Thread.currentThread().getName().equals("Workstation1")){
			if(workstation1Ready()){
				System.out.println(Thread.currentThread().getName());
				b11.makeProduct();
				createProduct();
				System.out.println("Product 1 Created");
			}
			//}
			//else if(Thread.currentThread().getName().equals("Workstation2")){
			else if(workstation2Ready()){
				System.out.println(Thread.currentThread().getName());
				b12.makeProduct();
				b22.makeProduct();
				createProduct();
				System.out.println("Product 2 Created");
			}
			//}
			//else if(Thread.currentThread().getName().equals("Workstation3")){
			else if(workstation3Ready()){
				System.out.println(Thread.currentThread().getName());
				b13.makeProduct();
				b23.makeProduct();
				createProduct();
				System.out.println("Product 3 Created");
			}
			//}
		}
	}
}
		
		/*public void send(String msg)
		    {
		    	while() {
		        System.out.println("Sending\t"  + msg );
		        try
		        {
		            Thread.sleep(1000);
		        }
		        catch (Exception e)
		        {
		            System.out.println("Thread  blocked.");
		        }
		        System.out.println("\n" + msg + "Sent");
		    }
		}
		
    	
    	}*/