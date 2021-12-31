package com.batch.modules.order.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.batch.modules.order.domain.entity.QOrderEntity.orderEntity;

@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderQueryDSLRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<String> findDistinctStore() {
        return jpaQueryFactory
                .select(orderEntity.store)
                .from(orderEntity)
                .distinct()
                .fetch();
    }

    @Override
    public List<String> findDistinctNameByStore(String store) {
        return jpaQueryFactory.select(orderEntity.name)
                .from(orderEntity)
                .where(orderEntity.store.eq(store))
                .distinct()
                .fetch();
    }

    @Override
    public Long getTotalPrice(String store, String name) {
        return jpaQueryFactory.select(orderEntity.totalPrice.sum())
                .from(orderEntity)
                .where(orderEntity.store.eq(store)
                        .and(orderEntity.name.eq(name)))
                .fetchOne();
    }

    @Override
    public Long getTotalCount(String store, String name) {
        return jpaQueryFactory.select(orderEntity.productCount.sum())
                .from(orderEntity)
                .where(orderEntity.store.eq(store)
                        .and(orderEntity.name.eq(name)))
                .fetchOne();
    }
}
