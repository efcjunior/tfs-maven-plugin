package mojo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.*;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import pojo.ChangeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c114416 on 01/07/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        HttpGet httpGet = new HttpGet("url");
        httpGet.addHeader("accept", "application/json");

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

//        List<String> authPrefs = new ArrayList<String>();
        authPrefs.add(AuthSchemes.);
//        authPrefs.add(AuthSchemes.KERBEROS);
//
        RequestConfig requestConfig = RequestConfig.custom().setProxyPreferredAuthSchemes(authPrefs).build();
//        httpGet.setConfig(requestConfig);

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,new NTCredentials("s", "secret", "", "domain"));

        HttpContext httpContext = new BasicHttpContext();
        httpContext.setAttribute(HttpClientContext.CREDS_PROVIDER, credentialsProvider);

        HttpResponse response = httpclient.execute(httpGet,httpContext);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }

        EntityUtils.toString(response.getEntity());


        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

        String output;
        System.out.println("Output from Server .... \n");
        ChangeSet changeSet;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            ObjectMapper objectMapper = new ObjectMapper();
            changeSet = objectMapper.readValue(output,ChangeSet.class);
        }

        httpclient.close();
    }
}
