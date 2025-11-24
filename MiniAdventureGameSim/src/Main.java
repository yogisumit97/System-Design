public class Main {
    public static void main(String[] args) {
        /* example of strategy pattern  >> the strategy pattern defines a family of algorithms,
        encapsulates each one, and makes them interchaneable, Strategy lets the algorithm vary independently
        from clients that use it. */
        Character queen = new Queen();
        Character king = new King();

        queen.fight();
        king.fight();

        king.setWeapon(new BowAndArrowBehavior()); // dynamically changing
        king.fight();
    }
}