package example.scv;

import example.account.MAccount;
import example.account.PAccount;

public class ScvWritableFactory {

    // ---- M
    public static ScvWritable create(MAccount account) {

        String dataNeededForRunner = extractDataNeededForReportRunner(account);
        return new ScvWritable(dataNeededForRunner, iao -> MToScv.transform(account, iao.getInfo1()));
    }

    // this naming is for illustration purposes only
    private static String extractDataNeededForReportRunner(MAccount mAccount) {
        return mAccount.getOtherData();
    }
    // <------

    // ---- P
    public static ScvWritable create(PAccount account) {

        String dataNeededForRunner = extractDataNeededForReportRunner(account);
        return new ScvWritable(dataNeededForRunner, iao -> PToScv.transform(account, iao.getInfo2()));
    }

    private static String extractDataNeededForReportRunner(PAccount account) {
        return account.getDddata();
    }
    // <------

}
