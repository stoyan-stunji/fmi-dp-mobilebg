package Filters.CompositeFilters;

import Filters.Filter;

import java.util.List;

public class NOfMFilter<T> implements Filter<T>
{
    private final int n;
    private final List<Filter<T>> filters;

    public NOfMFilter(int n, List<Filter<T>> filters)
    {
        if (n > filters.size())
        {
            throw new IllegalArgumentException("NOfMFilter::n_CANNOT_be_greater_than_filters.size()");
        }

        this.n = n;
        this.filters = filters;
    }

    public boolean visit(T item)
    {
        int successCount = 0;

        for (Filter<T> filter : filters)
        {
            if (filter.visit(item))
            {
                successCount++;
            }

            if (successCount >= n)
            {
                return true;
            }
        }
        return false;
    }
}
