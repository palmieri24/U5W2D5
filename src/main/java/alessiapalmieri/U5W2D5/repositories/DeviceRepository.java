package alessiapalmieri.U5W2D5.repositories;

import alessiapalmieri.U5W2D5.entities.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Page<Device> findByStatus(String status, Pageable pageable);
    Page<Device> findByType(String type, Pageable pageable);
    Page<Device> findByTypeAndStatus(String type, String status, Pageable pageable);
    Optional<Device> findByEmployee_id(long id);

}
