package example.report.writable;

import example.account.PAccount;
import example.coa.CoaWritable;
import example.scv.ScvWritable;
import example.scv.ScvWritableFactory;

import java.util.Optional;

public class PReportWritableFactory implements ReportWritableFactory {

    PAccount account;

    PReportWritableFactory(PAccount account) {
        this.account = account;
    }

    @Override
    public Optional<ScvWritable> scv() {
        return Optional.of(ScvWritableFactory.create(account));
    }

    @Override
    public Optional<CoaWritable> coa() {
        return Optional.empty();
    }
}
