package com.volodymyr.pletnov.test_task.util;

import com.volodymyr.pletnov.test_task.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Slf4j
public class AES256 {

	private static final String SECRET_KEY = "my_super_secret_key";
	private static final String SALT = "ssshhhhhhhhhhh!!!!";

	public static String decrypt(String strToDecrypt) {
		try {
			Cipher cipher = defaultCipher(Cipher.DECRYPT_MODE);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			log.info("Error while decrypting: " + e.toString());
			throw new NotFoundException("");
		}
	}

	public static String encrypt(String strToEncrypt) {
		try {
			Cipher cipher = defaultCipher(Cipher.ENCRYPT_MODE);
			return Base64.getEncoder()
					.encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			log.info("Error while encrypting: " + e.toString());
			throw new NotFoundException("");
		}
	}

	private static Cipher defaultCipher(int mode) throws GeneralSecurityException {
		byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		IvParameterSpec ivspec = new IvParameterSpec(iv);

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(mode, secretKey, ivspec);
		return cipher;
	}
}
