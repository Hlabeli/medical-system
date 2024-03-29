package com.thutohealthcare.medicalsystem.persistence.entity.pharmacy;

import com.thutohealthcare.medicalsystem.persistence.entity.common.AbstractEntity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class InventoryEntity extends AbstractEntity {

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_qty")
    private Integer itemQty;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;
}
