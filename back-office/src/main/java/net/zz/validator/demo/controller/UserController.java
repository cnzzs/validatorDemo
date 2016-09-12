package net.zz.validator.demo.controller;

import net.zz.validator.demo.entity.User;
import net.zz.validator.web.SupportController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by ZaoSheng on 2015/7/2.
 */
@RestController
@RequestMapping("aa")
public class UserController extends SupportController {

    @RequestMapping("/add")
    public Map<String, Object> add(@Valid User user) {
        System.out.println(user.getName());
        System.out.println(user.getQq());
        System.out.println(user.getIdCard());
        return successData();
    }

    /*
    @Valid
    @Deprecated
    @RequestMapping("set")
    public Map<String, Object> set(@QQ String qq) {
        System.out.println(qq);
        return successData();
    }*/

}
