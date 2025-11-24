public class Queen extends Character{
    Queen(){
        wb = new KnifeBehavior();
    }

    @Override
    public void fight() {
        System.out.print(" Queen is fighting - ");
        wb.useWeapon();
    }
}
