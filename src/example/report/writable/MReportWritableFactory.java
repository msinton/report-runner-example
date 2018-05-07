package example.report.writable;

import example.account.MAccount;
import example.coa.CoaWritable;
import example.coa.CoaWritableFactory;
import example.scv.ScvWritable;
import example.scv.ScvWritableFactory;

import java.util.Optional;

public class MReportWritableFactory implements ReportWritableFactory {

    MAccount account;

    MReportWritableFactory(MAccount account) {
        this.account = account;
    }

    @Override
    public Optional<ScvWritable> scv() {
        return Optional.of(ScvWritableFactory.create(account));
    }

    @Override
    public Optional<CoaWritable> coa() {
        return Optional.of(CoaWritableFactory.create(account));
    }
}
