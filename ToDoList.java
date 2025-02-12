import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        System.out.println("Welcome to your task manager!");
        System.out.println("First, let's get set up. What is your name?");
        String name = scanner.nextLine();
        System.out.println("Welcome " + name + "!");

        while (true) { // Loop to keep the menu active
            System.out.println("\nMenu:");
            System.out.println("1) New Task");
            System.out.println("2) Remove Task");
            System.out.println("3) Task List");
            System.out.println("4) Exit");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Discard invalid input
                continue; // Restart loop
            }

            int selectedMenuItem = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (selectedMenuItem) {
                case 1:
                    System.out.println("Enter a new task:");
                    String task = scanner.nextLine();
                    newTask(task, tasks);
                    break;
                case 2:
                    removeTask(tasks, scanner);
                    break;
                case 3:
                    viewTasks(tasks);
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    // ✅ Method to add a new task
    public static void newTask(String task, ArrayList<String> taskList) {
        System.out.println("Adding new task: " + task);
        taskList.add(task);
    }

    // ✅ Method to view tasks
    public static void viewTasks(ArrayList<String> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available!");
        } else {
            System.out.println("Your Tasks:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
    }

    // ✅ Method to remove a task with validation
    public static void removeTask(ArrayList<String> taskList, Scanner scanner) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available!");
            return; // Exit method early
        }

        System.out.println("Which task would you like to remove?");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }

        while (true) {
            System.out.print("Enter the task number to remove: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid task number.");
                scanner.next(); // Discard invalid input
                continue; // Restart loop
            }

            int taskToRemove = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (taskToRemove < 1 || taskToRemove > taskList.size()) {
                System.out.println("Invalid number! Please select a valid task.");
            } else {
                System.out.println("Removing task: " + taskList.get(taskToRemove - 1));
                taskList.remove(taskToRemove - 1);
                break; // Exit loop after successful removal
            }
        }
    }
}
