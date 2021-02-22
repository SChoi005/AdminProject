package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.entity.AdminUser;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
    
}