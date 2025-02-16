package Filters;

public interface Filter<T>
{
    boolean visit(T item);
}
