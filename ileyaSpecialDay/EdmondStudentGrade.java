import java.util.Scanner;

public class EdmondStudentGrade{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);


        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();

        System.out.print("Enter number of quizzes: ");
        int numberOfStudentQuizzes = input.nextInt();
        
        int[][] studentScore = new int[numberOfStudents][numberOfStudentQuizzes];

        for (int index = 0; index < numberOfStudents; index++) {
            System.out.println("---Student " + (index + 1) + "---");
            for (int count = 0; count < numberOfStudentQuizzes; count++) {
                System.out.print("Enter score for quiz " + (count + 1) + ": ");
                studentScore[index][count] = input.nextInt();
            }
        }

        System.out.println();

        System.out.println("==================== QUIZ GRADE REPORT ====================");
        System.out.print("STUDENT\t\t");
        for (int i = 1; i <= numberOfStudentQuizzes; i++) {
            System.out.print("QZ" + i + "\t");
        }
        System.out.println("AVG");
        
        System.out.println("-----------------------------------------------------------");

        for (int index = 0; index < numberOfStudents; index++) {
            System.out.print("Student " + (index + 1) + "\t");
            int studentSum = 0;
            
            for (int count = 0; count < numberOfStudentQuizzes; count++) {
                System.out.print(studentScore[index][count] + "\t");
                studentSum += studentScore[index][count];
            }
            

            double studentAvg = (double) studentSum / numberOfStudentQuizzes;
            System.out.println(studentAvg);
        }
        
        System.out.println("-----------------------------------------------------------");

    }
}

