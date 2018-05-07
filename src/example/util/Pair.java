package example.util;

import java.util.function.Function;

public class Pair<L, R> {

    L left;

    R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public R right() {
        return right;
    }

    public L left() {
        return left;
    }

    public <N> Pair<N, R> mapLeft(Function<L, N> mapper) {
        return new Pair<>(mapper.apply(left), right);
    }

    public <N> Pair<L, N> mapRight(Function<R, N> mapper) {
        return new Pair<>(left, mapper.apply(right));
    }
}
