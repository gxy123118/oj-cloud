package com.gxy.ojuserservice.controller.inner;

import com.gxy.ojmodel.model.entity.User;
import com.gxy.ojmodel.model.vo.UserVO;
import com.gxy.ojuserservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user/inner")
public class UserInnerController {
    @Resource
    private UserService userService;


    @GetMapping("/id")
    public User getById(@RequestParam("id") Long userId) {
        return userService.getById(userId);
    }

    @PostMapping("/list")
    public List<User> listByIds(@RequestBody Set<Long> userIdSet) {
        return userService.listByIds(userIdSet);
    }

    @PostMapping("/get/user/vo")
    UserVO getUserVO(@RequestBody User user) {
        return userService.getUserVO(user);
    }

    @PostMapping("/isAdmin")
    boolean isAdmin(@RequestBody User loginUser) {
        return userService.isAdmin(loginUser);
    }

    ;
//httpservletrequest不能被序列化
//    @GetMapping("/get/login")
//    User getLoginUser(HttpServletRequest request) {
//        return userService.getLoginUser(request);
//    }
}
