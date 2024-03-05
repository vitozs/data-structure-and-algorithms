import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>(2);
        int bob = 0;
        int alice = 0;
        for(int i = 0; i < a.size(); i++){

            if(a.get(i) > b.get(i)){
                alice++;
            }

            if(a.get(i) < b.get(i)){
                bob++;
            }

        }
        result.add(alice);
        result.add(bob);

        return result;
    }
}
