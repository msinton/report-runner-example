package example.coa;

import example.Iao;

import java.util.function.Function;

public class CoaWritable {

    String someCoaData;

    Function<Iao, CoaRecord> toRecord;

    public CoaWritable(String someCoaData, Function<Iao, CoaRecord> toRecord) {
        this.someCoaData = someCoaData;
        this.toRecord = toRecord;
    }

    public String getSomeCoaData() {
        return someCoaData;
    }

    public CoaRecord toRecord(Iao iao) {
        return toRecord.apply(iao);
    }
}
