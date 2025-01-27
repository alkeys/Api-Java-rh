package com.alkeys.rh.rest.user;


import com.alkeys.rh.entity.user.User;
import com.alkeys.rh.rest.AbstractRest;
import com.alkeys.rh.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.alkeys.rh.rest.UrlApi.UserApp;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(UserApp) // rh-api/userapp
public class UserRest extends AbstractRest<User, UserService> {
    @Autowired
    private UserService userService;


    @Override
    protected UserService getService() {
        return userService;
    }

    /**
     * findByUsernameAndPassword
     */
    @GetMapping("/login/{mail}/{password}")
    public User findByUserMailAndPassword(String mail, String password) {
        return userService.findByUserEmailAndPassword(mail, password);
    }


    /**
     * Update estado de usuario
     */
    @PutMapping("/updateActive/{id}/{active}")
    public Boolean UpdateActive(Long id, Boolean active) {
        return userService.UpdateActive(id, active);
    }


    /*
        * Metodo para actualizar la contraseña de un usuario
         */
    @PutMapping("updatePassword/{id}/{password}")
    public User updatePassword(Long id, String password) {
        return userService.updatePassword(id, password);
    }


}
