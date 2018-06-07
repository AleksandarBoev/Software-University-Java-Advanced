import java.util.*;

public class P09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //regex for ip: [0-9\.]+
        //split po "[=\\s]" i taka tokens[1] shte e ip-to, a posledniq token shte e user-ut

        Map<String, Map<String, Integer>> userIpAddresses = new TreeMap<>();

        String input;
        while (!"end".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("[=\\s]");

            String ipAddress = tokens[1];
            String user = tokens[tokens.length - 1];

            if (!userIpAddresses.containsKey(user)) { //if there is no such user
                Map<String, Integer> ipAddressTimesUsed = new LinkedHashMap<>();
                ipAddressTimesUsed.put(ipAddress, 1);
                userIpAddresses.put(user, ipAddressTimesUsed);
            } else if (!userIpAddresses.get(user).containsKey(ipAddress)) { // if this is the first time the user is using this ip
                userIpAddresses.get(user).put(ipAddress, 1);
            } else { // if there is such a user and he has already used this ip before
                Integer usedTimes = userIpAddresses.get(user).get(ipAddress) + 1;
                userIpAddresses.get(user).put(ipAddress, usedTimes);
            }

        }

        for (Map.Entry<String, Map<String, Integer>> userIpAddress : userIpAddresses.entrySet()) {
            System.out.println(userIpAddress.getKey() + ":");

            List<String> output = new LinkedList<>(); // TODO there has to be a smarter way of doing this
            for (Map.Entry<String, Integer> ipAddressUsage : userIpAddress.getValue().entrySet()) {
                output.add(String.format("%s => %d", ipAddressUsage.getKey(), ipAddressUsage.getValue()));
            }

            System.out.println(String.join(", ", output) + ".");
        }

        //main ends here
    }
}
