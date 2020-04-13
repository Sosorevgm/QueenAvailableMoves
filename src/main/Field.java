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


        // Рисую доступные ходы по диагонали слева на право.
        // Возможное поле (leftStartPositionI) для первого цикла равна модулю разницы
        // позиции королевы по горизонтали и позиции королевы по вертикали
        int leftStartPositionI = Math.abs(queenPositionB - queenPositionA);
        // Если позиция королевы по горизонтали меньше позиции королевы по вертикали
        // возможное поле (leftStartPositionJ) для второго цикла равна нулю
        if (queenPositionB < queenPositionA) {
            int leftStartPositionJ = 0;
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    // При совпадении возможных полей по горизонтали и вертикали (leftStartPositionI и leftStartPositionJ)
                    // с итерируемыми переменнами в циклах рисую доступный ход и увеличиваю значение возможного поля на один
                    if (i == leftStartPositionI & j == leftStartPositionJ) {
                        gameField[i][j] = "-";
                        leftStartPositionI++;
                        leftStartPositionJ++;
                    }
                }
            }
        } else {
            // Если позиция корлевы по горизонтали больше или равна позиции королевы по вертикали
            // возможная позиция (leftStartPositionJ) для для второго цикла равна их разнице
            int leftStartPositionJ = Math.abs(queenPositionB - queenPositionA);
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (j == leftStartPositionJ) {
                        // При совпадении возможной позиции (leftStartPositionJ) с итерируемой переменной
                        // рисую доступный ход, увеличиваю значение возможного хода на один,
                        // выхожу из второго цикла и перехожу к следующей горизонтали
                        gameField[i][j] = "-";
                        leftStartPositionJ++;
                        break;
                    }
                }
            }
        }

        // Рисую доступные ходы по диагонали справа на лево.
        // Если сумма позиций королевы по вертикали и горизонтали меньше или равна максимальному индексу в массиве,
        // возможная позиция для первого цикла (rightStartPositionI) равна нулю.
        // Возможная позиция для второго цикла (rightStartPositionJ) равна сумме
        // значений позиции королевы по вертикали и горизонтали
        if (queenPositionA + queenPositionB <= 7) {
            int rightStartPositionI = 0;
            int rightStartPositionJ = queenPositionA + queenPositionB;
            // Если значение возможной позиции для второго цикла (rightStartPositionJ)
            // превышает максимальный размер массива, задаю ему максимально возможное значение
            if (rightStartPositionJ > 7) {
                rightStartPositionJ = 7;
            }
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (i == rightStartPositionI & j == rightStartPositionJ) {
                        // При совпадении возможных полей по горизонтали и вертикали (rightStartPositionI и rightStartPositionJ)
                        // с итерируемыми переменнами в циклах рисую доступный ход,
                        // значение возможного поля для первого цикла (rightStartPositionI) увеличивается,
                        // значение возможного поля для второго цикла (rightStartPositionJ) уменьшается.
                        gameField[i][j] = "-";
                        rightStartPositionI++;
                        rightStartPositionJ--;
                    }
                }
            }
        } else {
            // Если сумма позиций королевы по вертикали и горизонтали превышает максимальный индекс в массиве,
            // возможная позиция для первого цикла (rightStartPositionI) равна
            // сумме позиций королевы по вертикали и горизонтали минус максимальный индекс массива.
            // Возможная позиция для второго цикла (rightStartPositionJ) равна максимальному индексу массива.
            int rightStartPositionI = queenPositionA + queenPositionB - 7;
            int rightStartPositionJ = 7;
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (i == rightStartPositionI & j == rightStartPositionJ) {
                        // При совпадении возможных полей по горизонтали и вертикали (rightStartPositionI и rightStartPositionJ)
                        // с итерируемыми переменнами в циклах рисую доступный ход,
                        // значение возможного поля для первого цикла (rightStartPositionI) увеличивается,
                        // значение возможного поля для второго цикла (rightStartPositionJ) уменьшается.
                        gameField[i][j] = "-";
                        rightStartPositionI++;
                        rightStartPositionJ--;
                    }
                }
            }
        }
        // Рисую позицию королевы на поле
        gameField[queenPositionA][queenPositionB] = "Q";
    }
}