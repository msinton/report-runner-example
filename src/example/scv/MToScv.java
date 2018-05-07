package example.scv;

import example.account.MAccount;

public class MToScv {

    public static ScvRecord transform(MAccount mAccount, String otherInformation) {
        return new ScvRecord(mAccount.getId() + " + " + otherInformation);
    }
}
