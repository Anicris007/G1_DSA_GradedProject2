import java.util.Scanner;
import java.util.Stack;

public class SkyscraperConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the total number of floors in the building:");
        int totalFloors = scanner.nextInt();
        
        int[] floors = new int[totalFloors];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < totalFloors; i++) {
            System.out.println("Enter the floor size given on day : " + (i+1));
            floors[i] = scanner.nextInt();
        }
        
        int max = totalFloors;
        
        System.out.println("The order of construction is as follows:");
        for (int i = 0; i < totalFloors; i++) {
            System.out.println("Day: " + (i+1));
            stack.push(floors[i]);
            boolean flag = false;
            
            while (!stack.isEmpty() && stack.peek() == max) {
                if (!flag) {
                    flag = true;
                }
                System.out.print(stack.pop() + " ");
                max--;
            }
            if (flag) {
                System.out.println();
            } else {
                System.out.println(" ");
            }
        }
        scanner.close();
    }
}


// Enter the total number of floors in the building:
// 5
// Enter the floor size given on day : 1
// 5
// Enter the floor size given on day : 2
// 3
// Enter the floor size given on day : 3
// 4
// Enter the floor size given on day : 4
// 1
// Enter the floor size given on day : 5
// 2
// The order of construction is as follows:
// Day: 1
// 5 
// Day: 2
 
// Day: 3
// 4 3 
// Day: 4
 
// Day: 5
// 2 1 



