import java.util.Scanner;

public class P10ModifyABit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int position = scanner.nextInt();
        int bitValue = scanner.nextInt();

        if (bitValue == 1) {
            bitValue = 1 << position; // edinicata biva premestena nalqvo tolkova puti kolkoto e neobhodimo (nai-otdqsno e nuleva poziciq)
            number = number | bitValue; // vseki bit se sravnqva s " | ", t.e. ot dvata bita e dostatuchno ediniqt da e 1 za da se vurne 1
        } else {
            bitValue = 1 << position;
            bitValue = ~bitValue; // vsichko stava 1 osven edinicata i taka nulata e na poziciq
            number = number & bitValue; // kudeto v number ima edinica, tq shte bude zapazena zashtoto 1 & 1 = 1, no kudeto e 0 v bitValue shte e 0 i v number
            // 0 & 0 = 0, 0 & 1 = 0
        }

        System.out.println(number);
        

        //main ends here
    }
}
