import java.util.*;

class ToDoList {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------");
        System.out.println("    Welcome to To-Do list Application    ");
        System.out.println("-----------------------------------------");
        LinkedList task = new LinkedList<>();
        menu(task);
    }

    static void menu(LinkedList task) {
        Scanner sc = new Scanner(System.in);
        Task obj = new Task();

        String Choice = "0";
        while (!Choice.equals("5")) {
            System.out.println("___________________________________________");
System.out.println("        1 --> Add Task");
System.out.println("        2 --> Mark as complete");
System.out.println("        3 --> Remove Task");
System.out.println("        4 --> View the Task");
System.out.println("        5 --> Exit");
System.out.println("___________________________________________");
            
            
            
            System.out.print("Enter Your Choice : ");
            System.out.println();
            Choice = sc.nextLine();
            // sc.nextLine();
            // System.out.println(Choice);
            switch (Choice) {
                case "1":
                    obj.addTask(task);
                    break;
                case "2":
                    obj.markAsComplete(task);
                    break;
                case "3":
                    obj.removeTask(task);
                    break;
                case "4":
                    obj.viewTask(task);
                    break;
                case "5":
                    System.out.println("Thank you for using System...");
                    break;
                default:
                    System.out.println("Invalid Choice ! please Enter Proper Choice...");
                    break;
            }
        }
    }

}

class Task {
    Scanner sc = new Scanner(System.in);
    String name;
    Boolean mark_as_Complete;

    public Task() {

    }

    @Override
    public String toString() {
        return "Task Name : " + name + ", Complete : " + mark_as_Complete;
    }

    public Task(String name) {
        this.name = name;
        this.mark_as_Complete = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMark_as_Complete() {
        return mark_as_Complete;
    }

    public void setMark_as_Complete(Boolean mark_as_Complete) {
        this.mark_as_Complete = mark_as_Complete;
    }

    void addTask(LinkedList task) {
        System.out.print("Enter Task you want to Add :");
        String name = sc.nextLine();
        task.add(new Task(name));
    }

    void markAsComplete(LinkedList task) {
    System.out.println();
    for (Object t : task) {
        System.out.println(t);
    }

    System.out.println("Enter A Task name You want to make it Mark As complete :");
    String mName = sc.nextLine();

    boolean found = false;

    for (Object obj : task) {
        Task t = (Task) obj;

        if (t.getName().equalsIgnoreCase(mName)) {
            t.mark_as_Complete = true;
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Task Not Found !");
    }

    System.out.println();
    for (Object t : task) {
        System.out.println(t);
    }
}

    void removeTask(LinkedList task) {
    System.out.println();
    for (Object t : task) {
        System.out.println(t);
    }

    System.out.println("Enter A Task name You want to Delete :");
    String mName = sc.nextLine();

    boolean found = false;

    Iterator it = task.iterator();

    while (it.hasNext()) {
        Task t = (Task) it.next();

        if (t.getName().equalsIgnoreCase(mName)) {
            it.remove();
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Task Not Found !");
    }

    System.out.println();
    for (Object t : task) {
        System.out.println(t);
    }
}

    void viewTask(LinkedList task) {
        // System.out.println(task);
        System.out.println("TASK LIST :");
        System.out.println("--------------------------------------------");
        for (Object t : task) {
            System.out.println(t);
        }
        System.out.println("--------------------------------------------");

    }
}