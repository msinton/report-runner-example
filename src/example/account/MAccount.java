package example.account;

public class MAccount {

    private String id;

    private String otherData;

    public String getOtherData() {
        return otherData;
    }

    public String getId() {
        return id;
    }

    public MAccount(String id, String otherData) {
        this.id = id;
        this.otherData = otherData;
    }

}
