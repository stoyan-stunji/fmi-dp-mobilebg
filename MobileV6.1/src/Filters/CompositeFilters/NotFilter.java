package Filters.CompositeFilters;

import Filters.Filter;

public class NotFilter<T> implements Filter<T>
{
    private final Filter<T> filter;

    public NotFilter(Filter<T> filter)
    {
        this.filter = filter;
    }

    public boolean visit(T item)
    {
        return !filter.visit(item);
    }
}