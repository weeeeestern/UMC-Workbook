package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
  public RegionHandler(BaseErrorCode errorCode) {
    super(errorCode);
  }
}