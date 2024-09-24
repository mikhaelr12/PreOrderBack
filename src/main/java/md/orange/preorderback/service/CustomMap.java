package md.orange.preorderback.service;

@FunctionalInterface
public interface CustomMap<T, V> {
    T map(V items);
}
