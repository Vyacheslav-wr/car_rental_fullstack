package by.salei.rental.admin.controller;

import by.salei.rental.dto.CarDTO;
import by.salei.rental.entity.Car;
import by.salei.rental.entity.CarStatus;
import by.salei.rental.entity.CarType;
import by.salei.rental.mapper.CarMapper;
import by.salei.rental.repo.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminCarController {

    private final CarRepository repository;
    private final CarMapper mapper;
    private final static String LINK_TO_SAVE_IMAGE = "";

    @GetMapping("/car")
    public ModelAndView getAllCars() {

        ModelAndView mv =  new ModelAndView("admin/AdminCarPages");
        mv.addObject("cars", repository.findAll());

        return mv;
    }

    @PostMapping("/car/create")
    public ModelAndView createNewCar(CarDTO dto) {
        ModelAndView mv = new ModelAndView("redirect:/admin/car");
        dto.setBooster(true);
        dto.setCharger(true);
        dto.setClimateControl(true);
        Car car = mapper.convert(dto);
        car.setStatus(CarStatus.FREE);

        repository.save(car);

        return mv;
    }

    @GetMapping("/car/create/page")
    public ModelAndView showCreatePage() {
        ModelAndView mv = new ModelAndView("admin/car-create-page");
        return mv;
    }

    @GetMapping("/car/{id}")
    public ModelAndView getCar(@PathVariable(name = "id") Integer id) {

        ModelAndView mv = new ModelAndView("admin/car-update-page");
        Optional<Car> car = repository.findById(id);

        car.ifPresent(value -> mv.addObject("car", value));

        return mv;
    }

    @PostMapping("/car/{id}/update")
    public ModelAndView updateCar(@PathVariable(name = "id") Integer id, CarDTO dto) {
        ModelAndView mv = new ModelAndView("redirect:/admin/carfdsfadsfsfdsaf");

        Optional<Car> car = repository.findById(id);

        if (car.isPresent()) {
            Car newCar = car.get();
            newCar.setStatus(CarStatus.FREE);
            newCar.setCharger(dto.getCharger());
            newCar.setMark(dto.getMark());
            newCar.setToning(dto.getToning());
            newCar.setMileage(dto.getMileage());
            newCar.setCarType(CarType.valueOf(dto.getCarType()));

           repository.save(newCar);
        }

        return mv;
    }

    @GetMapping("/car/{id}/delete")
    public ModelAndView deleteCar(@PathVariable(name = "id") Integer id) {
        ModelAndView mv = new ModelAndView("redirect:/admin/car");

        repository.deleteById(id);
        return mv;
    }

}
