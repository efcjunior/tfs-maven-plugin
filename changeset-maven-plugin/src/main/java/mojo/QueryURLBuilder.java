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
    private String url;

    private QueryURLBuilder(String baseUrl){
        this.baseUrl = baseUrl;
        this.parameters = new LinkedList<String>();
    }

    public LinkedList<String> getParameters() {
        return parameters;
    }

    public String getUrl() {
        return url;
    }

    public static QueryURLBuilder custom(String baseUrl){
        return new QueryURLBuilder(baseUrl);
    }

    public QueryURLBuilder build() {
        this.url = new String(this.baseUrl);

        for (int i = 0; i < parameters.size(); i++) {
            String regex = "{" + i + "}";
            this.url = this.url.replaceAll(regex, parameters.get(i));
        }
        return null;
    }
}
