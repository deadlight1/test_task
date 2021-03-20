package com.volodymyr.pletnov.test_task.controller;

import com.volodymyr.pletnov.test_task.model.dto.UsrDecodeRequest;
import com.volodymyr.pletnov.test_task.model.dto.UsrDecodeResponse;
import com.volodymyr.pletnov.test_task.model.dto.UsrEcodeResponse;
import com.volodymyr.pletnov.test_task.model.dto.UsrEncodeRequest;
import com.volodymyr.pletnov.test_task.service.UsrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/usr")
public class UsrController {

	private final UsrService usrService;

	/*
	Требования:
	- Формат запросов POST.
	That's why I use POST method
	*/
	@PostMapping("/encode")
	public UsrEcodeResponse getEncodedUsrById(@RequestBody UsrEncodeRequest usrEncodeRequest) {
		return usrService.getEncodedUsrById(usrEncodeRequest);
	}

	@PostMapping("/decode")
	public UsrDecodeResponse decodeByFioEncr(@RequestBody UsrDecodeRequest usrDecodeRequest) {
		return usrService.decodeByFioEncr(usrDecodeRequest);
	}
}
