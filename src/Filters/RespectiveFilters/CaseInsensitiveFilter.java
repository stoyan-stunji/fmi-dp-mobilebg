package Filters.RespectiveFilters;

import Filters.FieldExtractor;
import Filters.Filter;

public class CaseInsensitiveFilter<T> implements Filter<T>
{
    private final String valueToFind;
    private final FieldExtractor<T, String> fieldExtractor;

    public CaseInsensitiveFilter(FieldExtractor<T, String> fieldExtractor, String valueToFind)
    {
        this.valueToFind = valueToFind;
        this.fieldExtractor = fieldExtractor;
    }

    public boolean matches(T item)
    {
        String value = fieldExtractor.extractValue(item);
        return value.equalsIgnoreCase(valueToFind);
    }
}

