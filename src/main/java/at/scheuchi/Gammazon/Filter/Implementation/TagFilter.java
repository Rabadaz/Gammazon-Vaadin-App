package at.scheuchi.Gammazon.Filter.Implementation;

import at.scheuchi.Gammazon.Filter.AbstractProductFilter;
import at.scheuchi.Gammazon.Filter.IFilter;
import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.Model.Tag;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;

import java.util.Collection;
import java.util.stream.Stream;

public class TagFilter extends AbstractProductFilter {
    private Collection<Tag> tags;
    private TagFilterMode mode = TagFilterMode.MATCH_ALL;

    protected TagFilter(IFilter<Product> child, Collection<Tag> tags) {
        super(child);
        this.tags = tags;
    }

    public TagFilter setMode(TagFilterMode mode){
        this.mode = mode;
        return this;
    }


    @Override
    public Stream<Product> apply() {
        if(mode == TagFilterMode.MATCH_ALL){
            return child.apply().filter(p -> p.getTags().containsAll(tags));
        }else{
            return child.apply().filter(p -> {
                for(Tag t: p.getTags()){
                    if(tags.contains(t))
                        return true;
                }
                return false;
            });
        }
    }

    @Override
    public Paragraph describeParams() {
        return new Paragraph();
    }


    public enum TagFilterMode{
        MATCH_ALL,
        MATCH_ONE
    }
}
