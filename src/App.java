import java.util.*;

public class App {

    public static boolean contains(int[] distancia_mod, int n, int p2){
            int p = 1;
            int r = n;
            int q;
            
            while (p <= r) {
                q = (p + r) / 2;
                if (distancia_mod[q-1] == p2) return true;
                else if (distancia_mod[q-1] > p2) r = q - 1;
            else p = q + 1;
        }
        
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextInt()) {
            int size_array;
            int count = 0;
            
            //Solicitando tamanho array
            size_array = in.nextInt();
            int[] circle = new int[size_array];
            
            //Preenchendo array
            int i;
            int sum = 0;
            for(i = 0; i < size_array; i++) {
                circle[i] = in.nextInt();
                sum += circle[i];
            }

            if (sum % 3 != 0){
                System.out.println("0");
                continue;
            }

            int distancia[] = new int[size_array+1];
            for (i = 1; i <= size_array; i++)
                distancia[i] = distancia[i-1] + circle[i-1];

            //Para se formar um triângulo devem ser cumpridos 3 requisitos:
            //  A soma das distâncias entre os pontos deve ser impar
            //  A quantidade de pontos deve ser maior que 2
            //  A distância entre os pontos deve ser igual

            int side = sum/3;
            int twoSide = side*2;

            // Percorre duas vezes para simular o array circular
            for (i = 0; i < size_array; i++) {
                int p = distancia[i];
                int p2 = p + side;
                int p3 = p + twoSide;

                if (contains(distancia, size_array, p2) && 
                    contains(distancia, size_array, p3))
                    count++;
            }

            System.out.println(count);
        }

        in.close();
    }

}
