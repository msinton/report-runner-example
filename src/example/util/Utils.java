package example.util;

import java.util.Optional;
import java.util.stream.Stream;

public class Utils {

    public static <T> Stream<T> optToStream(Optional<T> t) {
        return t.map(Stream::of).orElse(Stream.empty());
    }
}
