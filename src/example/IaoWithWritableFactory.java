package example;

import example.account.MAccount;
import example.account.PAccount;
import example.report.writable.ReportWritableFactory;
import example.util.Pair;

/**
 * Facade for creating the Iao for an account and the Factory that will create the Writable record for this account.
 */
public class IaoWithWritableFactory {

    static Pair<Iao, ReportWritableFactory> create(MAccount account) {
        // any IAO creation logic specific to m accounts goes here
        return new Pair<>(
                new Iao("iao-data-from-m", 1),
                ReportWritableFactory.create(account));
    }

    static Pair<Iao, ReportWritableFactory> create(PAccount account) {
        return new Pair<>(
                new Iao("iao-data-from-p", account.getSomeNumber()),
                ReportWritableFactory.create(account));
    }
}
