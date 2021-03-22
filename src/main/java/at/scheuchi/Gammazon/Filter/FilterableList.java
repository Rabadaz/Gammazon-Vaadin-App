package at.scheuchi.Gammazon.Filter;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;

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

    @Override
    public Paragraph describeParams() {
        return new Paragraph(this.getClass().getSimpleName());
    }
}
