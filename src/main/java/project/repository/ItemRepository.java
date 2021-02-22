package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.entity.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}