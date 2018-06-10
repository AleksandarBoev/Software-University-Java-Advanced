import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class P03TheDharmaInitiative {
    public static void main(String[] args) throws IOException { // 90/100
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<Long, String>> facilityFacnumPersonName = new LinkedHashMap<>();

        Map<String, String> stationDescription = new TreeMap<>();

        stationDescription.put("Arrow", "The Arrow station: Development of defensive strategies, and Intelligence gathering.");
        stationDescription.put("Hydra", "The Hydra station: Zoological Research.");
        stationDescription.put("Flame", "The Flame station: Communication.");
        stationDescription.put("Pearl", "The Pearl station: Psychological Research and/or Observation.");
        stationDescription.put("Orchid", "The Orchid station: Space-time manipulation research, disguised as a Botanical station.");
//possible problem: if a facility is not typed in, should it be printed with 0 members when the final command is DHARMA Initiative?
        //the facility num should be unique for the facility or for all people. What if a duplicated facility number appears. What should be done?
        //i think they guarantee that it will be unique
        String input;
        while (!"Recruit".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");

            String personName = tokens[0];
            long facilityNum = Long.parseLong(tokens[1]);
            String facility = tokens[2];
            if (!isValidFacility(facility)) {
                continue;
            }

            if (!facilityFacnumPersonName.containsKey(facility)) {
                Map<Long, String> facnumPersonName = new LinkedHashMap<>();
                facnumPersonName.put(facilityNum, personName);

                facilityFacnumPersonName.put(facility, facnumPersonName);
            } else {
                facilityFacnumPersonName.get(facility).put(facilityNum, personName);
            }

        }

        String finalCommand = reader.readLine();
        if ("DHARMA Initiative".equals(finalCommand)) {
            StringBuilder sb = new StringBuilder();

            facilityFacnumPersonName.entrySet().stream()
                    .sorted((kvp1, kvp2) -> {
                        Integer numberOfPeopleInFirstFacility = kvp1.getValue().size(); // .size() returns primitive int, which does NOT have the compareTo
                        Integer numberOfPeopleInSecondFacility = kvp2.getValue().size(); //method, but Integer has it.

                        int comparisonResult = numberOfPeopleInSecondFacility.compareTo(numberOfPeopleInFirstFacility); // descending order
                        if (comparisonResult != 0) {
                            return comparisonResult;
                        } else {
                            return kvp1.getKey().compareTo(kvp2.getKey());
                        }
                    }).forEach(kvp -> {
                sb.append(String.format("The %s has %d DHARMA recruits in it.%n", kvp.getKey(), kvp.getValue().size()));
            });

            for (String station : stationDescription.keySet()) {
                if (!sb.toString().contains(station)) {
                    sb.append(String.format("The %s has 0 DHARMA recruits in it.%n", station));
                }
            }

            System.out.println(sb);
        } else {
            if (!isValidFacility(finalCommand)) {
                System.out.println("DHARMA Initiative does not have such a station!");
            } else {
                if (!facilityFacnumPersonName.containsKey(finalCommand)) {
                    System.out.println("No recruits.");
                    return;
                }
                System.out.println(stationDescription.get(finalCommand));

                facilityFacnumPersonName.get(finalCommand).entrySet().stream()
                        .sorted((kvp1, kvp2) -> {
                            return kvp2.getKey().compareTo(kvp1.getKey());
                        }).forEach(kvp -> {

                    System.out.printf("###%s - %d%n", kvp.getValue(), kvp.getKey());
                });

            }
        }
        //main ends here
    }

    static boolean isValidFacility(String facility) {
        return "Hydra".equals(facility) || "Arrow".equals(facility) || "Flame".equals(facility)
        || "Pearl".equals(facility) ||  "Orchid".equals(facility); // ignore casing?

    }

}


//Johny Bravo:12345:Hydra
//Nakov Svetlin:99999:Arrow
//Pesho:66666:Orchid
//Rado Rado:12346:Flame
//Ivan Ivanov:89594:Pearl