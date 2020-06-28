package com.lankeren.auction.bean;

/**
 * @author lankeren
 * @ClassName Permission
 * @Deacription:
 * @create: 2020-06-28 16:17
 */
public class Permission {

    private Integer id;
    private String url;
    private String name;

    public Permission() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
