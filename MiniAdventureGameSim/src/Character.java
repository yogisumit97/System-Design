public abstract class Character {
    WeaponBehavior wb;
    Character(){
        System.out.println(" Character initialized !");
    }
    public void setWeapon(WeaponBehavior wb){
        this.wb = wb;
    }
    public abstract void fight();
}
