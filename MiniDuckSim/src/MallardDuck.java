public class MallardDuck extends Duck{
    // in constructor define behaviours
    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("This is a Mallard Duck !");
    }
}
