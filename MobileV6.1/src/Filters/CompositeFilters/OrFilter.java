package Filters.CompositeFilters;

import Filters.Filter;

import java.util.List;

public class OrFilter<T> implements Filter<T>
{
    private final List<Filter<T>> filters;

    public OrFilter(List<Filter<T>> filters)
    {
        this.filters = filters;
    }

    public boolean visit(T item)
    {
        for (Filter<T> filter : filters)
        {
            if (!filter.visit(item))
            {
                return true;
            }
        }
        return false;
    }
}