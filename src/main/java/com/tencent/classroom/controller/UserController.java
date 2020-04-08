package com.tencent.classroom.controller;

import com.tencent.classroom.vo.TencentVo;
import com.tencent.classroom.config.TLSSigAPIv2;
import com.tencent.classroom.pojo.User;
import com.tencent.classroom.service.UserService;
import com.tencent.classroom.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Value("${tencent.SDKAPPID}")
    private long sdkappid;

    @Value("${tencent.SECRETKEY}")
    private String secretkey;


    /**
     * 注册用户接口
     * @return
     */
    @PostMapping(value = "/register")
    public RestResult genSig(@RequestBody User user){
        if(userService.insertSelective(user)>0){
            return RestResult.ok();
        }else{
            return RestResult.build(500,"注册失败");
        }
    }


    /**
     * 登录功能接口
     * 生成一个随机账号以及姓名       如果状态码  =  5  会生成管理员用户
      * @param user
     * @return
     */
    @PostMapping("/login")
    public RestResult login(@RequestBody User user){
        HashMap<String,Object> map = new HashMap<>();
        String s = "";
        if(user.getType()!=null&&user.getType()==5){
            s = "Administrator";
        }else{
            s = UUID.randomUUID().toString().replace("-","");
        }
       User data =  userService.selectByPrimaryKey(user);
        if(data!=null){
            map.put("Identifier",s);
            map.put("id",data.getId());
            map.put("UserSig",new TLSSigAPIv2(sdkappid,secretkey).genSig(s, 2419200));
            return RestResult.ok(map);
        }else{
            return RestResult.build(500,"登录失败，该用户或者密码不正确！");
        }
    }

    /**
     * 获取随机账号以及姓名
     */
    @PostMapping(value = "/getSignature")
    public RestResult getSignature(){
        HashMap<String,Object> map = new HashMap<>();
        String Identifier = UUID.randomUUID().toString().replace("-","");
        map.put("Identifier",Identifier);
        String UserSig = new TLSSigAPIv2(sdkappid,secretkey).genSig(Identifier,2419200);
        map.put("UserSig",UserSig);
        return RestResult.ok(map);
    }

}
