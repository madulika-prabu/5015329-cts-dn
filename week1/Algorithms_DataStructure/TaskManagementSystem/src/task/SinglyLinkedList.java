package task;

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Search a task by ID
    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete task.");
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.task.getTaskId().equals(taskId)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found.");
            return;
        }

        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        Task task1 = new Task("T001", "Design the UI", "Pending");
        Task task2 = new Task("T002", "Implement the backend", "In Progress");
        Task task3 = new Task("T003", "Write unit tests", "Pending");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        System.out.println("Tasks after adding:");
        taskList.traverseTasks();

        System.out.println("\nSearching for T002:");
        Task searchResult = taskList.searchTask("T002");
        if (searchResult != null) {
            System.out.println("Task found: " + searchResult);
        } else {
            System.out.println("Task not found.");
        }

        taskList.deleteTask("T002");
        System.out.println("\nTasks after deleting T002:");
        taskList.traverseTasks();
    }
}
