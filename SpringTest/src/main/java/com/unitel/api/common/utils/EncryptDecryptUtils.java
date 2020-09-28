/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.api.common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author stl_sdd_thavithong
 */
public class EncryptDecryptUtils {

    private static byte[] key = {-95, -29, -62, 25, 25, -83, -18, -85};
    private static String algorithm = "DES";
    private static SecretKeySpec keySpec = new SecretKeySpec(key, algorithm);

    public static String decryptFile(String encryptedFilePath) {
        String returnValue = "";
        try {
            FileInputStream stream = new FileInputStream(encryptedFilePath);
            int bytesRead = 0;
            byte[] buffer = new byte[8120];
            while ((bytesRead = stream.read(buffer, 0, 8120)) != -1) {
                byte[] cloneBuffer = new byte[bytesRead];
                if (bytesRead < buffer.length) {
                    for (int i = 0; i < bytesRead; i++) {
                        cloneBuffer[i] = buffer[i];
                    }
                }
                returnValue = returnValue + new String(decrypt(cloneBuffer));
            }
            stream.close();
        } catch (FileNotFoundException fex) {
            fex.printStackTrace();
        } catch (IOException iex) {
            iex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnValue;
    }

    public static byte[] decrypt(byte[] arrByte) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(2, keySpec);
        return cipher.doFinal(arrByte);
    }
    

}
