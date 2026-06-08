import java.util.Scanner;
import java.util.Arrays;

public class EdmondStudentGrade{

    public static void main(String[] args){

//        Scanner input = new Scanner(System.in);
        int numberOfStudents = 2;
        int numberOfStudentQuizzes = 3;
//        int[][] studentScores = new int[numberOfStudents][numberOfStudentQuizzes];
        int score = 70;
//        for(int index = 0; index < numberOfStudents; index++){
//            for(int count = 0; count < numberOfStudentQuizzes; count++;){
//                System.out.println(Arrays.deepToString(getQuizScores(numberOfStudents, numberOfStudentQuizzes, score, index, count)));
//            }
//        }
        

        System.out.println(Arrays.deepToString(getQuizScores(numberOfStudents, numberOfStudentQuizzes, score)));
        

    }

    public static int[][] getQuizScores(int numberOfStudents, int numberOfStudentQuizzes, int score){
        int[][] studentScores = new int[numberOfStudents][numberOfStudentQuizzes];
        for(int index = 0; index < numberOfStudents; index++){
            for(int count = 0; count < numberOfStudentQuizzes; count++){
                studentScores[index][count] = score;
                if(score < 0 || score > 100){
                    count++;
                }
                else{

                }
            }
            if(score < 0 || score > 100){
                count++;
            }
            else{
                count++
            }
        }
  
        return studentScores;
    }


}

