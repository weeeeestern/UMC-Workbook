package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public MissionHandler(BaseErrorCode errorCode) {

        super(errorCode);
    }
}
