package pojo;

import java.util.List;

/**
 * Created by c114416 on 05/07/2016.
 */
public class ChangeSet {

    private long count;
    private List<Value> value;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }
}
