package com.tencent.classroom.controller;

import com.tencent.classroom.config.DismissRoomRequest;
import com.tencent.classroom.config.DismissRoomResponse;
import com.tencent.classroom.config.TrtcClient;
import com.tencent.classroom.pojo.ClassPeopleMiddle;
import com.tencent.classroom.pojo.ClassRoom;
import com.tencent.classroom.service.ClassPeopleMiddleService;
import com.tencent.classroom.service.ClassRoomService;
import com.tencent.classroom.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;



@RestController
@RequestMapping(value = "/classroom")
public class ClassRoomController {

    @Autowired
    ClassRoomService classRoomService;

    @Autowired
    ClassPeopleMiddleService classPeopleMiddleService;

    @Value("${tencent.secretId}")
    private String secretId;

    @Value("${tencent.secretKey}")
    private String secretKey;

    @Value("${tencent.SDKAPPID}")
    private long sdkappid;




    /**
     * 获取课堂列表
     * @return
     */
    @GetMapping(value = "/findAllClassRoom")
    public RestResult findAllClassRoom(){
        return RestResult.ok(classRoomService.findAllClassRoom());
    }


    /**
     * 新增课堂接口
     * @param classRoom
     * @return
     */
    @PostMapping(value = "/addClassRoom")
    public RestResult addClassRoom(@RequestBody ClassRoom classRoom){
        if(classRoomService.insertSelective(classRoom)>0){
            return RestResult.ok();
        }else{
            return RestResult.build(500,"创建课堂失败");
        }
    }


    /**
     * 加入课堂
     */
    @PostMapping(value = "/joinClassRoom")
    public RestResult joinClassRoom(@RequestBody ClassPeopleMiddle classPeopleMiddle){
        if(classPeopleMiddleService.insert(classPeopleMiddle)>0){
            return RestResult.ok();
        }else{
            return RestResult.build(500,"加入课堂失败");
        }
    }


    /**
     * 解散课堂
     */
    @PostMapping(value = "/disbandClass")
    public RestResult disbandClass(Integer id){
        try{
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("trtc.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TrtcClient client = new TrtcClient(cred, "ap-beijing", clientProfile);
            String params = "{\"SdkAppId\":"+sdkappid+",\"RoomId\":"+id+"}";
            DismissRoomRequest req = DismissRoomRequest.fromJsonString(params, DismissRoomRequest.class);
            DismissRoomResponse resp = client.DismissRoom(req);
            return RestResult.ok(DismissRoomRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            return RestResult.build(500,e.getMessage());
        }
    }
}
