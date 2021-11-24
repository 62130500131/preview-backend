package sit.integrated.project.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.integrated.project.models.Colors;
import sit.integrated.project.repositories.ColorsRepositories;

import java.util.List;

@RestController
@RequestMapping("/Colors")
@CrossOrigin
public class ColorsController {
    @Autowired
    private ColorsRepositories ColorsRepositories;

    @GetMapping("/GetColors")
    public List<Colors> listAllProduct(){
        return ColorsRepositories.findAll();
    }
}
