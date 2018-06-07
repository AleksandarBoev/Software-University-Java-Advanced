import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/** problematic input (if startTime was "12:59:03" there wouldn't be a problem)
 *ROB-15;SS2-10;NX8000-3
 * 23:59:30
 * detail
 * glass
 * wood
 * apple
 * detail
 * glass
 * wood
 * apple
 * detail
 * glass
 * wood
 * apple
 * detail
 * glass
 * wood
 * apple
 * End
 *
 * output is:
 * ROB - detail [23:59:31]
 * SS2 - glass [23:59:32]
 * NX8000 - wood [23:59:33]
 * NX8000 - glass [23:59:36]
 * NX8000 - detail [23:59:39]
 * SS2 - apple [23:59:42]
 * NX8000 - detail [23:59:43]
 * ROB - apple [23:59:46] (rob gets all the job because his "readyToWork" is smaller than 23:59:46 cuz it is 00:00:something)
 * ROB - apple [23:59:47]
 * ROB - detail [23:59:48]
 * ROB - wood [23:59:49]
 * ROB - apple [23:59:50]
 * ROB - glass [23:59:51]
 * ROB - wood [23:59:52]
 * ROB - glass [23:59:53]
 * ROB - wood [23:59:54]
 */


public class P11Robotics { // TODO solution gets 40/100 with 1 time exceed and 2 wrong answers. For info on wrong answers look above
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(";");

        DateTimeFormatter parseFormat =  DateTimeFormatter.ofPattern("H:mm:ss");
        LocalTime startTime = LocalTime.parse(reader.readLine(), parseFormat);
        DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("[HH:mm:ss]"); // doesn't want to add the brackets for some reason

        List<Robot> robots = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            String[] robotInfo = tokens[i].split("-");

            String robotName = robotInfo[0];
            int requiredSecondsToFinishTask = Integer.parseInt(robotInfo[1]);

            Robot currentRobot = new Robot(robotName, requiredSecondsToFinishTask, startTime.plusSeconds(1 + i));
            // .plusSeconds(1 + i), because if the input time is 23:59:59 then that breaks everything
            // startTime as final parameter - robot is ready from the beginning. LocalTime variables are not like arrays. No need to clone them.
            robots.add(currentRobot);
        }

        ArrayDeque<String> tasksQueue = new ArrayDeque<>();
        String task = "";
        while(!("End".equals(task = reader.readLine()))) {
            tasksQueue.add(task);
        }

        while (!tasksQueue.isEmpty()) {
            startTime = startTime.plusSeconds(1);

            boolean taskTaken = false;
            for (int index = 0; index < robots.size(); index++) {
                taskTaken = robots.get(index).getReadyToWorkTime().compareTo(startTime) == -1
                        || robots.get(index).getReadyToWorkTime().compareTo(startTime) == 0;
                //if robots "readyToWorkTime" is less than
                if (taskTaken) {
//                    System.out.printf("%s - %s [%s]%n", robots.get(index).getName(), tasksQueue.peek(), printFormat.format(startTime));
                    System.out.println(robots.get(index).getName() + " - " + tasksQueue.peek() + " " +
                            "[" + printFormat.format(startTime) + "]"); // faster than System.out.printf

                    robots.get(index).setReadyToWorkTime(startTime.plusSeconds(robots.get(index).getTimeToExecuteTask()));
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

class Robot {
    private String name;
    private int timeToExecuteTask;
    private LocalTime readyToWorkTime;

    public Robot(String name, int timeToExecuteTask, LocalTime readyToWorkTime) {
        this.name = name;
        this.timeToExecuteTask = timeToExecuteTask;
        this.readyToWorkTime = readyToWorkTime;
    }

    public Robot() {
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

    public LocalTime getReadyToWorkTime() {
        return readyToWorkTime;
    }

    public void setReadyToWorkTime(LocalTime readyToWorkTime) {
        this.readyToWorkTime = readyToWorkTime;
    }
}