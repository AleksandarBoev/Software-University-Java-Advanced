import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class P11Robotics2 { // TODO solution gets 80/100 with 1 time exceed
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(";");

        DateTimeFormatter parseFormat =  DateTimeFormatter.ofPattern("H:mm:ss");
        LocalTime startTime = LocalTime.parse(reader.readLine(), parseFormat);
        DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("[HH:mm:ss]"); // doesn't want to add the brackets for some reason

        List<Robot2> robots = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            String[] robotInfo = tokens[i].split("-");

//            String robotName = robotInfo[0];
//            int requiredSecondsToFinishTask = Integer.parseInt(robotInfo[1]);

            Robot2 currentRobot = new Robot2(robotInfo[0], Integer.parseInt(robotInfo[1]), 1 + i);
            robots.add(currentRobot);
        }

        ArrayDeque<String> tasksQueue = new ArrayDeque<>();
        String task = "";
        while(!("End".equals(task = reader.readLine()))) {
            tasksQueue.add(task);
        }

        int secondCounter = 0;
        while (!tasksQueue.isEmpty()) {
            secondCounter++;

            boolean taskTaken = false;
            for (int index = 0; index < robots.size(); index++) {
                taskTaken = robots.get(index).getReadyToWorkTime() <= secondCounter;
                //if robots "readyToWorkTime" is less than
                if (taskTaken) {
                    System.out.printf("%s - %s [%s]%n", robots.get(index).getName(), tasksQueue.peek(), printFormat.format(startTime.plusSeconds(secondCounter)));
//                    System.out.println(robots.get(index).getName() + " - " + tasksQueue.peek() + " " +
//                            "[" + printFormat.format(startTime.plusSeconds(secondCounter)) + "]"); // faster than System.out.printf

                    robots.get(index).setReadyToWorkTime(robots.get(index).getReadyToWorkTime() + robots.get(index).getTimeToExecuteTask());
                    tasksQueue.remove();
                    break;
                }
            }

            if (!taskTaken) {
                tasksQueue.add(tasksQueue.remove());
            }
        }

        //main ends here
    }
}

class Robot2 {
    private String name;
    private int timeToExecuteTask;
    private int readyToWorkTime;

    public Robot2(String name, int timeToExecuteTask, int readyToWorkTime) {
        this.name = name;
        this.timeToExecuteTask = timeToExecuteTask;
        this.readyToWorkTime = readyToWorkTime;
    }

    public Robot2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeToExecuteTask() {
        return timeToExecuteTask;
    }

    public void setTimeToExecuteTask(int timeToExecuteTask) {
        this.timeToExecuteTask = timeToExecuteTask;
    }

    public int getReadyToWorkTime() {
        return readyToWorkTime;
    }

    public void setReadyToWorkTime(int readyToWorkTime) {
        this.readyToWorkTime = readyToWorkTime;
    }
}