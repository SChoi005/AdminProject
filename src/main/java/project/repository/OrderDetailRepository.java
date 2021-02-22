package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.entity.OrderDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
    // Long은 id가 primary key이기 때문에 작성
}