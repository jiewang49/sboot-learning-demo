package com.didspringboot.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import java.util.*;

/**
 * Created by pc on 2018/1/14.
 */
@RestController
@RequestMapping(value = "/users")  //通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>(users.values());
        System.out.println("lenth:" + userList.size());
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getName());
        }

        return userList;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute("user") User user) {
        System.out.print("params of user id:" + user.getId());
//        System.out.println("parmas of user name:" + name);
//        User user = new User();
//        user.setId(id);
//        user.setName(name);
//        user.setAge(age);
        users.put(user.getId(), user);
        System.out.println(users.get(user.getId()).getName());
        return "success";
    }


    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id) {
        User user = users.get(id);
        return user;
    }


    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable long id, @ModelAttribute User user) {
        User userQ = users.get(id);
        userQ.setAge(user.getAge());
        userQ.setName(user.getName());
        return "success";
    }


    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable long id) {
        users.remove(id);
        return "success";
    }
}
