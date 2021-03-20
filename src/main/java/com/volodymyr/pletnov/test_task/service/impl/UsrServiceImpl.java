package com.volodymyr.pletnov.test_task.service.impl;

import com.volodymyr.pletnov.test_task.exception.NotFoundException;
import com.volodymyr.pletnov.test_task.model.Usr;
import com.volodymyr.pletnov.test_task.model.dto.UsrDecodeRequest;
import com.volodymyr.pletnov.test_task.model.dto.UsrDecodeResponse;
import com.volodymyr.pletnov.test_task.model.dto.UsrEcodeResponse;
import com.volodymyr.pletnov.test_task.model.dto.UsrEncodeRequest;
import com.volodymyr.pletnov.test_task.repo.UsrRepo;
import com.volodymyr.pletnov.test_task.service.UsrService;
import com.volodymyr.pletnov.test_task.util.AES256;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsrServiceImpl implements UsrService {

	private final UsrRepo usrRepo;

	@Override
	public UsrEcodeResponse getEncodedUsrById(UsrEncodeRequest usrEncodeRequest) {
		Usr user = usrRepo.findById(usrEncodeRequest.getId())
				.orElseThrow(() -> new NotFoundException("User not found!"));
		return UsrEcodeResponse.builder()
				.fioEncr(AES256.encrypt(user.getFioEncr()))
				.build();
	}

	@Override
	public UsrDecodeResponse decodeByFioEncr(UsrDecodeRequest usrDecodeRequest) {
		Usr user = usrRepo.findByFioEncr(AES256.decrypt(usrDecodeRequest.getFioEncr()))
				.orElseThrow(() -> new NotFoundException("User not found!"));
		return UsrDecodeResponse.builder()
				.fio(user.getFioEncr())
				.build();
	}
}
