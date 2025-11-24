public class Main {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.display();

        System.out.println();

        Duck toyDuck = new ToyDuck();
        toyDuck.performFly();
        toyDuck.performQuack();
        toyDuck.display();
        toyDuck.setFlyBehavior(new FlyRocketPowered()); // dynamic change of flying behavior
        toyDuck.performFly();
    }
}
