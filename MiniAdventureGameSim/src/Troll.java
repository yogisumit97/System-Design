public class Troll extends Character{
    Troll(){
        wb = new AxeBehavior();
    }

    @Override
    public void fight() {
        System.out.print(" Troll is fighting - ");
        wb.useWeapon();
    }
}

