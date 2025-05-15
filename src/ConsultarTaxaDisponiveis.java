import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarTaxaDisponiveis {

    public Taxas buscarMoedas() {

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/a354c0cbd12d1c853361bff0/latest/USD");

        //HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(), Taxas.class);

        } catch (Exception e){
            throw new RuntimeException("Erro na resposta...." + e.getMessage());
        }



    }
}
