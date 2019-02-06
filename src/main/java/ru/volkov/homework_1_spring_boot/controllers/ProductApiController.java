package ru.volkov.homework_1_spring_boot.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.volkov.homework_1_spring_boot.dto.ProductDTO;
import ru.volkov.homework_1_spring_boot.model.Product;
import ru.volkov.homework_1_spring_boot.services.ProductService;

@Controller
@RequestMapping("/api/product")
public class ProductApiController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable int id) {

        if (productService.existById(id)) {
            Product requestedProduct = productService.getById(id);
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(requestedProduct, productDTO);
            return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
        }
        return new ResponseEntity<ProductDTO>(new ProductDTO(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Void> saveProduct(@RequestBody ProductDTO productDTO, UriComponentsBuilder builder) {
        Product newProduct = productService.createNewProduct();
        BeanUtils.copyProperties(productDTO, newProduct);
        if (productService.addNewProduct(newProduct)) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/api/product/{id}").buildAndExpand(newProduct.getNomenclature()).toUri());
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
}
