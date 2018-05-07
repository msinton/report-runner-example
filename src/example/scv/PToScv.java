package example.scv;

import example.account.PAccount;

public class PToScv {

    public static ScvRecord transform(PAccount account, Integer otherInformation) {
        return new ScvRecord(account.getName() + " + " + otherInformation);
    }
}
