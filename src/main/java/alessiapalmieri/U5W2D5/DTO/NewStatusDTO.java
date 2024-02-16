package alessiapalmieri.U5W2D5.DTO;

import jakarta.validation.constraints.NotNull;

public record NewStatusDTO(
        @NotNull(message = "Device status is a required field! Choose between AVAILABLE, ASSIGNED, MAINTENANCE, DISPOSED")
        String deviceStatus){
}
