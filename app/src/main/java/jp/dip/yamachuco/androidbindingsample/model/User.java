package jp.dip.yamachuco.androidbindingsample.model;

/**
 * Created by yamachu on 2016/08/24.
 */
public class User {
    private String name;
    private String description;

    public User(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
