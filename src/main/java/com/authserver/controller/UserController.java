package com.authserver.controller;

import com.authserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 *  用户信息控制器
 */
@RestController
public class UserController {



    /**
     * 初始化用户数据
     */
    @Autowired
    public void init(){

        // 为了方便测试,这里添加了两个不同角色的账户
        /*accountRepository.deleteAll();

        Account accountA = new Account();
        accountA.setUserName("admin");
        accountA.setPassWord("admin");
        accountA.setRoles(new String[]{"ROLE_ADMIN","ROLE_USER"});
        accountRepository.save(accountA);

        Account accountB = new Account();
        accountB.setUserName("guest");
        accountB.setPassWord("pass123");
        accountB.setRoles(new String[]{"ROLE_GUEST"});
        accountRepository.save(accountB);*/
    }

    /**
     * 获取授权用户的信息
     * @param user 当前用户
     * @return 授权信息
     */
    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }

   /* @GetMapping("/test")
    public String user(@AuthenticationPrincipal String username){
        return "hello world!  "+username;
    }*/

    @GetMapping("/test/get")
    public String user(@AuthenticationPrincipal User user){
        
        return "hello world!  "+user.getUsername();
    }

    @PostMapping("/test/post")
    public String user1(@AuthenticationPrincipal String username){

        return "hello world!  "+username;
    }

}