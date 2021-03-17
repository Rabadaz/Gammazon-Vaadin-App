package at.scheuchi.Gammazon.Filter;

import com.vaadin.flow.component.Component;

import java.util.stream.Stream;

public interface IFilter<T> {

    Stream<T> apply();
    IFilter<T> getChild();

}
