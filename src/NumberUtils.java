import java.util.*;

/**
 * Esta classe fornece metodos utilitarios para efetuar operacoes numa lista de numeros.
 */
public class NumberUtils {

    /**
     * Calcula a media de uma lista de numeros.
     *
     * @param numeros lista de numeros
     * @return media dos numeros
     * @throws IllegalArgumentException se a lista for nula, estiver vazia, contiver valores nulos ou contiver apenas um elemento
     */

    public static double calcularMedia(List<Double> numeros) {
        checkList(numeros);
        double soma = 0;
        for (Double num : numeros) {
            checkNumber(num);
            soma += num;
        }
        return soma / numeros.size();
    }

    /**
     * Calcula a mediana de uma lista de numeros.
     *
     * @param numeros lista de números
     * @return mediana dos numeros
     * @throws IllegalArgumentException se a lista for nula, estiver vazia, contiver valores nulos ou contiver apenas um elemento
     */

    public static double calcularMediana(List<Double> numeros) {
        checkList(numeros);
        List<Double> sortedList = new ArrayList<>(numeros);
        Collections.sort(sortedList);
        int meio = sortedList.size() / 2;
        if (sortedList.size() % 2 == 0) {
            return (sortedList.get(meio - 1) + sortedList.get(meio)) / 2.0;
        } else {
            return sortedList.get(meio);
        }
    }
}
