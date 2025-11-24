public class ToyDuck extends Duck{
    public ToyDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }
    @Override
    public void display(){
        System.out.println("This is not a real duck !");
    }
}
