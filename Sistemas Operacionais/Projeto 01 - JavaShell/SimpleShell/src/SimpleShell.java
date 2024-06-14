import java.io.*;
import java.util.*;

public class SimpleShell {

    private static List<String> history = new ArrayList<>();
    private static File currentDirectory = new File(System.getProperty("user.dir"));

    public static void main(String[] args) throws java.io.IOException {
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("jsh> ");
            commandLine = console.readLine();

            if (commandLine.equals("")) {
                continue;
            }

            history.add(commandLine);

            if (commandLine.equals("history")) {
                printHistory();
                continue;
            } else if (commandLine.equals("!!")) {
                if (history.size() < 2) {
                    System.out.println("No previous command to execute.");
                    continue;
                }
                commandLine = history.get(history.size() - 2);
                System.out.println(commandLine);
            } else if (commandLine.startsWith("!")) {
                try {
                    int index = Integer.parseInt(commandLine.substring(1));
                    if (index < 0 || index >= history.size()) {
                        System.out.println("No such command in history.");
                        continue;
                    }
                    commandLine = history.get(index);
                    System.out.println(commandLine);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid command number.");
                    continue;
                }
            }

            String[] commandParts = commandLine.split(" ");
            String command = commandParts[0];
            List<String> commandList = Arrays.asList(commandParts);

            if (command.equals("cd")) {
                if (commandParts.length == 1) {
                    currentDirectory = new File(System.getProperty("user.home"));
                } else {
                    File newDir = new File(currentDirectory, commandParts[1]);
                    if (newDir.exists() && newDir.isDirectory()) {
                        currentDirectory = newDir;
                    } else {
                        System.out.println("No such directory.");
                    }
                }
                continue;
            }

            ProcessBuilder processBuilder = new ProcessBuilder(commandList);
            processBuilder.directory(currentDirectory);
            try {
                Process process = processBuilder.start();
                InputStream inputStream = process.getInputStream();
                InputStream errorStream = process.getErrorStream();
                printStream(inputStream);
                printStream(errorStream);
            } catch (IOException e) {
                System.out.println("Command execution failed: " + e.getMessage());
            }
        }
    }

    private static void printStream(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static void printHistory() {
        for (int i = 0; i < history.size(); i++) {
            System.out.println(i + " " + history.get(i));
        }
    }
}
