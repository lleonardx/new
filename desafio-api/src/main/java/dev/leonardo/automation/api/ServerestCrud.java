package dev.leonardo.automation.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ServerestCrud {
    private static final String BASE_URL = "https://serverest.dev";
    private static String authToken;

    private static HttpResponse sendRequest(HttpRequestBase request) throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        if (authToken != null) {
            request.setHeader("Authorization", "Bearer " + authToken);
        }
        return httpClient.execute(request);
    }

    private static String login() throws Exception {
        HttpPost httpPost = new HttpPost(BASE_URL + "/login");

        // Substitua 'seu_usuario' e 'sua_senha' pelos dados reais
        String jsonBody = "{\"email\": \"usuario_teste\", \"password\": \"teste12345\"}";

        httpPost.setEntity(new StringEntity(jsonBody));
        httpPost.setHeader("Content-type", "application/json");

        HttpResponse response = sendRequest(httpPost);
        String responseBody = EntityUtils.toString(response.getEntity());

        return authToken;
    }

    private static void createUser() throws Exception {
        // Substitua com os dados do usuário que você deseja criar
        String jsonBody = "{\"nome\": \"Fulano Teste\", \"email\": \"fulano_teste@qa.com.br\", \"password\": \"teste\", \"administrador\": \"true\"}";

        System.out.println("Input for Create User: " + jsonBody);

        HttpPost httpPost = new HttpPost(BASE_URL + "/usuarios");
        httpPost.setEntity(new StringEntity(jsonBody));
        httpPost.setHeader("Content-type", "application/json");

        HttpResponse response = sendRequest(httpPost);
        System.out.println("Create User Response Code: " + response.getStatusLine().getStatusCode());
    }

    private static void checkUser() throws Exception {
        HttpGet httpGet = new HttpGet(BASE_URL + "/usuarios");

        HttpResponse response = sendRequest(httpGet);
        System.out.println("Check User Response Code: " + response.getStatusLine().getStatusCode());
    }

    private static void createProduct() throws Exception {
        // Substitua com os dados do produto que você deseja criar
        String jsonBody = "{\"nome\": \"Red Dragon\", \"preco\": 150, \"descricao\": \"Teclado\", \"quantidade\": 250}";

        System.out.println("Input for Create Product: " + jsonBody);

        HttpPost httpPost = new HttpPost(BASE_URL + "/produtos");
        httpPost.setEntity(new StringEntity(jsonBody));
        httpPost.setHeader("Content-type", "application/json");

        HttpResponse response = sendRequest(httpPost);
        System.out.println("Create Product Response Code: " + response.getStatusLine().getStatusCode());
    }

    private static void checkProduct() throws Exception {
        HttpGet httpGet = new HttpGet(BASE_URL + "/produtos");

        HttpResponse response = sendRequest(httpGet);
        System.out.println("Check Product Response Code: " + response.getStatusLine().getStatusCode());
    }

    public static void executeCrudOperations() {
        try {
            // Criar usuário como administrador
            createUser();

            // Realizar login e obter o token
            authToken = login();

            // Verificar se o usuário foi criado
            checkUser();

            // Criar produto
            createProduct();

            // Verificar se o produto foi criado
            checkProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
