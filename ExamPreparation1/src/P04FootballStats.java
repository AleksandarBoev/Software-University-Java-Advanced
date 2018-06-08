import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P04FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Pair<String, String>>> teamOpponentScore = new HashMap<>();

        String input = reader.readLine();
        while (!"Season End".equals(input)) {
            //RealMadrid - Barcelona result 5:0
            String[] tokens = input.split("( - | |:)");

            String team1Name = tokens[0];
            String team2Name = tokens[1];
            String team1Score = tokens[3] + ":" + tokens[4];
            String team2Score = tokens[4] + ":" + tokens[3];

            if (!teamOpponentScore.containsKey(team1Name)) {
                List<Pair<String, String>> pairList = new ArrayList<>();
                teamOpponentScore.put(team1Name, pairList);
            }

            if (!teamOpponentScore.containsKey(team2Name)) {
                List<Pair<String, String>> pairList = new ArrayList<>();
                teamOpponentScore.put(team2Name, pairList);
            }

            Pair<String, String> team1OpponentScore = new Pair<>(team2Name, team1Score);
            Pair<String, String> team2OpponentScore = new Pair<>(team1Name, team2Score);

            teamOpponentScore.get(team1Name).add(team1OpponentScore);
            teamOpponentScore.get(team2Name).add(team2OpponentScore);

            input = reader.readLine();
        }

        String[] outputTeams = reader.readLine().split(" ");
        for (int i = 0; i < outputTeams.length; i++) {
            String currentTeam = outputTeams[i];
            teamOpponentScore.get(outputTeams[i]).stream()
                    .sorted((pair1, pair2) -> {
                        return pair1.getKey().compareTo(pair2.getKey());
                    }).forEach(pair -> {
                System.out.printf("%s - %sd -> %s", currentTeam, pair.getKey(), pair.getValue());
            });
        }

        //main ends here
    }
}
