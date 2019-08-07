package net.springboot.bank.service;

import net.springboot.bank.dto.RequestCabangBankDTO;
import net.springboot.bank.exception.ServiceException;
import net.springboot.bank.model.CabangBank;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

public interface ICabangBankService {
    @Transactional
    ResponseEntity<CabangBank> updateCabangBank (HttpServletRequest httpServletRequest, RequestCabangBankDTO request, Long id) throws ServiceException;

    @Transactional
    ResponseEntity<CabangBank> addCabangBank (HttpServletRequest httpServletRequest, RequestCabangBankDTO request) throws ServiceException;
}
