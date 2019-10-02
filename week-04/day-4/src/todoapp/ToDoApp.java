package todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoApp {
  // fields

  // constructors

  // private methods

  // public methods
  public void controller(String[] args) {
    if (args.length == 0) {
      this.printOptions();
    } else {
      switch (args[0]) {
        case "-l":
          //    -l   Lists all the tasks
          this.printAllTasks();
          break;
        case "-a":
          //    -a [new task] -  Adds a new task
          this.addNewTask(args);
          break;
        case "-r":
          //    -r   Removes a task
          this.removeTaskByIndex(args);
          break;
        case "-c":
          //    -c   Completes a task
          this.checkTaskToDone(args);
          break;
        default:
          System.out.println("Unsupported argument!");
          System.out.println("Try these:\n");
          this.printOptions();
      }
    }
  }

  private void printAllTasks() {
    /**
     * This function calls getTodosFromFile() to open todos.txt,
     *  - checks if there are no todos - prints the corresponding message
     *  - else: prints todos with proper mark (done - undone)
     */

    List<String> todosList = getTodosFromFile();

    if (todosList.size() == 0) {
      System.out.println("No todos for today! :)");
    } else {
      for (int i = 1; i <= todosList.size(); i++) {
        String[] currTodo = todosList.get(i - 1).split(";");
        String doneMarker = ("done".equals(currTodo[currTodo.length - 1])) ? "[x]" : "[ ]";
        System.out.println(i + " - " + doneMarker + " " + currTodo[0]);
      }
    }
  }

  private void printOptions() {
    /**
     * Call when ran without arguments.
     * This function prints the available options of the application.
     */

    System.out.println(
        "Command Line ToDo application\n"
            + "=============================\n"
            + "\n"
            + "Command line arguments:\n"
            + "    -l   Lists all the tasks\n"
            + "    -a   Adds a new task\n"
            + "    -r   Removes an task\n"
            + "    -c   Completes an task");
  }

  private List<String> getTodosFromFile() {
    /**
     * Opens the todos.txt and returns the content.
     * Calls the removeOnlyWhiteSpaceElements() function if open and read
     *  was successful.
     *
     *      Exception:
     *                IOException - return empty ArrayList
     *
     *
     * @return ArrayList<String> - content of todos.txt file,
     *                             if IOException - return empty ArrayList
     */

    Path path = Paths.get(System.getProperty("user.dir") + "\\resources\\todos.txt");

    try {
      return this.removeOnlyWhiteSpaceElements(Files.readAllLines(path));
    } catch (IOException e) {
      System.out.println("File not found!");
      return new ArrayList<>();
    }
  }

  private void saveTodoToFile(List<String> todosList) {
    /**
     * Opens the todos.txt and saves the parameter to the file.
     * Calls the removeOnlyWhiteSpaceElements() function before saving.
     *
     * Prints the proper message according to the success of the save.
     *
     *      Exception:
     *                IOException - ignore
     *
     * @param todoList  List<String> - data to be saved to file
     */

    Path path = Paths.get(System.getProperty("user.dir") + "\\resources\\todos.txt");
    todosList = this.removeOnlyWhiteSpaceElements(todosList);

    try {
      Files.write(path, todosList);
      System.out.println("Saved successfully!");
      return;
    } catch (IOException e) {
      System.out.println("Save failed!");
      return;
    }
  }

  private List<String> removeOnlyWhiteSpaceElements(List<String> todosList) {
    /**
     * This function removes every element from the parameter, if the element:
     *      - is `null`
     *      - is empty String
     *      - contains only whitespace characters
     *
     *
     * @param todosList   List<String> - list to be cleaned from nulls,
     *                                   empty and whitespace-only Strings
     *
     * @return todosList, List<String> the parameter without nulls,
     *                                 empty and whitespace-only Strings
     */

    for (int i = todosList.size() - 1; i >= 0; i--) {
      if (todosList.get(i).isBlank()) {
        todosList.remove(i);
      }
    }
    return todosList;
  }

  private void addNewTask(String[] args) {
    /**
     * This function takes a String[] (args) as parameter,
     *  - checks if there are no additional arguments (task to add)
     *    - if so, prints the corresponding message and returns
     *  - calls the getTodosFromFile() function to open todos list,
     *  - appends it with the 2nd element of args (task) with `undone` tag,
     *  - calls saveTodoToFile(todos) with the updated list as parameter
     *  - and prints the proper message according to the success of the save.
     *
     *
     * @param task    String[] - args from the main function
     *                           (the 2nd item should be the task to add)
     */

    if (args.length < 2) {
      System.out.println("Unable to add: no task provided!");
      return;
    }

    List<String> todosList = getTodosFromFile();
    todosList.add(args[1] + ";undone");

    this.saveTodoToFile(todosList);
  }

  private int validateArgsIndex(String[] args) {
    /**
     * This function takes a String[] (args) as parameter,
     *
     *  - checks if there are no additional arguments
     *      - if so, prints the corresponding message and returns
     *
     *  - calls the getTodosFromFile() function to open todoslist,
     *
     *  - if number of task to remove (args[1]) is greater than
     *    the number of tasks in the todos.txt file or less than 0
     *      - prints the corresponding message and returns
     *
     *  - if the "number" (args[1]) is actually not a number,
     *      - catches NumberFormatException
     *      - prints the corresponding message and returns
     *
     *  - if no problem occurred, returns with the index of the targes task
     *
     *
     * @param task    String[] - args from the main function
     *                           (the 2nd item should be the task to add)
     *
     * @return targetIndex - int, index of the targeted task
     */

    List<String> todosList = getTodosFromFile();

    if (args.length < 2) {
      System.out.println("Unable to add: no index provided!");
      return -1;
    }

    try {
      if (todosList.size() < Integer.parseInt(args[1]) || Integer.parseInt(args[1]) < 1) {
        System.out.println("Unable to add: index is out of bound!");
        return -1;
      }
    } catch (NumberFormatException e) {
      System.out.println("Unable to add: index is not a number!");
      return -1;
    }

    // -1 because user starts indexing from 1, so the 2nd element is with index of 1
    return Integer.parseInt(args[1]) - 1;
  }

  private void removeTaskByIndex(String[] args) {
    /**
     * This function takes a String[] (args) as parameter,
     *
     *  - calls the getTodosFromFile() function to open todos list,
     *
     *  - removes the element from the todoList at index of (args[1] - 1)
     *
     *  - calls the saveTodoToFile() function with the todosList as parameter
     *      (saves the altered list to file)
     *
     *
     * @param task    String[] - args from the main function
     *                           (the 2nd item should be the task to add)
     */

    List<String> todosList = getTodosFromFile();

    int targetIndex = validateArgsIndex(args);
    if (targetIndex == -1) {
      return;
    }

    String[] targetTask = todosList.get(targetIndex).split(";");

    System.out.println("Removing: " + targetTask[0]);
    todosList.remove(targetIndex);

    this.saveTodoToFile(todosList);
  }

  private void checkTaskToDone(String[] args) {
    /**
     * This function takes a String[] (args) as parameter,
     *
     *  - calls the getTodosFromFile() function to open todos list,
     *
     *  - removes the element from the todoList at index of (args[1] - 1)
     *
     *  - calls the saveTodoToFile() function with the todosList as parameter
     *      (saves the altered list to file)
     *
     *
     * @param task    String[] - args from the main function
     *                           (the 2nd item should be the task to add)
     */

    List<String> todosList = getTodosFromFile();

    int targetIndex = validateArgsIndex(args);
    if (targetIndex == -1) {
      return;
    }

    String[] targetTask = todosList.get(targetIndex).split(";");
    if ("done".equals(targetTask[1])) {
      System.out.println(targetTask[0] + " is already done!");
      return;
    }

    System.out.println(targetTask[0] + " is done");
    todosList.set(targetIndex, targetTask[0] + ";done");

    this.saveTodoToFile(todosList);
  }
}
