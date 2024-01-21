package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.entity.StaffEntity;

import java.util.Optional;

public interface IStaffRepository extends JpaRepository<StaffEntity, Long> {

    Optional<StaffEntity> findByUuid(String uuid);

}
