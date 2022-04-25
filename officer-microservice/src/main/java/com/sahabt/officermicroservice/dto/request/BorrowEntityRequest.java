package com.sahabt.officermicroservice.dto.request;

import java.util.List;

public class BorrowEntityRequest {
    private String userId;
    private List<String> bookIdList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getBookIdList() {
        return bookIdList;
    }

    public void setBookIdList(List<String> bookIdList) {
        this.bookIdList = bookIdList;
    }
}
