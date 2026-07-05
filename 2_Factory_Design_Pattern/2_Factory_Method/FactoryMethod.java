
/* Def : Design an interface for creating objects but allows its
 concreate classes to decide which class to instantiate.
 */

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

class BasicWeatBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing basic Weat burger");
    }
}

class StanderdWeatBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Standerd Weat burger");
    }
}

class PremiumWeatBurger implements Burger{
    public void prepare(){
        System.out.println("Preparing Premium Weat burger");
    }
}


interface Factory{
    public Burger createBurger(String type);
}

class NormalBurgerFactory implements Factory{
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

class HealthyBurgerFactory implements Factory{
    public Burger createBurger(String type){
        if(type.equalsIgnoreCase("basic")){
            return new BasicWeatBurger();
        } else if (type.equalsIgnoreCase("standerd")) {
            return new StanderdWeatBurger() ;
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWeatBurger();
        }
        return null ;
    }
}


class FactoryMethod{
    public static void main(String args[]){
        Factory factory = new NormalBurgerFactory() ;

        Burger b1 = factory.createBurger("basic") ;
        Burger b2 = factory.createBurger("standerd") ;
        Burger b3 = factory.createBurger("premium") ;

        b1.prepare();
        b2.prepare();
        b3.prepare();

        System.out.println("-------------- Healthy burger -------------");

        factory = new HealthyBurgerFactory();

        Burger b4 = factory.createBurger("basic") ;
        Burger b5 = factory.createBurger("standerd") ;
        Burger b6 = factory.createBurger("premium") ;

        b4.prepare();
        b5.prepare();
        b6.prepare();

    }
}