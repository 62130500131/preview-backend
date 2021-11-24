package sit.integrated.project.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.integrated.project.models.Brands;
import sit.integrated.project.repositories.BrandsRepositories;

import java.util.List;

@RestController
@RequestMapping("/Brands")
@CrossOrigin
public class BrandsController {
    @Autowired
    private BrandsRepositories BrandsRepositories;

    @GetMapping("/GetBrands")
    public List<Brands> listAllBrands(){
        return BrandsRepositories.findAll();
    }
}
