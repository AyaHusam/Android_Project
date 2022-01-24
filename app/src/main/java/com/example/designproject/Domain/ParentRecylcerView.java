package com.example.designproject.Domain;

import java.util.List;

public class ParentRecylcerView {
     public String title;
     public List<DomainCategory>domainCategoryList;

    public ParentRecylcerView(String title, List<DomainCategory> domainCategoryList) {
        this.title = title;
        this.domainCategoryList = domainCategoryList;
    }
}
