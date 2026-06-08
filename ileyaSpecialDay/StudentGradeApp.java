import java.util.Scanner;
import java.util.Arrays;

public class EdmondStudentGrade{

    public static int[][] studentScores;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();
        
        System.out.print("Enter number of quizzes: ");
        int numberOfStudentQuizzes = input.nextInt();
        
        studentScores = new int[numberOfStudents][numberOfStudentQuizzes];
        
        collectScores(input, numberOfStudents, numberOfStudentQuizzes);

        System.out.println();
        
        System.out.println("Scores Matrix: " + Arrays.deepToString(studentScores));
        
        System.out.println("\n--- Student Performance Summary ---");
        int[] positions = getPositions(numberOfStudents);
        
        for (int index = 0; index < numberOfStudents; index++){
            int total = getTotalScore(index);
            double average = getAverageScore(index);
            System.out.println("Student " + (index + 1) + " -> Total: " + total + " | Average: " + average + " | Position: " + positions[index]);
        }
        
    }


    public static void collectScores(Scanner input, int numberOfStudents, int numberOfStudentQuizzes){
        for (int index = 0; index < numberOfStudents; index++) {
            System.out.println("\n--- Entering Scores for Student " + (index + 1) + " ---");
            for (int count = 0; count < numberOfStudentQuizzes; count++) {
                int validatedScore = 0;
                boolean isValid = false;
                
                while (!isValid) {
                    System.out.print("Score for Quiz " + (count + 1) + ": ");
                    int tempScore = input.nextInt();
                    
                    if (isValidScore(tempScore)) {
                        validatedScore = tempScore;
                        isValid = true;
                    } else {
                        System.out.println("Invalid score! Must be between 1 and 100.");
                    }
                }
                studentScores[index][count] = validatedScore;
            }
        }
    }


    public static boolean isValidScore(int score){
        return score >= 1 && score <= 100;
    }


    public static int getTotalScore(int studentIndex){
        int total = 0;
        for (int count = 0; count < studentScores[studentIndex].length; count++){
            total += studentScores[studentIndex][count];
        }
        return total;
    }


    public static double getAverageScore(int studentIndex){
        int total = getTotalScore(studentIndex);
        double totalQuizzes = studentScores[studentIndex].length;
        double average = total / totalQuizzes;
        return Math.round(average * 10.0) / 10.0;
    }


    public static int[] getPositions(int numberOfStudents){
        int[] positions = new int[numberOfStudents];
        
        for (int index = 0; index < numberOfStudents; index++){
            int currentTotal = getTotalScore(index);
            int rank = 1;
            
            for (int compareIndex = 0; compareIndex < numberOfStudents; compareIndex++){
                if (getTotalScore(compareIndex) > currentTotal){
                    rank++;
                }
            }
            positions[index] = rank;
        }
        return positions;
    }
}

