package net.youhak.member.role.repository;

import java.util.Optional;
import net.youhak.member.role.domain.RoleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleCategoryJpaRepository extends JpaRepository<RoleCategory, Long> {

    @Query("""
            select rc
            from RoleCategory rc
            where rc.id =:id
                and rc.isDeleted = false
            """)
    Optional<RoleCategory> findById(@Param("id") Long id);

    @Modifying
    @Query("""
            update RoleCategory rc
            set rc.isDeleted = true
            where rc.id = :id
            """)
    void deleteById(@Param("id") Long id);
}
