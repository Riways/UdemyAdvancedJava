package Multithreading;

public class VolatileKeyWord {


    static boolean b = true; //Went to infinite loop
    //static volatile boolean  counter = true; //OK

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start program");
        Thread thread23 = new Thread(new Multithreading.Thread23());
        thread23.start();
        Thread.sleep(3000);
        System.out.println("3 seconds later");
        b = false;
        thread23.join();
        System.out.println("End of program");

    }
    void abc(){

    }

}

 class Thread23 implements Runnable{
    @Override
    public void run() {
        long counter = 0;
        while(VolatileKeyWord.b){
            counter++;
        }
        System.out.println(counter);
    }
}
