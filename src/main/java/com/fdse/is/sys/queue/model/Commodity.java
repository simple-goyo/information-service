package com.fdse.is.sys.queue.model;

/**
 * <pre>
 *     author : shenbiao
 *     e-mail : 1105125966@qq.com
 *     time   : 2018/09/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Commodity {
    private int id;
    private String description;
    private int maxdistance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxdistance() {
        return maxdistance;
    }

    public void setMaxdistance(int maxdistance) {
        this.maxdistance = maxdistance;
    }
}
