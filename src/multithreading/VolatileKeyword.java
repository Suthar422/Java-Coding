package multithreading;

class SharedVariable{
    int j=0;   //shared variable

    public void incrementJ(){
        for(int i=0;i<1000;i++)
            j++;
    }

    public int getJ() {return j;}
}

class VolatileDemo extends Thread{
    SharedVariable s;
    public VolatileDemo(SharedVariable s){
      this.s=s;
    }


   @Override
    public void run() {
            s.incrementJ();
    }

}
public class VolatileKeyword {
    public static void main(String[] args) throws InterruptedException {
        SharedVariable s = new SharedVariable();
        VolatileDemo t1 = new VolatileDemo(s);
        VolatileDemo t2 = new VolatileDemo(s);
        t1.start();
        t2.start();

//        Thread.sleep(1000);
        try{
            t1.join();
            t2.join();
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Main thread is running  "+ Thread.currentThread().getName());
        System.out.println(s.getJ());


    }


}
