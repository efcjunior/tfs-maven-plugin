package mojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import pojo.Pojo;

import java.io.IOException;

/**
 * Created by everson on 05/07/16.
 */
public class EntityParser {

    public static <T extends Pojo> T test(HttpResponse httpResponse, Class<T> clazz){
        T t = null;

        try {
            String strObjResponse = EntityUtils.toString(httpResponse.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            t = objectMapper.readValue(strObjResponse, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return t;
    }
}
