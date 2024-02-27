package com.Schedular.Controller;

import com.Schedular.Entity.Product;
import com.Schedular.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    Integer l=1;
    @Scheduled(fixedRate = 2000)
//    @Scheduled(cron = "*/2 * * * * *")
    public ResponseEntity<String>  saveProduct() throws IOException {

        Product product=null;
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("/home/bonami/AWS_PRACTICE/Spring_boot_Api_using_schedular/data.csv")))
        {


            for(int i=0;i<l;i++)
            {
                String  line = bufferedReader.readLine();
                String[] arr=line.split(",");
                 product=new Product();
                if(Integer.parseInt(arr[0])==l)
                {
                    product.setProductId(  Integer.parseInt(arr[0]));
                    product.setProductName(arr[1]);
                    product.setProductCount(Integer.parseInt(arr[2]));
                    product.setPerProductPrice(Integer.parseInt(arr[3]));
                }


            }



        }
        l++;
        return  productService.saveProduct(product);
  }}

//        List<Product> list=new ArrayList<>();
//       list.add(new Product(1,"Soap",4,12));
//       list.add(new Product(2,"Biscuits",10,5));
//       list.add(new Product(3,"Chocolates",5,100));
//       list.add(new Product(4,"ChocolatePastry",8,70));




