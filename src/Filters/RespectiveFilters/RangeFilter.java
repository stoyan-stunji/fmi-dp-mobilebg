package Filters.RespectiveFilters;

import Filters.FieldExtractor;
import Filters.Filter;

public class RangeFilter<T, V extends Comparable<V>> implements Filter<T>
{
    private final FieldExtractor<T, V> fieldExtractor;
    private final V min;
    private final V max;

    public RangeFilter(FieldExtractor<T, V> fieldExtractor, V min, V max)
    {
        this.fieldExtractor = fieldExtractor;
        this.min = min;
        this.max = max;
    }

    public boolean matches(T item)
    {
        V value = fieldExtractor.extractValue(item);

        if (value == null)
        {
            return false;
        }

        return value.compareTo(min) >= 0 && value.compareTo(max) <= 0;
    }
}
