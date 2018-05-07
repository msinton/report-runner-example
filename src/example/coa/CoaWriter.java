package example.coa;

import example.Writer;

public class CoaWriter implements Writer<CoaRecord> {

    @Override
    public void write(CoaRecord record) {
        System.out.println("writing coa record: " + record.getDescription());
    }
}
