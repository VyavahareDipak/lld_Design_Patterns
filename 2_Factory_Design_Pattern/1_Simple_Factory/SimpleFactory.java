//Def : A factory class which deside which concreate class to instaciate.

interface Burger{
    public void prepare() ;
}

class BasicBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing basic burger");
    }
}

class StanderdBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Standerd burger");
    }
}

class PremiumBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Premium burger");
    }
}

class BurgerFactory{
    public Burger createBurger(String type){
        if(type.equalsIgnoreCase("basic")){
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standerd")) {
            return new StanderdBurger() ;
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        }
        return null ;
    }
}


class SimpleFactory{

    public static void main(String args[]){
        BurgerFactory factory = new BurgerFactory() ;

        Burger b1 = factory.createBurger("basic") ;
        Burger b2 = factory.createBurger("standerd") ;
        Burger b3 = factory.createBurger("premium") ;

        b1.prepare();
        b2.prepare();
        b3.prepare();

        System.out.println("Hello world");
    }
}