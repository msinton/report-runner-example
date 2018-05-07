package example.coa;

import example.account.MAccount;

public class MToCoa {

    public static CoaRecord transform(MAccount account, String otherInfo) {
        return new CoaRecord(otherInfo + account.getOtherData());
    }
}
