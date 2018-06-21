import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> contestPassword = new LinkedHashMap<>();

        String input;
        while (!"end of contests".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            contestPassword.put(tokens[0], tokens[1]);
        }

        Map<String, StudentInfo> nameInfo = new LinkedHashMap<>(); // moje i tree map, za da ne sortiram posle, NO shte trqbva i v klasut da go promenq

        while (!"end of submissions".equals(input = reader.readLine())) {
            String[] tokens = input.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String studentName = tokens[2];
            int contestPoints = Integer.parseInt(tokens[3]);

            if (!contestPassword.containsKey(contest)) // if there is no such contest
                continue;

            if (!contestPassword.get(contest).equals(password)) // if the password ofr the contest is not correct
                continue;

            //"If you receive the same contest and the same user update the points only if the new ones are more than the older ones."
            if (!nameInfo.containsKey(studentName)) { //if there is no such student, create one
                Map<String, Integer> currentContestPoints = new LinkedHashMap<>();

                currentContestPoints.put(contest, contestPoints); // contestPoints is null???
                StudentInfo currentStudentInfo = new StudentInfo(contestPoints, currentContestPoints);

                nameInfo.put(studentName, currentStudentInfo);
            } else { //if there is such a student
//                int oldTotalPoints = nameInfo.get(studentName).getTotalPoints();
//                nameInfo.get(studentName).setTotalPoints(oldTotalPoints + contestPoints);

                boolean hasBeenInContest = nameInfo.get(studentName).getContestPoints().containsKey(contest);

                if (!hasBeenInContest) { //ako za pruv put e na takova sustezanie
                    nameInfo.get(studentName).getContestPoints().put(contest, contestPoints);
                } else { //ako e bil na takova sustezanie
                    int oldPoints = nameInfo.get(studentName).getContestPoints().get(contest);
                    int finalPoints = Math.max(oldPoints, contestPoints);

                    nameInfo.get(studentName).getContestPoints().put(contest, finalPoints);
                }
            }
        }

        reader.close();

        int bestCandidatePoints = Integer.MIN_VALUE;
        String bestCandidateName = "";
        for (Map.Entry<String, StudentInfo> studentInfoEntry : nameInfo.entrySet()) {
            if (studentInfoEntry.getValue().calculateAndGetTotalPoints() > bestCandidatePoints) {
                bestCandidatePoints = studentInfoEntry.getValue().calculateAndGetTotalPoints();
                bestCandidateName = studentInfoEntry.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%nRanking:%n", bestCandidateName, bestCandidatePoints);

        nameInfo.entrySet().stream()
                .sorted((kvp1, kvp2) -> {
                    return kvp1.getKey().compareTo(kvp2.getKey());
                }).forEach(kvp -> { // sega e nameInfo entrySet, no veche podreden
            System.out.println(kvp.getKey());

            kvp.getValue().getContestPoints().entrySet().stream()
                    .sorted((contestPointskvp1, contestPointskvp2) -> {
                        return contestPointskvp2.getValue().compareTo(contestPointskvp1.getValue());
                    }).forEach(contestPointskvp -> {
                        //if there is a memory problem, use StringBuilder
                System.out.printf("#  %s -> %d%n", contestPointskvp.getKey(), contestPointskvp.getValue());
            });
        });

        //main ends here
    }
}

class StudentInfo {
//    private int totalPoints;
    private Map<String, Integer> contestPoints;

    public StudentInfo(int totalPoints, Map<String, Integer> contestPoints) {
//        this.totalPoints = totalPoints;
        this.contestPoints = contestPoints;
    }

//    public int getTotalPoints() {
//        return totalPoints;
//    }
//
//    public void setTotalPoints(int totalPoints) {
//        this.totalPoints = totalPoints;
//    }

    public Map<String, Integer> getContestPoints() {
        return contestPoints;
    }

    public void setContestPoints(Map<String, Integer> contestPoints) {
        this.contestPoints = contestPoints;
    }

    public int calculateAndGetTotalPoints() {
        int sum = 0;
        for (Integer currentContestPoints : contestPoints.values()) {
            sum += currentContestPoints;
        }
        return sum;
    }
}
