package mojo;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.net.URL;

import static mojo.QueryURLBuilder.*;

/**
 * Created by c114416 on 01/07/2016.
 */
@Mojo( name = "changesetid")
public class ChangeSetSearchMojo extends AbstractMojo {

    @Parameter
    private URL serverUrl;

    @Parameter
    private String projectPath;

    @Parameter
    private String username;

    @Parameter
    private String password;

    @Parameter
    private String domain;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Construção de URL Restfull");

        URL urlFormatted = QueryURLBuilder.custom(serverUrl,projectPath).build();




    }

}
