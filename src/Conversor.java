import java.util.Map;

public class Conversor {

    public double converter(double valor, Map<String, Double> taxas, String moedaDestino) {
        if (!taxas.containsKey(moedaDestino)) {
            throw new IllegalArgumentException("Moeda de origem ou destino não encontrada nas taxas fornecidas.");
        }


        double taxaDestino = taxas.get(moedaDestino);

        // Conversão correta baseada em uma moeda base (normalmente USD)
        double valorConvertido = valor  * taxaDestino;

        return valorConvertido;
    }
}
