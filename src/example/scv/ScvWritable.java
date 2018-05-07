package example.scv;

import example.Iao;

import java.util.function.Function;

public class ScvWritable {

    String someDataOnlyForScv;

    Function<Iao, ScvRecord> toRecord;

    public ScvWritable(String someDataOnlyForScv, Function<Iao, ScvRecord> toRecord) {
        this.someDataOnlyForScv = someDataOnlyForScv;
        this.toRecord = toRecord;
    }

    public String getSomeScvData() {
        return someDataOnlyForScv;
    }

    public ScvRecord toRecord(Iao iao) {
        return toRecord.apply(iao);
    }
}
