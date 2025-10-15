import java.util.*;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int size_array, ultimo_indice;
        int t_count = 0;
        
        //Requesting size array
        size_array = in.nextInt();
        ultimo_indice = size_array-1;
        int[] circle = new int[size_array];
        int[] circle_copy = new int[size_array];
        
        //Flling array size
        int i;
        for(i = 0; i < size_array; i++)
            circle[i] = in.nextShort();
        
        int sum = 0;
        //How many triangles are inside the circle?

        for (i = 0; i < size_array; i++) {

            int k = i;
            for (int j = 0; j < size_array; j++) {

                sum += circle[k];
                circle_copy[k] = circle[k];
                
                if (sum % 18 == 0){    
                    //Quantidade de elementos entre ponto incial e final é divisivel por 3?
                    System.out.println("Taa");
                    if (circle_copy.length % 3 == 0){
                        int size_array_sec = circle_copy.length / 3;

                        int arr_a[] = new int[size_array_sec];
                        int arr_b[] = new int[size_array_sec];
                        int arr_c[] = new int[size_array_sec];
                        
                        System.arraycopy(circle_copy, 0, arr_a, 0, size_array_sec);
                        System.arraycopy(circle_copy, size_array_sec, arr_b, 0, size_array_sec);
                        System.arraycopy(circle_copy, size_array_sec*2, arr_c, 0, size_array_sec);
                        
                        int soma_a = IntStream.of(arr_a).sum();
                        int soma_b = IntStream.of(arr_b).sum();
                        int soma_c = IntStream.of(arr_c).sum();
                        
                        if (soma_a == soma_b && soma_b == soma_c) t_count++;
                    }
                    
                    System.out.println("inicial point: " + i);
                    System.out.println("final point: " + k);
                }

                k++;
                if (k == ultimo_indice) k = 0;
            }

            System.out.println("soma = " + sum);
            sum = 0;
            Arrays.fill(circle_copy, 0);

        }

        System.out.println(t_count);
    }

}
