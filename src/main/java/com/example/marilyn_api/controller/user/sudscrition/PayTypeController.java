package com.example.marilyn_api.controller.user.sudscrition;

import com.example.marilyn_api.Domain.user.subscription.PayType;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.user.subscription.PayTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/paytype/")
public class PayTypeController implements Icontroller<PayType,String> {
    @Autowired
    private PayTypeService payTypeService;

    @PostMapping("create")
    @Override
    public PayType create(PayType payType) {
        return payTypeService.create(payType);
    }
    @GetMapping("read")
    @Override
    public PayType read(String id) {
        return payTypeService.read(id);
    }
    @PostMapping("update")
    @Override
    public PayType update(@RequestBody PayType payType) {
        return payTypeService.update(payType);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return payTypeService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<PayType> readALl() {
        return payTypeService.readAll();
    }

    @Override
    public List<PayType> readALlOff(String id) {
        return null;
    }
}
