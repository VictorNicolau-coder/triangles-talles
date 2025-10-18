import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextInt()) {
            int size_array;
            int triangleCount = 0;
            
            //Solicitando tamanho array
            size_array = in.nextInt();
            int[] circle = new int[size_array];
            
            //Preenchendo array
            int i;
            int sum_array = 0;
            for(i = 0; i < size_array; i++) {
                circle[i] = in.nextInt();
                sum_array += circle[i];
            }

            //Para se formar um triângulo devem ser cumpridos 3 requisitos:
            //  A soma das distâncias entre os pontos deve ser impar
            //  A quantidade de pontos deve ser maior que 2
            //  A distância entre os pontos deve ser igual

            int side = sum_array/3;
            int prefix = 0;
            int pointCount = 0;

            // Percorre duas vezes para simular o array circular
            for (i = 0; i < 2 * size_array - 1; i++) {
                prefix += circle[i % size_array];

                if (prefix == 2 * side) triangleCount += pointCount;
                if (prefix == side) pointCount++;
            }

            System.out.println(triangleCount);
        }

        in.close();
    }

}
