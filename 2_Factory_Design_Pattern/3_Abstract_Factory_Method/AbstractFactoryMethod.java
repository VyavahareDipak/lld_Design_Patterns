
/* Def : Design an interface for creating objects but allows its
 concreate classes to decide which class to instantiate.
 */
//--------------- product 1 --------------------------------------
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


//--------------------- product 2 ----------------------------------------

interface GarlicBread{
    public void prepare();
}

class BasicGarlicBread implements GarlicBread {
    public void prepare(){
        System.out.println("Preparing basic GarlicBread");
    }
}

class StanderdGarlicBread implements GarlicBread {
    public void prepare(){
        System.out.println("Preparing Standerd Garlic Bread");
    }
}

class PremiumGarlicBread implements GarlicBread {
    public void prepare(){
        System.out.println("Preparing Premium Garlic Bread");
    }
}

class BasicWeatGarlicBread implements GarlicBread {
    public void prepare(){
        System.out.println("Preparing basic Weat GarlicBread");
    }
}

class StanderdWeatGarlicBread implements GarlicBread {
    public void prepare(){
        System.out.println("Preparing Standerd Weat Garlic Bread");
    }
}

class PremiumWeatGarlicBread implements GarlicBread {
    public void prepare(){
        System.out.println("Preparing Premium Weat Garlic Bread");
    }
}

interface MealFactory{
    public Burger createBurger(String type);
    public GarlicBread createGarlicBread(String type) ;
}

class NormalFactory implements MealFactory{
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

    public GarlicBread createGarlicBread(String type){
        if(type.equalsIgnoreCase("basic")){
            return new BasicGarlicBread();
        } else if (type.equalsIgnoreCase("standerd")) {
            return new StanderdGarlicBread() ;
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumGarlicBread();
        }
        return null ;
    }
}

class HealthyFactory implements MealFactory{
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

    public GarlicBread createGarlicBread(String type){
        if(type.equalsIgnoreCase("basic")){
            return new BasicWeatGarlicBread();
        } else if (type.equalsIgnoreCase("standerd")) {
            return new StanderdWeatGarlicBread() ;
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWeatGarlicBread();
        }
        return null ;
    }
}


class AbstractFactoryMethod{
    public static void main(String args[]){
        MealFactory factory = new NormalFactory() ;

        Burger b1 = factory.createBurger("basic") ;
        Burger b2 = factory.createBurger("standerd") ;
        Burger b3 = factory.createBurger("premium") ;

        GarlicBread g1 = factory.createGarlicBread("basic") ;
        GarlicBread g2 = factory.createGarlicBread("standerd") ;
        GarlicBread g3 = factory.createGarlicBread("premium") ;

        b1.prepare();
        b2.prepare();
        b3.prepare();

        g1.prepare();
        g2.prepare();
        g3.prepare();

        System.out.println("-------------- Healthy burger -------------");

        factory = new HealthyFactory();

        Burger b4 = factory.createBurger("basic") ;
        Burger b5 = factory.createBurger("standerd") ;
        Burger b6 = factory.createBurger("premium") ;

        b4.prepare();
        b5.prepare();
        b6.prepare();

        GarlicBread g4 = factory.createGarlicBread("basic") ;
        GarlicBread g5 = factory.createGarlicBread("standerd") ;
        GarlicBread g6 = factory.createGarlicBread("premium") ;

        g4.prepare();
        g5.prepare();
        g6.prepare();

    }
}