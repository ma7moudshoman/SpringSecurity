package com.spring.springsecurity.Controller;

import com.spring.springsecurity.DTO.Voucher;
import com.spring.springsecurity.Repository.ProductRepo;
import com.spring.springsecurity.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productApi")
public class ProductController {


    @Autowired
    ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${voucherService.url}")
    private String voucherServiceURL;


    @PostMapping("/products")
    public Product creat (@RequestBody Product product){
        Voucher voucher=restTemplate.getForObject(voucherServiceURL +
        product.getVoucherCode()
        ,Voucher.class);
        product.setPrice(product.getPrice().subtract(voucher.getDiscount()));
        return productRepo.save(product);
    }

}
