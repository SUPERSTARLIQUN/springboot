package com.tencent.classroom.vo;

public class TencentVo {

    /**
     * APP管理员帐号
     */
    private String Identifier;


    /**
     * APP管理员帐号的签名
     */
    private String UserSig;


    /**
     * 云通信服务中申请的APPID
     */
    private long SdkAppid;


    /**
     * 密匙
     */
    private String secretkey;


    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public String getUserSig() {
        return UserSig;
    }

    public void setUserSig(String userSig) {
        UserSig = userSig;
    }

    public long getSdkAppid() {
        return SdkAppid;
    }

    public void setSdkAppid(long sdkAppid) {
        SdkAppid = sdkAppid;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }
}
