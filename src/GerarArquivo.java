import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerarArquivo {

    private static final String CAMINHO_ARQUIVO = "historico.txt";

    public void salvarConversao(String moedaOrigem, String moedaDestino, double valorOriginal, double valorConvertido) {
        try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO, true)) {
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            String linha = String.format("[%s] %.2f %s => %.2f %s%n",
                    dataHora, valorOriginal, moedaOrigem, valorConvertido, moedaDestino);

            writer.write(linha);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o histórico da conversão: " + e.getMessage());
        }
    }
}
