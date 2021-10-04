package com.code.design.lombok;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "member")
@Data
@Builder
//@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, updatable = false, unique = true)
    private String email;
//    private String email = "test@test.com"; // @Builder.Default 테스트할 때 사용

//    @Builder.Default
    @Column(name = "name", nullable = false)
    private String name;
//    private String name = "yun"; // @Builder.Default 테스트할 때 사용

    @OneToMany
    @JoinColumn(name = "coupon_id")
    private List<Coupon> coupons = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;
}