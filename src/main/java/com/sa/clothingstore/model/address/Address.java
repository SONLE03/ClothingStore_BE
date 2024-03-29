package com.sa.clothingstore.model.address;

import com.sa.clothingstore.model.user.customer.CustomerAddress;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "province")
    private String province;
    @Column(name = "district")
    private String district;
    @Column(name = "ward")
    private String ward;
    @Column(name = "specific_address")
    private String specificAddress;
    @Column(name = "postal_code")
    private String postalCode;

    @OneToMany(mappedBy = "address")
    Set<CustomerAddress> customerAddressSet;
}
