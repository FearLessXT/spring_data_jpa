package com.ciftp.project.models.embeded;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {

    @EmbeddedId
    private OrderId orderId;

    private String orderInfo;

    private String anotherField;
}
