package com.quvvxx.ecommerce.domain.member.entity;

import com.quvvxx.ecommerce.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member_credentials")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCredential extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, unique = true)
    private Member memberId;

    @Column(nullable = false)
    private String password;

}
