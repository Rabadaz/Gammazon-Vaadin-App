package at.scheuchi.Gammazon.Filter;

import java.util.Collection;
import java.util.stream.Stream;

public class FilterableList<T> implements IFilter<T>{

    private Collection<T> data;
    public FilterableList(Collection<T> coll){
        this.data = coll;
    }


    @Override
    public Stream<T> apply() {
        return data.stream();
    }

    @Override
    public IFilter<T> getChild() {
        return null;
    }
}
