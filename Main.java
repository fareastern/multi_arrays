import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 8;
    private static final int[][] colors = new int[SIZE][SIZE];
    private static final int[][] rotatedColors = new int[SIZE][SIZE];

    public static void main(String[] args) {
        createTable();
        showTable(colors);
        showMenu();
        showNewTable();
    }

    private static void createTable(){
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
    }

    // Предоставляем пользователю вывод и разворачиваем в соответствии с выбором базовую матрицу
    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("На какой угол разворачиваем матрицу?");
        System.out.println("1. 90 градусов");
        System.out.println("2. 180 градусов");
        System.out.println("3. 270 градусов");

        boolean actCycle = true;
        while (actCycle) {
            System.out.println("Введите ниже 1, 2 или 3");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    turnTable90();
                    actCycle = false;
                    break;
                case 2:
                    turnTable180();
                    actCycle = false;
                    break;
                case 3:
                    turnTable270();
                    actCycle = false;
                    break;
                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    // МЕТОДЫ ВЫВОДА МАТРИЦ (БАЗОВОЙ И НОВОЙ)
    public static void showTable(int[][] colors){
        System.out.println("Дана следующая матрица:\n");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
    }
    public static void showNewTable() {
        System.out.println("\nВывод:\n");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(rotatedColors[i][j] + " ");
            }
            System.out.println();
        }
    }

    // МЕТОДЫ ПОВОРОТА МАТРИЦЫ НА 90, 180 и 270 градусов
    private static void turnTable90 () {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[j][SIZE - 1 - i] = colors[i][j];
            }
        }
    }
    private static void turnTable180() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[SIZE - 1 - i][SIZE - 1 - j] = colors[i][j];
            }
        }
    }
    private static void turnTable270() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[SIZE - 1 - j][i] = colors[i][j];
            }
        }
    }
}