package example.account;

public class PAccount {

    private String name;
    private String dddata;
    private Integer someNumber;

    public Integer getSomeNumber() {
        return someNumber;
    }

    public String getDddata() {
        return dddata;
    }

    public String getName() {
        return name;
    }

    public PAccount(String name, String dddata, Integer someNumber) {
        this.name = name;
        this.dddata = dddata;
        this.someNumber = someNumber;
    }
}
