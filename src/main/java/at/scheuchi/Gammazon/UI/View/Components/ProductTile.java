package at.scheuchi.Gammazon.UI.View.Components;

import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.UI.View.ProductView;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouteConfiguration;

public class ProductTile extends HorizontalLayout {

    public ProductTile(Product product){
        Image image = new Image(product.getPictureUrl(), product.getTitle());
        Div imageDiv = new Div(image);

        //Anchor a = new Anchor()
        VerticalLayout sideLayout = new VerticalLayout();
        imageDiv.setWidth("12vw");
        imageDiv.getStyle().set("margin", "10px");

        image.setMaxHeight("100%");
        image.setMaxWidth("100%");
        image.getStyle().set("margin","auto");


        String route = RouteConfiguration.forApplicationScope().getUrl(ProductView.class, product.getId());

        Anchor link = new Anchor(route, product.getTitle());
        H2 title = new H2();
        title.add(link);
        Paragraph desc = new Paragraph(product.getDescription());
        Paragraph prize = new Paragraph(String.valueOf(product.getPrice()/100f) + "€");
        prize.getStyle().set("color", "lightblue");
        prize.getStyle().set("font-weight", "bold");

        setClassName("bordered");
        getStyle().set("padding-left", "2vw");

        sideLayout.add(title, prize, desc);

        setHeight("20vh");
        setWidth("40vw");
        add(imageDiv,sideLayout);



    }
}
