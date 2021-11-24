package sit.integrated.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.integrated.project.exceptions.ExceptionResponse;
import sit.integrated.project.exceptions.ProductsException;
import sit.integrated.project.models.Feedback;
import sit.integrated.project.models.Products;
import sit.integrated.project.models.Users;
import sit.integrated.project.repositories.UsersRepositories;
import java.util.List;

@RestController
@RequestMapping("/Users")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersRepositories usersRepositories;


    @GetMapping("/GetUsers")
    public List<Users> ListAllUsers(){return usersRepositories.findAll(); }

    @GetMapping("/GetUsers/{id}")
    public Users getUserById(@PathVariable int id){ return  usersRepositories.findById(id).orElse(null); }

    @PostMapping("/Create")
    public Users createUsers(@RequestBody Users user){
        List<Users> listuser = usersRepositories.findAll();
        Users[] userArrays = new Users[listuser.size()];
        listuser.toArray(userArrays);
        user.setUserId(usersRepositories.userLatestId() + 1);
        usersRepositories.save(user);
        return user;
    }

    @PutMapping("/Edit/{id}")
    public Users editUser(@RequestBody Users users, @PathVariable int id){
        if (hasFoundId(id) && (id == users.getUserId())) {
            usersRepositories.save(users);
            return users;
        }
        else throw  new ProductsException(ExceptionResponse.ERROR_CODE.ITEM_DOES_NOT_EXIST , "DOES NOT EXIST");

    }

    @DeleteMapping("/Delete/{id}")
    public String deleteUsers(@PathVariable int id){
        usersRepositories.deleteById(id);
        String s = String.valueOf(id);
        return s+"has been deleted";
    }

    public boolean hasFoundId(int id){
        List<Users> users = usersRepositories.findAll();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserId() == id){
                return true;
            }
        }
        return false;
    }
}
