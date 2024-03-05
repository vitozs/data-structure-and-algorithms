import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        List<Integer> diagonal1 = new ArrayList<>();
        List<Integer> diagonal2 = new ArrayList<>();
        // Write your code here
        for(int i =0; i < 3; i++){
            for(List<Integer> arrays : arr){
                diagonal1.add(arrays.get(i));
            }
        }
        for(int i =3; 3 >= i && i > 0; i--){
            for(List<Integer> arrays : arr){
                diagonal1.add(arrays.get(i-1));
            }
        }

        return somaDiagonais(diagonal2) - somaDiagonais(diagonal1);

    }

    public static int somaDiagonais(List<Integer> diagonal){
        int soma = 0;
        for(Integer nums : diagonal){
            nums += soma;
        }
        return soma;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
