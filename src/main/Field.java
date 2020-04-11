package main;

public class Field {
    private String[][] gameField = new String[8][8];
    private int queenPositionA;
    private int queenPositionB;

    // метод заполняющий массив игрового поля
    public void fillField() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                gameField[i][j] = "x";
            }
        }
    }

    // метод визуализации игрового поля
    public void printField() {
        for (int i = 0; i < gameField.length; i++) {
            String result = "";
            for (int j = 0; j < gameField.length; j++) {
                result += gameField[i][j] + "  ";
            }
            System.out.println(result);
        }
    }

    public void putQueen(int a, int b) {
        queenPositionA = a;
        queenPositionB = b;
    }

    public void showAvailableMoves() {

        // рисую доступные ходы по горизонтали и вертикали
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (i == queenPositionA) {
                    gameField[i][j] = "-";
                }
                if (j == queenPositionB) {
                    gameField[i][j] = "-";
                }
            }
        }


        // рисую доступные ходы по диагонали слева на право
        int leftStartPositionI = Math.abs(queenPositionB - queenPositionA);
        if (queenPositionB < queenPositionA) {
            int leftStartPositionJ = 0;
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (i == leftStartPositionI & j == leftStartPositionJ) {
                        gameField[i][j] = "-";
                        leftStartPositionI++;
                        leftStartPositionJ++;
                    }
                }
            }
        } else {
            int leftStartPositionJ = Math.abs(queenPositionB - queenPositionA);
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (j == leftStartPositionJ) {
                        gameField[i][j] = "-";
                        leftStartPositionJ++;
                        break;
                    }
                }
            }
        }

        // рисую доступные ходы по диагонали справа на лево
        if (queenPositionA + queenPositionB <= 7) {
            int rightStartPositionI = 0;
            int rightStartPositionJ = queenPositionA + queenPositionB;
            if (rightStartPositionJ > 7) {
                rightStartPositionJ = 7;
            }
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (i == rightStartPositionI & j == rightStartPositionJ) {
                        gameField[i][j] = "-";
                        rightStartPositionI++;
                        rightStartPositionJ--;
                    }
                }
            }
        } else {
            int rightStartPositionI = queenPositionA + queenPositionB - 7;
            int rightStartPositionJ = 7;
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (i == rightStartPositionI & j == rightStartPositionJ) {
                        gameField[i][j] = "-";
                        rightStartPositionI++;
                        rightStartPositionJ--;
                    }
                }
            }
        }
        gameField[queenPositionA][queenPositionB] = "Q";
    }
}