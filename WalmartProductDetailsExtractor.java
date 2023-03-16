import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WalmartProductDetailsExtractor {
    public static void main(String[] args) throws IOException {
        // The URL of the Walmart product page we want to extract data from
        String url = "https://www.walmart.com/browse/electronics/dell-gaming-laptops/3944_3951_7052607_1849032_4519159";

        // Use Jsoup to connect to the URL and get the HTML document
        Document doc = Jsoup.connect(url).get();

        // Select all elements with the class "search-product-result", which correspond to individual products on the page
        Elements productElements = doc.select(".search-product-result");

        // Loop through each product element and extract the desired data
        for (Element productElement : productElements) {
            // Extract the product name from the element's child element with the class "search-result-product-title"
            String productName = productElement.select(".search-result-product-title").text();
            
            // Extract the product price from the element's child element with the class "search-result-price"
            String productPrice = productElement.select(".search-result-price").text();
            
            // Extract the item number from the element's "data-item-id" attribute
            String itemNumber = productElement.attr("data-item-id");
            
            // Extract the model number from the element's "data-model-number" attribute
            String modelNumber = productElement.attr("data-model-number");
            
            // Set the product category to a static value, since it's the same for all products on the page
            String productCategory = "Electronics > Computers > Laptops > Gaming Laptops";
            
            // Extract the product description from the element's child element with the class "search-result-product-description"
            String productDescription = productElement.select(".search-result-product-description").text();

            // Print the extracted data to the console
            System.out.println("Product Name: " + productName);
            System.out.println("Product Price: " + productPrice);
            System.out.println("Item Number: " + itemNumber);
            System.out.println("Model Number: " + modelNumber);
            System.out.println("Product Category: " + productCategory);
            System.out.println("Product Description: " + productDescription);
            System.out.println("------------------------------");
        }
    }
}
