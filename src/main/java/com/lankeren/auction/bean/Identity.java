package com.lankeren.auction.bean;

/**
 * @author lankeren
 * @ClassName Identity
 * @Deacription:
 * @create: 2020-06-28 16:15
 */
public class Identity {

    private Integer id;
    private String identityName;
    private String dec;

    public Identity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
}
