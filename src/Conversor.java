import java.util.HashMap;
import java.util.Map;

public class Conversor {


    public double converter(double valor, Map<String, Double> taxas, String pesoAtual, String pesoDestino){
        return (valor * taxas.get(pesoDestino));
    }










}
