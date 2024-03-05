import java.util.List;

public class SimpleArraySum {
    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        int sum = 0;
        for(Integer num : ar){
            sum += num;
        }

        return sum;
    }
}
