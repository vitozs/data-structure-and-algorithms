import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatchingStrings {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < queries.size(); i++){
            int counter = 0;
            for(int j = 0; j < stringList.size(); j++){
                if(Objects.equals(queries.get(i), stringList.get(j))){
                    counter++;
                }
            }
            result.add(counter);
        }
        return result;
    }

}
