package ru.volkov.homework_1_spring_boot.endpoints;

import localhost._8080.products.GetProductDetailsRequest;
import localhost._8080.products.GetProductDetailsResponse;
import localhost._8080.products.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.volkov.homework_1_spring_boot.model.Product;
import ru.volkov.homework_1_spring_boot.services.ProductService;

@Endpoint
public class ProductEndpoint {

    @Autowired
    ProductService productService;

    @PayloadRoot(namespace = "http://localhost:8080/products", localPart = "GetProductDetailsRequest")
    @ResponsePayload
    public GetProductDetailsResponse processCourseDetailsRequest(@RequestPayload GetProductDetailsRequest request) {
        GetProductDetailsResponse response = new GetProductDetailsResponse();

        ProductDetails productDetails = new ProductDetails();
        final Product product = productService.getById(request.getId());
        productDetails.setName(product.getName());
        productDetails.setDescription(product.getDescription());

        response.setProductDetails(productDetails);

        return response;
    }
}