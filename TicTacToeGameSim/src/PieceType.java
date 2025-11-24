public class PieceType {
    char ch;
    String color;
    public char getCh() {
        return ch;
    }
    public void setCh(char ch) {
        this.ch = ch;
    }
    public void displayInformation(){
        System.out.println("PieceType : "+ ch+ "  , Color : "+color+".");
    }
}
