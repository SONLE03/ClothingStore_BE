package com.sa.clothingstore.model.payment;

import com.sa.clothingstore.model.CommonModel;
import com.sa.clothingstore.model.attribute.Image;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payment_method")
public class PaymentMethod extends CommonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "image")
    private Image image;
    @Column(name = "name")
    private String name;
}
