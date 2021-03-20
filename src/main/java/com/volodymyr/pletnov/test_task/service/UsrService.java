package com.volodymyr.pletnov.test_task.service;

import com.volodymyr.pletnov.test_task.model.dto.UsrDecodeRequest;
import com.volodymyr.pletnov.test_task.model.dto.UsrDecodeResponse;
import com.volodymyr.pletnov.test_task.model.dto.UsrEcodeResponse;
import com.volodymyr.pletnov.test_task.model.dto.UsrEncodeRequest;

public interface UsrService {
	UsrEcodeResponse getEncodedUsrById(UsrEncodeRequest usrEncodeRequest);

	UsrDecodeResponse decodeByFioEncr(UsrDecodeRequest usrDecodeRequest);
}
