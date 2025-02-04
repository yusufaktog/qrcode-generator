package com.aktog.yusuf.qrcodegenerator.controller;

import com.aktog.yusuf.qrcodegenerator.service.QrCodeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QrCodeController {
    private final QrCodeService qrCodeService;


    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping(value = "/qr", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] generateQrCodeApi(@RequestParam String text,
                                                  @RequestParam(required = false, defaultValue = "200" ) int width,
                                                  @RequestParam(required = false, defaultValue = "200") int height) {


        return qrCodeService.generateQrCode(text, width, height);
    }
}
