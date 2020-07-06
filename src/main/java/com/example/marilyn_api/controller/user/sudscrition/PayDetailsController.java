package com.example.marilyn_api.controller.user.sudscrition;

import com.example.marilyn_api.Domain.user.subscription.PayDetails;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.user.subscription.PayDatailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/pay_details/")
public class PayDetailsController implements Icontroller<PayDetails,String> {
    @Autowired
    private PayDatailsService payDatailsService;

    @PostMapping("create")
    @Override
    public PayDetails create(@RequestBody PayDetails payDetails) {
        return payDatailsService.create(payDetails);
    }
    @GetMapping("read")
    @Override
    public PayDetails read(@RequestParam("id") String id) {
        return payDatailsService.read(id);
    }
    @PostMapping("update")
    @Override
    public PayDetails update(@RequestBody PayDetails payDetails) {
        return payDatailsService.update(payDetails);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return payDatailsService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<PayDetails> readALl() {
        return payDatailsService.readAll();
    }

    @GetMapping("readAllOf")
    @Override
    public List<PayDetails> readALlOff(@RequestParam("id") String id) {
        return payDatailsService.readAllOf(id);
    }
}
