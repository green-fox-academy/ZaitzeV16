public class TodoPrint {
    public static void main(String... args) {
        String todoText = " - Buy milk\n";
        // Add "My todo:" to the beginning of the todoText
        // Add " - Download games" to the end of the todoText
        // Add " - Diablo" to the end of the todoText but with indention
        String task1 = "My todo:";
        String task2 = " - Download games";
        String task3 = " - Diablo";

        // Expected output:

        // My todo:
        //  - Buy milk
        //  - Download games
        //      - Diablo

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(todoText);

        stringBuilder.insert(0, task1.concat("\n"));
        stringBuilder.insert(stringBuilder.length(), task2);
        stringBuilder.append("\n\t");
        stringBuilder.insert(stringBuilder.length(), task3);

        todoText = stringBuilder.toString();

        System.out.println(todoText);
    }
}