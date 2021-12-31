package com.batch.modules.batch.domain.dto.response;

import lombok.Data;

@Data
public class BatchResultDTO {
    private String store;
    private String productName;
    private Long totalCount;
    private Long totalPrice;
}
