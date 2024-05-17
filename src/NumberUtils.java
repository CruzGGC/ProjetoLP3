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

    /**
     * Calcula a moda de uma lista de numeros.
     *
     * @param numeros lista de números
     * @return moda dos numeros
     * @throws IllegalArgumentException se a lista for nula, estiver vazia, contiver valores nulos ou contiver apenas um elemento
     */

    public static Double calcularModa(List<Double> numeros) {
        checkList(numeros);
        Map<Double, Integer> freqMap = new HashMap<>();
        for (Double num : numeros) {
            checkNumber(num);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        Double moda = Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        return moda;
    }

    /**
     * Ordena uma lista de numeros por ordem ascendente ou descendente.
     *
     * @param numeros lista de números
     * @param crescente um booleana que indica se a lista deve ser ordenada por ordem ascendente ou descendente
     * @return a lista ordenada de numeros
     * @throws IllegalArgumentException se a lista for nula, estiver vazia, contiver valores nulos ou contiver apenas um elemento
     */

    public static List<Double> ordenarLista(List<Double> numeros, boolean crescente) {
        checkList(numeros);
        List<Double> sortedList = new ArrayList<>(numeros);
        if (crescente) {
            Collections.sort(sortedList);
        } else {
            sortedList.sort(Collections.reverseOrder());
        }
        return sortedList;
    }

    /**
     * Verifica se uma lista de numeros é valida.
     *
     * @param numeros lista de números
     * @throws IllegalArgumentException se a lista for nula, estiver vazia, contiver valores nulos ou contiver apenas um elemento
     */

    private static void checkList(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
        }
        if (numeros.contains(null)) {
            throw new IllegalArgumentException("A lista não pode conter valores nulos");
        }
        if (numeros.size() == 1) {
            throw new IllegalArgumentException("A lista deve conter mais de um elemento");
        }
    }

    /**
     * Verifica se um numero é valido.
     *
     * @param num o numero a verificar
     * @throws IllegalArgumentException se o numero for NaN ou infinito
     */

    private static void checkNumber(Double num) {
        if (num.isNaN() || num.isInfinite()) {
            throw new IllegalArgumentException("A lista não pode conter NaN ou infinito");
        }
    }
}