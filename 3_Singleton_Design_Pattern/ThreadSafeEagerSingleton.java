
//--------------- Only used when singleton class object is light-weight --------------------------

class Singleton{
    private static Singleton instance = new Singleton() ;
    private Singleton(){
        System.out.println("Singleton object created.");
    }
    public static Singleton getInstance(){
        return instance ;
    }
}

class ThreadSafeEagerSingleton{
    public static void main(String args[]){

    }
}