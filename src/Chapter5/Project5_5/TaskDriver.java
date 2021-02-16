package Chapter5.Project5_5;

public class TaskDriver
{
    public static void main(String[] args)
    {
        Task t1 = new Task(10, 30);
        Task t2 = new Task(20, 50);

        System.out.println("Priority of Task 1: " + t1.getPriority());
        System.out.println("Priority of Task 2: " + t2.getPriority());
        System.out.println();

        int priorityToAssignT1 = 20;
        int priorityToAssignT2 = 0;

        System.out.println("Setting Task 1 priority to " + priorityToAssignT1);
        System.out.println("Setting Task 2 priority to " + priorityToAssignT2);
        System.out.println();

        t1.setPriority(priorityToAssignT1);
        t2.setPriority(priorityToAssignT2);

        System.out.println("New Task 1 priority: " + t1.getPriority());
        System.out.println("New Task 2 priority: " + t2.getPriority());
        System.out.println();

        System.out.println("Result of comparing t1 to t2: " + t1.compareTo(t2));
        System.out.println();

        // identical code, but now comparing complexity.

        System.out.println("Task 1 complexity: " + t1.getComplexity());
        System.out.println("Task 2 complexity: " + t2.getComplexity());
        System.out.println();

        int complexityToAssignT1 = 40;
        int complexityToAssignT2 = 60;

        System.out.println("Setting Task 1 complexity to " + complexityToAssignT1);
        System.out.println("Setting Task 2 complexity to " + complexityToAssignT2);
        System.out.println();

        t1.setPriority(complexityToAssignT1);
        t2.setPriority(complexityToAssignT2);

        System.out.println("New Task 1 complexity: " + t1.getComplexity());
        System.out.println("New Task 2 complexity: " + t2.getComplexity());
        System.out.println();

        System.out.println("Result of comparing t1 to t2: " + t1.compareTo(t2));

    }
}
