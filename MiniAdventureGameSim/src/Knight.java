public class Knight extends Character{
    Knight(){
        wb = new BowAndArrowBehavior();
    }

    @Override
    public void fight() {
        System.out.print(" Knight is fighting - ");
        wb.useWeapon();
    }
}

