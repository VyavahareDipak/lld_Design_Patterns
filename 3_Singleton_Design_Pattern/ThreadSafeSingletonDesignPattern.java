

class Singleton{
    private static Singleton instance = null ;

    private Singleton(){
        System.out.println("Singleton object created.");
    }
    public static Singleton getInstance(){
        synchronized (Singleton.class){
            if(instance==null){
                instance = new Singleton();
            }
        }
        return instance ;
    }
}

class ThreadSafeSingletonDesignPattern{

    public static void main(String args[]){

    }
}