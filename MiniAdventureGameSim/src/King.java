public class King extends Character{
    King(){
        wb = new SwordBehavior();
    }

    @Override
    public void fight() {
        System.out.print(" King is fighting - ");
        wb.useWeapon();
    }
}
