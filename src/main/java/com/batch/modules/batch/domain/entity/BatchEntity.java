package com.batch.modules.batch.domain.entity;


import com.batch.modules.batch.domain.dto.response.BatchResultDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.batch.modules.utils.NumberUtil.dotNumberStrNormal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_batch")
public class BatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;
    private String store;
    private String name;
    private Long totalPrice;
    private Long totalCount;

    public BatchResultDTO toDTO() {
        return BatchResultDTO.builder()
                .store(store)
                .productName(name)
                .totalCount(dotNumberStrNormal(totalCount))
                .totalPrice(dotNumberStrNormal(totalPrice))
                .build();
    }
}
