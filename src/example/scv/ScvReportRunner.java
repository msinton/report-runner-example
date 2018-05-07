package example.scv;

import example.Iao;
import example.Writer;
import example.util.Pair;

import java.util.stream.Stream;

public class ScvReportRunner {

    public static void run(Stream<Pair<Iao, ScvWritable>> records) {

        Writer<ScvRecord> writer = new ScvWriter();

        // any Scv specific logic goes here
        records.filter(r -> r.right().getSomeScvData().startsWith("includeForScv"))
                .map(p -> createRecord(p.right(), p.left()))
                .forEach(writer::write);

        // writer.complete
    }

    private static ScvRecord createRecord(ScvWritable writable, Iao iao) {
        return writable.toRecord(iao);
    }
}
