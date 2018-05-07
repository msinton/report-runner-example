package example.scv;

import example.Writer;

public class ScvWriter implements Writer<ScvRecord> {

    @Override
    public void write(ScvRecord record) {
        System.out.println("writing scv record: " + record.getId());
    }
}
