import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static class Conversao {
        String de;
        String para;

        Conversao(String de, String para) {
            this.de = de;
            this.para = para;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, Conversao> opcoes = new HashMap<>();
        opcoes.put(1, new Conversao("USD", "ARS"));
        opcoes.put(2, new Conversao("ARS", "USD"));
        opcoes.put(3, new Conversao("USD", "BRL"));
        opcoes.put(4, new Conversao("BRL", "USD"));
        opcoes.put(5, new Conversao("USD", "COP"));
        opcoes.put(6, new Conversao("COP", "USD"));
        opcoes.put(7, new Conversao("AOA", "USD"));

        int opcao = 0;

        while (opcao != 8) {
            System.out.println("==========================================\n" +
                    "[ Seja bem-vindo/a ao conversor de Moeda ] \n\n" +
                    "1) Dólar => Peso Argentino\n" +
                    "2) Peso Argentino => Dólar\n" +
                    "3) Dólar => Real BR\n" +
                    "4) Real BR => Dólar\n" +
                    "5) Dólar => Peso Colombiano\n" +
                    "6) Peso Colombiano => Dólar\n" +
                    "7) Kwanza (Angola) => Dólar\n" +
                    "8) Sair\n" +
                    "==========================================");
            System.out.print("Escolha uma opção válida: ");
            opcao = scan.nextInt();

            if (opcao >= 1 && opcao <= 7) {
                Conversao conversao = opcoes.get(opcao);
                System.out.print("Digite o valor que deseja converter: ");
                double valor = scan.nextDouble();
                realizarConversao(conversao.de, conversao.para, valor);
            } else if (opcao != 7) {
                System.out.println("Opção inválida...\n");
            }
        }

        System.out.println("Programa finalizado com sucesso!");
    }

    private static void realizarConversao(String de, String para, double valor) {
        try {
            ConsultarTaxaDisponiveis consulta = new ConsultarTaxaDisponiveis();
            Taxas taxas = consulta.buscarMoedas();
            Conversor conversor = new Conversor();
            double resultado = conversor.converter(valor, taxas.conversion_rates(), para);
            System.out.printf("O valor %.2f [%s] corresponde ao valor final de => %.2f [%s]%n",
                    valor, de, resultado, para);
            GerarArquivo gerador = new GerarArquivo();
            // Salvar no histórico-
            gerador.salvarConversao(de, para, valor, resultado);
        } catch (RuntimeException e) {
            System.out.println("Erro ao converter moeda: " + e.getMessage());
        }
    }
}
