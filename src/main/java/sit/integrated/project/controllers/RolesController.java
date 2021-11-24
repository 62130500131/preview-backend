package sit.integrated.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sit.integrated.project.exceptions.ExceptionResponse;
import sit.integrated.project.exceptions.ProductsException;
import sit.integrated.project.models.Products;
import sit.integrated.project.models.Roles;
import sit.integrated.project.repositories.RolesRepositories;

import java.util.List;

@RestController
@RequestMapping("/Roles")
@CrossOrigin
public class RolesController {
    @Autowired
    private RolesRepositories rolesRepositories;

    @GetMapping("/GetRoles")
    public List<Roles> ListAllRoles(){return rolesRepositories.findAll(); }

    @PostMapping("/Create")
    public Roles createRoles(@RequestBody Roles roles){
        List<Roles> listroles = rolesRepositories.findAll();
        Roles[] rolesArrays = new Roles[listroles.size()];
        listroles.toArray(rolesArrays);
        roles.setRoleId(rolesRepositories.roleLatestId() + 1);
        rolesRepositories.save(roles);
        return roles;
    }


    @DeleteMapping("/Delete/{id}")
    public void deleteRole(@PathVariable int id){

            rolesRepositories.deleteById(id);

    }




}

