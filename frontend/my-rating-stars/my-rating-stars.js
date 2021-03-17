import {PolymerElement, html} from "@polymer/polymer";

class MyRatingStars extends PolymerElement{
    static get template(){
        return html`<span class="rating-star">⭐️</span>`
    }
    
}
customElements.define("my-rating-stars", MyRatingStars)