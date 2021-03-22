package at.scheuchi.Gammazon.Filter;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;

import java.util.stream.Stream;

public interface IFilter<T> {

    Stream<T> apply();
    IFilter<T> getChild();
    Paragraph describeParams();

}
