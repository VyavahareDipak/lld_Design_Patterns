//-------------------------talk statergy--------------------------
interface Talkable{
    public void talk() ;
}

//--------------------------Walk strategy----------------------------
interface Walkable{
    public void walk() ;
}
//---------------------------Fly strategy-----------------------------
interface Flyable{
    public void fly() ;
}

//---------------------------Concrete classes of Talk--------------------------
class NormalTalk implements Talkable{
    @Override
    public void talk(){
        System.out.println("Talking normally");
    }
}


class NoTalk implements Talkable{
    @Override
    public void talk(){
        System.out.println("No talk");
    }
}

//---------------------------Concrete classes of Walk --------------------------
class NormalWalk implements Walkable{

    @Override
    public void walk(){
        System.out.println("Normal walk");
    }
}

class NoWalk implements Walkable{
    @Override
    public void walk(){
        System.out.println("No walk");
    }
}

//---------------------------Concrete classes of Fly--------------------------
class NormalFly implements Flyable{
    @Override
    public void fly(){
        System.out.println("Normal fly");
    }
}

class NoFly implements Flyable{
    @Override
    public void fly(){
        System.out.println("No fly");
    }
}

// -------------------------- Robot Base class ------------------------------
abstract class Robot{

    Talkable t ;
    Walkable w ;
    Flyable f ;

    public Robot(Talkable t , Walkable w , Flyable f){
        this.t = t ;
        this.f = f ;
        this.w = w ;
    }
    public void walk(){
        w.walk();
    }

    public void talk(){
        t.talk();
    }

    public void fly(){
        f.fly();
    }

    public abstract void projection() ;
}

//-------------------------- Robot Concrete Classes [Client] --------------------------------------
class WorkerR extends Robot{

    public WorkerR(Talkable t , Walkable w , Flyable f) {
        super(t, w,f);
    }
    public void projection(){
        System.out.println("Printing WorkerR");
    }
}

class CompanionR extends Robot{

    public CompanionR(Talkable t , Walkable w , Flyable f) {
        super(t, w,f);
    }
    public void projection(){
        System.out.println("Printing CompanionR");
    }
}

class SparrowR extends Robot{

    public SparrowR(Talkable t , Walkable w , Flyable f) {
        super(t, w,f);
    }
    public void projection(){
        System.out.println("Printing SparrowR");
    }
}

// ----------------------- main class -----------------------------------
class StrategyDesignPattern{
    public static void main(String args[]){
        System.out.println("hello world");

        Robot robot1 = new CompanionR(new NormalTalk() , new NormalWalk(), new NoFly());
        robot1.walk();
        robot1.fly();
        robot1.talk();

        System.out.println("------------------------------------");

        Robot robot2 = new SparrowR(new NormalTalk(),new NoWalk(), new NoFly()) ;
        robot2.walk();
        robot2.fly();
        robot2.talk();


    }
}