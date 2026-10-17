package multithreading;

class OddEvenLogic{
    int count =20;
    int i = 1;

    public synchronized void Odd(){
        while(i<=count){
            if(i%2==1){
                System.out.println("Odd :" +i);
                i++;
                notifyAll();
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }


    }

    public synchronized void Even(){
        while(i<=count){
            if(i%2==0){
                System.out.println("Even " +i);
                i++;
                notifyAll();
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
public class OddEven {

    public static void main(String[] args) {

        OddEvenLogic logic = new OddEvenLogic();

       Thread t1 = new Thread(()->{logic.Odd();});
        Thread t2 = new Thread(()->{logic.Even();});

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
