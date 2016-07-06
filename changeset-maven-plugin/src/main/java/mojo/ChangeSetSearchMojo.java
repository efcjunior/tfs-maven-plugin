package mojo;

import org.apache.http.HttpResponse;
import org.apache.http.auth.NTCredentials;
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
import pojo.ChangeSet;

import java.net.URL;

import static mojo.QueryURLBuilder.*;

/**
 * Created by c114416 on 01/07/2016.
 */
@Mojo( name = "changesetid")
public class ChangeSetSearchMojo extends AbstractMojo {

    @Parameter(property = "changesetid.urlBase", defaultValue = "xpto")
    private String urlBase;

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

    @Parameter(property = "changesetid.projectVersion", defaultValue = "${project.version}")
    private String projectVersion;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Construcao de URL de Pesquisa Restful");

       QueryURLBuilder queryURLBuilder =  QueryURLBuilder.custom(this.urlBase)
                .setParameter(this.serverUrl.toString())
                .setParameter(this.projectPath)
                .build();

        getLog().info("Construcao Credenciais");
        NTCredentials ntCredentials = new NTCredentials(this.username, this.password, "", this.domain);

        getLog().info("Execucao Requisicao");
        ChangeSet changeSet = HttpConsumer.custom(queryURLBuilder,ntCredentials).execute(ChangeSet.class);



    }

}
