package example.coa;

import example.Iao;
import example.Writer;
import example.util.Pair;

import java.util.stream.Stream;

public class CoaReportRunner {


    public static void run(Stream<Pair<Iao, CoaWritable>> records) {

        Writer<CoaRecord> writer = new CoaWriter();

        // any Coa specific logic goes here
        records.map(p -> createRecord(p.right(), p.left()))
                .forEach(writer::write);

        // writer.complete
    }

    private static CoaRecord createRecord(CoaWritable writable, Iao iao) {
        return writable.toRecord(iao);
    }
}
