package at.scheuchi.Gammazon.UI.Components;

import at.scheuchi.Gammazon.Model.Review;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ReviewComponent extends VerticalLayout {
    public ReviewComponent(Review review){
        H3 title = new H3(review.getTitle() + " (" + review.getRating() + ")");
        Paragraph text = new Paragraph(review.getText());
        Paragraph username = new Paragraph(review.getCustomer().createFullName());

        username.getStyle().set("color", "gray");


        add(title, new HorizontalLayout(username, new Paragraph(" -- Verified User")), text);


    }
}
