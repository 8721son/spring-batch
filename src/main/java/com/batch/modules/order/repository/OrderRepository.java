package com.batch.modules.order.repository;

import com.batch.modules.order.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>,OrderQueryDSLRepository{
//    @Query("SELECT DISTINCT(o.store) FROM OrderEntity o")
//    List<String> findDistinctStore();
//
//    @Query("SELECT DISTINCT(o.name) FROM OrderEntity o WHERE o.store=:store")
//    List<String> findDistinctNameByStore(String store);
//
//    @Query("SELECT sum(o.totalPrice) FROM OrderEntity o WHERE o.store=:store AND o.name=:name")
//    Long getTotalPrice(String store,String name);
//
//    @Query("SELECT sum(o.productCount) FROM OrderEntity o WHERE o.store=:store AND o.name=:name")
//    Long getTotalCount(String store,String name);
}
