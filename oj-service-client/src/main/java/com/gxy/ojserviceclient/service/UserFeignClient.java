package com.gxy.ojserviceclient.service;



import com.gxy.ojcommon.common.ErrorCode;
import com.gxy.ojcommon.exception.BusinessException;

import com.gxy.ojmodel.model.entity.User;
import com.gxy.ojmodel.model.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

import static com.gxy.ojcommon.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 */
@FeignClient(name = "oj-user-service", path = "/api/user/inner")
public interface UserFeignClient {
    @GetMapping("/id")
    User getById(@RequestParam("id") Long userId);


    @PostMapping("/list")
    List<User> listByIds(@RequestBody Set<Long> userIdSet);

    /**
     * 获取脱敏的用户信息
     *
     * @param user
     * @return
     */

    @PostMapping("/get/user/vo")
    UserVO getUserVO(@RequestBody User user);


    default User getLoginUser(HttpServletRequest request) {
        // 先判断是否已登录
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        // 从数据库查询（追求性能的话可以注释，直接走缓存）
        long userId = currentUser.getId();
        currentUser = this.getById(userId);
        if (currentUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        return currentUser;
    }

    @PostMapping("isAdmin")
    boolean isAdmin(@RequestBody User loginUser);
}
