package com.gao.domain;

import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/12 18:21
 */
public class QueryVo {
    private User user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
