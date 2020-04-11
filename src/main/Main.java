package main;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.fillField();
        field.putQueen(3,4);
        field.showAvailableMoves();
        field.printField();
    }
}
