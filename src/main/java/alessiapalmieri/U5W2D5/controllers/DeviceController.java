package alessiapalmieri.U5W2D5.controllers;

import alessiapalmieri.U5W2D5.DTO.NewDeviceDTO;
import alessiapalmieri.U5W2D5.DTO.NewEmployeeDeviceDTO;
import alessiapalmieri.U5W2D5.DTO.NewStatusDTO;
import alessiapalmieri.U5W2D5.entities.Device;
import alessiapalmieri.U5W2D5.exceptions.BadRequestException;
import alessiapalmieri.U5W2D5.exceptions.NotFoundException;
import alessiapalmieri.U5W2D5.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("")
    public Page<Device> getDevices(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String orderBy) {
        return deviceService.getDevices(page, size, orderBy);
    }

    @GetMapping("/{id}")
    public Device findById(@PathVariable long id) {
        return deviceService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Device save(@RequestBody @Validated NewDeviceDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return deviceService.save(body);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long id) throws NotFoundException {
        deviceService.findByIdAndDelete(id);
    }

    @PutMapping("/update/status/{id}")
    public Device findByIdAndUpdateStatus(@PathVariable long id, @RequestBody NewStatusDTO body) {
        return deviceService.findByIdAndUpdateStatus(id, body);

    }

    @PutMapping("/update/employee/{id}")
    public Device findByIdAndUpdateEmployee(@PathVariable long id, @RequestBody NewEmployeeDeviceDTO body) {
        return deviceService.findByIdAndUpdateEmployee(id, body);
    }
}
