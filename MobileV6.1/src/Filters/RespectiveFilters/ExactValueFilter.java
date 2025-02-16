package Filters.RespectiveFilters;

import Filters.FieldExtractor;
import Filters.Filter;

public class ExactValueFilter<T, V> implements Filter<T>
{
    private final V valueToFind;
    private final FieldExtractor<T, V> fieldExtractor;

    public ExactValueFilter(FieldExtractor<T, V> fieldExtractor, V valueToFind)
    {
        this.valueToFind = valueToFind;
        this.fieldExtractor = fieldExtractor;
    }

    public boolean visit(T item)
    {
        V value = fieldExtractor.extractValue(item);
        return value.equals(valueToFind);
    }
}
