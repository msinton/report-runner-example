package example.report.writable;

import example.account.MAccount;
import example.account.PAccount;
import example.coa.CoaWritable;
import example.scv.ScvWritable;

import java.util.Optional;

/**
 * Generate the report writable for the different reports
 */
public interface ReportWritableFactory {

    Optional<ScvWritable> scv();
    Optional<CoaWritable> coa();
    // more report types

    static ReportWritableFactory create(PAccount account) {
        return new PReportWritableFactory(account);
    }

    static ReportWritableFactory create(MAccount account) {
        return new MReportWritableFactory(account);
    }

}
