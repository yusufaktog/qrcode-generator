package com.aktog.yusuf.qrcodegenerator.service;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class QrCodeService {
    public byte[] generateQrCode(String text, int width, int height) {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix;
        ByteArrayOutputStream pngOutputStream;
        Map<EncodeHintType, String> encodeHints = Map.of(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, encodeHints);
            pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }

        return pngOutputStream.toByteArray();
    }
}
