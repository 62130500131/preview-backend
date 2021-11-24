package sit.integrated.project.controllers;



import org.springframework.web.bind.annotation.*;
import sit.integrated.project.exceptions.ExceptionResponse;
import sit.integrated.project.exceptions.ProductsException;
import sit.integrated.project.models.Feedback;
import sit.integrated.project.models.Products;
import sit.integrated.project.repositories.ProductsRepositories;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/Products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductsRepositories productsRepositories;

    private  Products Product;



   @GetMapping("/GetProducts")
   public List<Products> getAllProduct(){return productsRepositories.findAll(); }

    @GetMapping("/GetProducts/{id}")
    public  Products getProductById(@PathVariable int id){ return  productsRepositories.findById(id).orElse(null); }

    @GetMapping("/GetProducts/Brands/{brandName}")
    public  Object[] getProductByBrands(@PathVariable String brandName){
        List<Products> productsList = productsRepositories.findAll();
        Products[] productsArray = new Products[productsList.size()];
        productsList.toArray(productsArray);
        Object[] product = Arrays.stream(productsArray).filter(x -> x.getBrandId().getBrandId().contains(brandName)).toArray();
        return product;
   }

    @GetMapping("/GetProducts/Gender/{gender}")
    public Object[] getProductByGender(@PathVariable String gender){
        List<Products> productsList = productsRepositories.findAll();
        Products[] productsArray = new Products[productsList.size()];
        productsList.toArray(productsArray);
        Object[] product = Arrays.stream(productsArray).filter(x -> x.getProductGender().contains(gender)).toArray();
        return  product;
    }

    @GetMapping("/GetProducts/Type/{type}")
    public Object[] getProductByType(@PathVariable String type){
        List<Products> productsList = productsRepositories.findAll();
        Products[] productsArray = new Products[productsList.size()];
        productsList.toArray(productsArray);
        Object[] product = Arrays.stream(productsArray).filter(x -> x.getProductType().contains(type)).toArray();
        return  product;
    }

     @PostMapping("/Create")
    public Products createProduct(@RequestBody Products products){
         List<Products> listprod = productsRepositories.findAll();
         Products[] productsArrays = new Products[listprod.size()];
         listprod.toArray(productsArrays);
         for(int i = 0 ; i < productsArrays.length; i++ ) {
             if (productsArrays[i].getProductName().equals(products.getProductName())) {
                 throw new ProductsException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST ,"NameProduct is Duplicate");
             }
         }
         products.setProductId(productsRepositories.productLatestId() + 1);
         productsRepositories.save(products);
         return products;
   }


    @PutMapping("/Edit/{id}")
    public Products editProduct(@RequestBody Products products,@PathVariable int id){
        if (hasFoundId(id) && (id == products.getProductId())) {
            productsRepositories.save(products);
            return products;
        }
        else throw  new ProductsException(ExceptionResponse.ERROR_CODE.ITEM_DOES_NOT_EXIST , "DOES NOT EXIST");

    }

    @DeleteMapping("/Delete/{id}")
    public void deleteProduct(@PathVariable int id){
        if (hasFoundId(id)) {
            productsRepositories.deleteById(id);
        }
        else  throw new ProductsException(ExceptionResponse.ERROR_CODE.ITEM_DOES_NOT_EXIST,"The product DOES NOT EXIST");
    }


    public boolean hasFoundId(int id){
        List<Products> products = productsRepositories.findAll();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProductId() == id){
                return true;
            }
        }
        return false;
    }
}
