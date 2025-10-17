import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextInt()) {
            int size_array;
            int t_count = 0;
            
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
            
            //Para se formar um triangulo devem ser cumpridos 3 requisitos:
            //  A soma das distâncias entre os pontos deve ser impar
            //  A quantidade de pontos deve ser maior que 2
            //  A distancia entre os pontos devem ser iguais
            
            if (sum_array % 3 == 0 && size_array > 2){
                int size_side = sum_array/3;

                for (i = 0; i < size_array; i++) {

                    int sum = 0;
                    int p_count = 0;
                    int k = i;
                    
                    for (int j = 0; j < size_array; j++) {
                        sum += circle[k];
                        
                        if (sum % size_side == 0) p_count++;

                        k++;
                        if (k > size_array - 1) k = 0;
                    }
                    
                    if (p_count == 3) t_count++;
                }

                //Para cada triangulo haverão três pontos
                //significa então que para cada aparição de um triangulo terão outros dois aparecendo
                System.out.println(t_count/3);
            } else {
                System.out.println(0);
            }
        }

        in.close();
    }

}
