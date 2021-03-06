package com.batch.modules.batch.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BatchResultDTO {
    private String store;
    private String productName;
    private String totalCount;
    private String totalPrice;
}
