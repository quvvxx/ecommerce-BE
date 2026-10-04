package com.quvvxx.ecommerce.domain.member.repository;

import com.quvvxx.ecommerce.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
