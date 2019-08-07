package net.springboot.bank.service.impl;

import net.springboot.bank.dto.RequestCabangBankDTO;
import net.springboot.bank.exception.APIErrorBuilder;
import net.springboot.bank.exception.ServiceException;
import net.springboot.bank.model.CabangBank;
import net.springboot.bank.repository.ICabangBankDAO;
import net.springboot.bank.service.ICabangBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CabangBankServiceImpl implements ICabangBankService {

    @Autowired
    private ICabangBankDAO iCabangBankDAO;
    private static final Logger LOGGER = LoggerFactory.getLogger(CabangBankServiceImpl.class);


    @Override
    public ResponseEntity<CabangBank> updateCabangBank(HttpServletRequest httpServletRequest, RequestCabangBankDTO requestCabangBankDTO, Long id) throws ServiceException {
        CabangBank findById = new CabangBank();
        try {
            findById = iCabangBankDAO.findCabang(id);
        } catch (Exception e) {
            return new ResponseEntity(APIErrorBuilder.notFound(ServiceException.class, "Kode Cabang ".concat(String.valueOf(id)).concat(" tidak terdaftar"),
                    httpServletRequest.getRequestURI()), HttpStatus.NOT_FOUND);
        }

        if (findById != null){
            findById.setNamaCabang(requestCabangBankDTO.getNamaCabang());
            findById.setAlamatCabang(requestCabangBankDTO.getAlamatCabang());

            CabangBank save = iCabangBankDAO.save(findById);
            LOGGER.info("Success Update Cabang Bank : {}", save);
            return ResponseEntity.ok(save);
        }else{
            LOGGER.error("Failed Update Cabang Bank");
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<CabangBank> addCabangBank(HttpServletRequest httpServletRequest, RequestCabangBankDTO request) throws ServiceException {
            CabangBank result = new CabangBank();
            result.setNamaCabang(request.getNamaCabang());
            result.setAlamatCabang(request.getAlamatCabang());
            CabangBank save = iCabangBankDAO.save(result);

            LOGGER.info("Success Add Cabang Bank : {}", save);
        return ResponseEntity.ok(save);
    }
}
