//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.24 at 05:56:37 PM MSK 
//


package org.product;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.product package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.product
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductDetailsRequest }
     * 
     */
    public GetProductDetailsRequest createGetProductDetailsRequest() {
        return new GetProductDetailsRequest();
    }

    /**
     * Create an instance of {@link GetProductDetailsResponse }
     * 
     */
    public GetProductDetailsResponse createGetProductDetailsResponse() {
        return new GetProductDetailsResponse();
    }

    /**
     * Create an instance of {@link ProductDetails }
     * 
     */
    public ProductDetails createProductDetails() {
        return new ProductDetails();
    }

}
