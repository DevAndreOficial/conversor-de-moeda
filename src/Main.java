import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, String> pesoAtual = new HashMap<>();
        pesoAtual.put(1, "USB");
        pesoAtual.put(2, "ARS");
        pesoAtual.put(3, "COP");
        pesoAtual.put(4, "BRL");
        Map<Integer, String> pesoDeDestino = new HashMap<>();
        pesoDeDestino.put(1, "USD");
        pesoDeDestino.put(2, "ARS");
        pesoDeDestino.put(3, "COP");
        pesoDeDestino.put(4, "BRL");

        String atual = "";
        String destino = "";
        double valor = 0;
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("==========================================\n" +
                    "[ Seja bem-vindo/a ao conversor de Moeda ] \n\n" +
                    "1) Dólar ==>> Peso Argentino\n" +
                    "2) Peso Argentino ==>> Dólar\n" +
                    "3) Dólar ==> Real BR\n" +
                    "4) Real BR ==>> Dólar\n" +
                    "5) Dólar ==> Peso Colombiano\n" +
                    "6) Peso Colombiano ==> Dólar\n" +
                    "7) Sair\n" +
                    "==========================================");
            System.out.print("Escolha uma opção válida: ");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1, 3:
                    atual = pesoAtual.get(1);
                    System.out.print("Digite o valor que deseja converter: ");
                    valor = scan.nextDouble();

                    destino = (opcao == 1) ? pesoDeDestino.get(2) : pesoDeDestino.get(4);


                    try {
                        ConsultarTaxaDisponiveis consulta = new ConsultarTaxaDisponiveis();
                        Taxas taxas = consulta.buscarMoedas();
                        Conversor conversor = new Conversor();
                        double resultado = conversor.converter(valor, taxas.conversion_rates(), atual, destino);
                        System.out.println("O valor " + valor + " [" + atual + "] " + "corresponde ao valor final de ==>> " + resultado + " [" + destino + "]");

                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    atual = pesoAtual.get(2);
                    System.out.print("Digite o valor que deseja converter: ");
                    valor = scan.nextDouble();

                    destino = pesoDeDestino.get(1);
                    try {
                        ConsultarTaxaDisponiveis consulta = new ConsultarTaxaDisponiveis();
                        Taxas taxas = consulta.buscarMoedas();
                        Conversor conversor = new Conversor();
                        double resultado = conversor.converter(valor, taxas.conversion_rates(), atual, destino);
                        System.out.println("O valor " + valor + " [" + atual + "] " + "corresponde ao valor final de ==>> " + resultado + " [" + destino + "]");

                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    atual = pesoAtual.get(4);
                    System.out.print("Digite o valor que deseja converter: ");
                    valor = scan.nextDouble();

                    destino = pesoDeDestino.get(1);
                    try {
                        ConsultarTaxaDisponiveis consulta = new ConsultarTaxaDisponiveis();
                        Taxas taxas = consulta.buscarMoedas();
                        Conversor conversor = new Conversor();
                        double resultado = conversor.converter(valor, taxas.conversion_rates(), atual, destino);
                        System.out.println("O valor " + valor + " [" + atual + "] " + "corresponde ao valor final de ==>> " + resultado + " [" + destino + "]");

                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    atual = pesoAtual.get(1);
                    System.out.print("Digite o valor que deseja converter: ");
                    valor = scan.nextDouble();

                    destino = pesoDeDestino.get(3);
                    try {
                        ConsultarTaxaDisponiveis consulta = new ConsultarTaxaDisponiveis();
                        Taxas taxas = consulta.buscarMoedas();
                        Conversor conversor = new Conversor();
                        double resultado = conversor.converter(valor, taxas.conversion_rates(), atual, destino);
                        System.out.println("O valor " + valor + " [" + atual + "] " + "corresponde ao valor final de ==>> " + resultado + " [" + destino + "]");

                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opcão inválida...");
            }
        }

        System.out.println("Programa finalizado com sucesso!");
    }
}