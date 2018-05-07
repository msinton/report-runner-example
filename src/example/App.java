package example;

import example.account.MAccount;
import example.account.PAccount;
import example.coa.CoaReportRunner;
import example.report.writable.ReportWritableFactory;
import example.scv.ScvReportRunner;
import example.util.Pair;
import example.util.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        run(Arrays.asList(ReportType.Scv, ReportType.CoA));
    }

    public static void run(List<ReportType> reportTypes) {

        // dummy data to illustrate
        List<MAccount> mAccounts = Arrays.asList(
                new MAccount("m-acc-1-aaa", "includeForScv"),
                new MAccount("m-acc-2-bbb", "otherData"),
                new MAccount("m-acc-3-ccc", "includeForScv"));

        List<PAccount> pAccounts = Arrays.asList(
                new PAccount("p-acc-1", "data-1", 42),
                new PAccount("p-acc-2", "includeForScv", 400),
                new PAccount("p-acc-3", "data-2", 123)
        );

        // turn each into Iao (this could be a precursor to Iao)
        // as each one is added figure out the transformer etc and push into the Report Runner
        // at which point it is ok to "lose" the distinction between account types
        // since the transformers are already primed

        List<Pair<Iao, ReportWritableFactory>> iaosWithFactories = Stream.concat(
                mAccounts.stream().map(IaoWithWritableFactory::create),
                pAccounts.stream().map(IaoWithWritableFactory::create)
        )
//                .groupBy individual entity id and do calculations to populate the Ioa correctly
                // then flatten back to the values
                .collect(Collectors.toList());

        if (reportTypes.contains(ReportType.Scv)) {
            ScvReportRunner.run(iaosWithFactories.stream()
                    .map(p -> p.right().scv().map(r -> new Pair<>(p.left(), r)))
                    .flatMap(Utils::optToStream));
        }

        if (reportTypes.contains(ReportType.CoA)) {
            CoaReportRunner.run(iaosWithFactories.stream()
                    .map(p -> p.right().coa().map(r -> new Pair<>(p.left(), r)))
                    .flatMap(Utils::optToStream));
        }
        // other report types
        // the if statements can be neatened up

    }

}
