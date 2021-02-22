package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.entity.OrderGroup;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderGroupRepository extends JpaRepository<OrderGroup, Long> {
    
}