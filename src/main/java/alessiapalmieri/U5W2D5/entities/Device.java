package alessiapalmieri.U5W2D5.entities;

import alessiapalmieri.U5W2D5.Enum.DeviceStatus;
import alessiapalmieri.U5W2D5.Enum.DeviceType;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;
    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Device(DeviceType deviceType, DeviceStatus deviceStatus, Employee employee) {
        this.deviceType = deviceType;
        this.deviceStatus = deviceStatus;
        this.employee = employee;
    }
}
