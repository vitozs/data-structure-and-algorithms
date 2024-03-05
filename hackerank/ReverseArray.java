import java.util.ArrayList;
import java.util.List;

public class ReverseArray {
    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        List<Integer> lista = new ArrayList<>();
        for(int i = a.size() ; a.size() >= i && i > 0; i--){
            lista.add(a.get(i- 1));
        }
        return lista;

    }
}
