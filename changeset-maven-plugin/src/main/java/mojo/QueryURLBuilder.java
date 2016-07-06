package mojo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by c114416 on 05/07/2016.
 */
public class QueryURLBuilder implements Cloneable {

    private final String baseUrl;
    private LinkedList<String> parameters;
    private String queryUrl;

    private QueryURLBuilder(String baseUrl){
        this.baseUrl = baseUrl;
        this.parameters = new LinkedList<String>();
    }

    public QueryURLBuilder setParameter(String parameter){
        this.parameters.add(parameter);
        return this;
    }

    public void setParameters(LinkedList<String> parameters){
        this.parameters = parameters;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public static QueryURLBuilder custom(String baseUrl){
        return new QueryURLBuilder(baseUrl);
    }

    public QueryURLBuilder build() {
        this.queryUrl = new String(this.baseUrl);

        for (int i = 0; i < parameters.size(); i++) {
            String regex = "{" + i + "}";
            this.queryUrl = this.queryUrl.replaceAll(regex, parameters.get(i));
        }
        return null;
    }
}
