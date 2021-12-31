package com.batch.modules.order.repository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderQueryDSLRepository {
    List<String> findDistinctStore();
    List<String> findDistinctNameByStore(String store);
    Long getTotalPrice(String store,String name);
    Long getTotalCount(String store,String name);
}