package ru.volkov.homework_1_spring_boot.endpoints;

import org.product.GetProductDetailsRequest;
import org.product.GetProductDetailsResponse;
import org.product.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @PayloadRoot(namespace = "http://www.product.org", localPart = "GetProductDetailsRequest")
    @ResponsePayload
    public GetProductDetailsResponse processProductDetailsRequest(@RequestPayload GetProductDetailsRequest request) {

        GetProductDetailsResponse response = new GetProductDetailsResponse();
        ProductDetails productDetails = new ProductDetails();

        final int requestId = request.getId();
        final Product product = productService.getById(requestId);

        if (product != null) {
            productDetails.setId(requestId);
            productDetails.setName(product.getName());
            productDetails.setDescription(product.getDescription());
            response.setProductDetails(productDetails);
        }

        return response;
    }
}
