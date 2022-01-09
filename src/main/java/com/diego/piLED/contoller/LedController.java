package com.diego.piLED.contoller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting(){
        return "Hello from spring app!!";
    }

    @RequestMapping("/light")
    public String switchLight(){
        if (pin ==null){
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02,"Hot LED pin", PinState.LOW);
        }

        pin.toggle();

        return "light endpoint has been hit!!";
    }

}
