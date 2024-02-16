package alessiapalmieri.U5W2D5.repositories;

import alessiapalmieri.U5W2D5.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByUsername(String username);
    Page<Employee> findByName(String name, Pageable pageable);
    Page<Employee> findByLastName(String lastname, Pageable pageable);
    Page<Employee> findByNameAndLastName(String name, String lastname, Pageable pageable);
}
