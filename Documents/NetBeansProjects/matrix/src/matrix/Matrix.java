/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileMismatchException;


/**
 *
 * @author khaled
 */
public class Matrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner input = new Scanner(new File("input.txt"));
        int numOfCase = input.nextInt();
        for (int i = 1; i <= numOfCase; i++) {
            System.out.println();
            System.out.print("Case #" + i + ":");
            int rowA = input.nextInt();
            int columnA = input.nextInt();
            int[][] matrixA = new int[rowA][columnA];
            for(int i0 = 0; i0 < matrixA.length; i0++) 
                for (int j0 = 0; j0 < matrixA[0].length; j0++)
                    matrixA[i0][j0] = input.nextInt();
            int rowB = input.nextInt();
            int columnB = input.nextInt();
            int[][] matrixB = new int[rowB][columnB];
            //int [][] matrixBtranspose = new int[columnB][rowB];
            
            for(int i0 = 0; i0 < matrixB.length; i0++) 
                for (int j0 = 0; j0 < matrixB[0].length; j0++)
                    matrixB[i0][j0] = input.nextInt();
            int numOfQ = input.nextInt();
            for (int i0 = 0; i0 <= numOfQ; i0++) {
                String operation = input.nextLine();
                System.out.println(operation);
                switch (operation) {
                    case "Transpose A":
                        transpose(matrixA);
                        break;
                    case "Transpose B":
                        transpose(matrixB);
                        break;
                    case "SUM A B":
                        sum(matrixA, matrixB);
                        break;
                    case "SUBT A B":
                        subt(matrixA, matrixB);
                        break;
                    case "SUBT B A":
                        subt(matrixB, matrixA);
                        break;
                    case "MUL A B":
                        mul(matrixA, matrixB);
                        break;
                    case "MUL B A":
                        mul(matrixB, matrixA);
                        break;
                    case "Det A":
                        System.out.println(det(matrixA));
                        break;
                    case "Det B":
                        System.out.println(det(matrixB));
                        break;
                    default:
                        ;
                        break;
                }
            }
            
        }
            /*for (int a = 0; a < matrixB.length; a++) {
                for (int b = 0; b < matrixB[0].length; b++) {
                    System.out.print(matrixB[a][b] + " ");
                    
                }
                System.out.println();
            }*/
    }
    
    
   
public static void sum(int[][] matrixA, int[][] matrixB) {
        int[][] matrixC = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[0].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                System.out.printf("%-6d",matrixC[i][j]);
            }
            System.out.println();
        }
    }
    public static void subt(int[][] matrixA, int[][] matrixB) {
        int[][] matrixC = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[0].length; j++) {
                matrixC[i][j] = matrixA[i][j] - matrixB[i][j];
                System.out.printf("%-6d",matrixC[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = matrix[j][i];
                System.out.printf("%-6d",newMatrix[i][j]);
            }
            System.out.println();
        }
        return newMatrix;
    }
    public static void mul(int[][] matrixA, int[][] matrixB) {
     
        int[][] matrixC = new int[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                matrixC[i][j] = 0;
                for (int k = 0; k < matrixB.length; k++){
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
                System.out.printf("%-6d",matrixC[i][j]);
            }
            System.out.println();
        }
    }
    public static int det(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[matrix.length][matrix[0].length];
        int det = 0;
        if (matrix.length == 1) {
            det = matrix[0][0];
            System.out.println(det);
        }
        if (n == 2) {
            det = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
            System.out.println(det);
        }
        for (int i = 0; i < n; i++){
            tmp = new int[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k < i)
                        tmp[j - 1][k] = matrix[j][k];
                    else if (k > i)
                        tmp[j - 1][k - 1] = matrix[j][k];
                }
            }
            det += (matrix[0][i] * Math.pow(-1, i) * det(tmp));
        }
        return det;
    }
}
