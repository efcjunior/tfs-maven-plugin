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

import java.io.IOException;
import java.net.URL;

/**
 * Created by c114416 on 05/07/2016.
 */
public class HttpConsumer {

    private HttpGet httpGet;
    private CredentialsProvider credentialsProvider;

    private HttpConsumer(String urlFormatted, Credentials credentials){
        this.httpGet = new HttpGet(urlFormatted);
        this.httpGet.addHeader("accept", "application/json");
        this.credentialsProvider.setCredentials(AuthScope.ANY,credentials);
    }

    public static HttpConsumer custom(URL urlFormatted, Credentials credentials){
        return new HttpConsumer(urlFormatted.toString(),credentials);
    }

    public HttpResponse execute(){
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpContext httpContext = new BasicHttpContext();
        httpContext.setAttribute(HttpClientContext.CREDS_PROVIDER, this.credentialsProvider);

        try {
            return httpclient.execute(httpGet,httpContext);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
