package example.coa;

import example.account.MAccount;

public class CoaWritableFactory {

    public static CoaWritable create(MAccount account) {
        String dataForReport = extractDataNeededForReportRunner(account);
        return new CoaWritable(dataForReport, iao -> MToCoa.transform(account, dataForReport));
    }

    private static String extractDataNeededForReportRunner(MAccount account) {
        return account.getId().substring(0, 7) + "-someCalculation-";
    }
}
