package project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    // id를 역순으로(Desc) 제일 처음으로 나오는 phoneNumber
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
}
