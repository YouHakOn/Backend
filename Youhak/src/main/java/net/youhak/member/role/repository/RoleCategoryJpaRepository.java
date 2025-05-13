package net.youhak.member.role.repository;

import net.youhak.member.role.domain.RoleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleCategoryJpaRepository extends JpaRepository<RoleCategory, Long> {

    @Modifying
    @Query("update RoleCategory rc set rc.isDeleted = true where rc.id = :id")
    void deleteById(@Param("id") Long id);
}
