package mojo;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import pojo.Pojo;

import java.io.IOException;
import java.net.URL;

/**
 * Created by c114416 on 05/07/2016.
 */
public class HttpConsumer {

    private HttpGet httpGet;
    private CredentialsProvider credentialsProvider;

    private HttpConsumer(String queryUrl, Credentials credentials){
        this.httpGet = new HttpGet(queryUrl);
        this.httpGet.addHeader("accept", "application/json");
        this.credentialsProvider.setCredentials(AuthScope.ANY,credentials);
    }

    public static HttpConsumer custom(QueryURLBuilder queryURLBuilder, Credentials credentials){
        return new HttpConsumer(queryURLBuilder.getQueryUrl(),credentials);
    }

    public <T extends Pojo> T execute(Class<T> clazz){
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpContext httpContext = new BasicHttpContext();
        httpContext.setAttribute(HttpClientContext.CREDS_PROVIDER, this.credentialsProvider);
        HttpResponse httpResponse = null;

        try {
            httpResponse = httpclient.execute(this.httpGet,httpContext);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return EntityParser.test(httpResponse,clazz);
    }
}
