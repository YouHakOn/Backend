package net.youhak.member.repository;

import net.youhak.member.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleJpaRepository extends JpaRepository<Role, Long> {

    @Modifying
    @Query("""
            update Role r
            set r.isDeleted = true
            where r.id = :id
            """)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query("""
            update Role r
            set r.isDeleted = true
            where r.roleCategory.id = :categoryId
            """)
    void deleteByRoleCategoryId(@Param("categoryId") Long categoryId);
}
