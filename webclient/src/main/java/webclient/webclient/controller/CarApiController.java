package webclient.webclient.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webclient.webclient.model.CarDto;
import webclient.webclient.service.CarApiService;

@RestController
@RequestMapping("random-data")
public class CarApiController {
    private final CarApiService service;

    public CarApiController(CarApiService service) {
        this.service = service;
    }

    @PostMapping("buy-car")
    public CarDto buyCar(){
        return this.service.buyNewCar();
    }
}
