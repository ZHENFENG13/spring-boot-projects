package cn.lanqiao.springboot3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import cn.lanqiao.springboot3.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Tag(name = "用户模块接口")
@RestController
public class UserModuleController {

    static Map<Integer, User> usersMap = Collections.synchronizedMap(new HashMap<Integer, User>());

    // 初始化 usersMap
    static {
        User user = new User();
        user.setId(1);
        user.setName("lanqiao1");
        user.setPassword("111111");
        User user2 = new User();
        user2.setId(2);
        user2.setName("lanqiao2");
        user2.setPassword("222222");
        usersMap.put(1, user);
        usersMap.put(2, user2);
    }

    @Operation(summary = "获取用户列表")
    @GetMapping("/users")
    public List<User> getUserList() {
        List<User> users = new ArrayList<User>(usersMap.values());
        return users;
    }

    @Operation(summary = "新增用户", description = "根据User对象新增用户")
    @PostMapping("/users")
    public String postUser(@RequestBody User user) {
        usersMap.put(user.getId(), user);
        return "新增成功";
    }

    @Operation(summary = "获取用户详细信息", description = "根据id来获取用户详细信息")
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id) {
        return usersMap.get(id);
    }

    @Operation(summary = "更新用户详细信息", description = "")
    @PutMapping("/users/{id}")
    public String putUser(@PathVariable Integer id, @RequestBody User user) {
        User tempUser = usersMap.get(id);
        tempUser.setName(user.getName());
        tempUser.setPassword(user.getPassword());
        usersMap.put(id, tempUser);
        return "更新成功";
    }

    @Operation(summary = "删除用户", description = "根据id删除对象")
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        usersMap.remove(id);
        return "删除成功";
    }

}