public class PrintTwoThreads {

    private static boolean is_letter = true;
    private static final Object lock = new Object();

    public static void main(String[] args){

        Runnable letterTask = new Runnable() {
            @Override
            public void run() {
                for (char ch = 'A' ; ch <= 'Z' ; ch++) {

                    synchronized (lock){
                        if(!is_letter){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print(" " + ch);
                        is_letter = false;
                        lock.notify();
                    }

                }
            }
        };

        Runnable numberTask = new Runnable() {
            @Override
            public void run() {
                for (int ch = 1 ; ch <= 26 ; ch++) {

                    synchronized (lock){
                        if(is_letter){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print(" " + ch);
                        is_letter = true;
                        lock.notify();
                    }
                }
            }
        };

        Thread letterThread = new Thread(letterTask);
        Thread numberThread = new Thread(numberTask);

        letterThread.start();
        numberThread.start();

        try{
            letterThread.join();
            numberThread.join();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
