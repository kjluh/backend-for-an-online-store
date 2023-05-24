package ru.skypro.homework.service.impl;

import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.repositories.ReqRepository;
import ru.skypro.homework.service.RegisterReqService;

public class RegisterReqServiceImp implements RegisterReqService {

    private ReqRepository reqRepository;

    private RegisterReqServiceImp(ReqRepository reqRepository) {
        this.reqRepository = reqRepository;
    }

    @Override
    public boolean checkRegisterReq(RegisterReq req) {
        RegisterReq user = reqRepository.findById(req.getId()).orElse(null);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public RegisterReq registration(RegisterReq req) {
        if (!checkRegisterReq(req)){
            reqRepository.save(req);
        }
        return req;
    }

    @Override
    public RegisterReq updatePassword(RegisterReq req) {

        return null;
    }

    @Override
    public RegisterReq infoForReq(RegisterReq req) {
        return null;
    }

    @Override
    public RegisterReq updateInfoForUser(RegisterReq req) {
        return null;
    }
}
