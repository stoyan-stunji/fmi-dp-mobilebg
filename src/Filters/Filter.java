package Filters;

public interface Filter<T>
{
    boolean matches(T item);
}
