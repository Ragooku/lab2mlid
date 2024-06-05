import java.util.Scanner;

public class Main {

    public static boolean checkReflexivity(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSymmetry(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkAntisymmetry(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j && matrix[i][j] == 1 && matrix[j][i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkTransitivity(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[j][k] == 1 && matrix[i][k] != 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность множества (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        System.out.println("Введите матрицу смежности:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        boolean isReflexive = checkReflexivity(matrix);
        boolean isSymmetric = checkSymmetry(matrix);
        boolean isAntisymmetric = checkAntisymmetry(matrix);
        boolean isTransitive = checkTransitivity(matrix);

        System.out.println("Рефлексивность: " + (isReflexive ? "Да" : "Нет"));
        System.out.println("Симметричность: " + (isSymmetric ? "Да" : "Нет"));
        System.out.println("Кососимметричность: " + (isAntisymmetric ? "Да" : "Нет"));
        System.out.println("Транзитивность: " + (isTransitive ? "Да" : "Нет"));

        scanner.close();
    }
}