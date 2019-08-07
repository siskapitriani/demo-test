package net.springboot.bank.endpoint.impl;

import net.springboot.bank.dto.RequestCabangBankDTO;
import net.springboot.bank.dto.ResponseCabangBankDTO;
import net.springboot.bank.endpoint.ICabangBankEndPoint;
import net.springboot.bank.exception.APIErrorBuilder;
import net.springboot.bank.exception.ServiceException;
import net.springboot.bank.model.CabangBank;
import net.springboot.bank.repository.ICabangBankDAO;
import net.springboot.bank.service.ICabangBankService;
import net.springboot.bank.service.impl.CabangBankServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CabangBankEndPointImpl implements ICabangBankEndPoint {
    @Autowired
    private ICabangBankDAO iCabangBankDAO;

    @Autowired
    private ICabangBankService iCabangBankService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CabangBankServiceImpl.class);

    @Override
    public List<CabangBank> findAllCabangBank() {
        return iCabangBankDAO.findAll();
    }

    @Override
    public ResponseEntity<CabangBank> findById(HttpServletRequest httpServletRequest, @PathVariable Long id) {
        CabangBank result = new CabangBank();
        try {
            result = iCabangBankDAO.findCabang(id);
        } catch (Exception e) {
            return new ResponseEntity(APIErrorBuilder.notFound(ServiceException.class, "Kode Cabang ".concat(String.valueOf(id)).concat(" tidak terdaftar"),
                    httpServletRequest.getRequestURI()), HttpStatus.NOT_FOUND);
        }
             if (result != null ){
                 ResponseCabangBankDTO hasil = new ResponseCabangBankDTO();
                 hasil.setKodeCabang(result.getKodeCabang());
                 hasil.setNamaCabang(result.getNamaCabang());
                 return ResponseEntity.ok(result);
             } else {
                 return new ResponseEntity(APIErrorBuilder.notFound(ServiceException.class, "Kode Cabang ".concat(String.valueOf(id)).concat(" tidak terdaftar"),
                                 httpServletRequest.getRequestURI()), HttpStatus.NOT_FOUND);
             }
    }

    @Override
    public ResponseEntity<CabangBank> update(HttpServletRequest httpServletRequest, @RequestBody RequestCabangBankDTO request, @PathVariable Long id){
        try {
            return iCabangBankService.updateCabangBank(httpServletRequest, request, id);
        } catch (ServiceException e) {
            LOGGER.error("Failed Update Cabang Bank, {}",e.getMessage());
            return new ResponseEntity(APIErrorBuilder.internalServerError(ServiceException.class, "Failed Update Cabang Bank, ".concat(e.getMessage()),
                    httpServletRequest.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity<CabangBank> add(HttpServletRequest httpServletRequest, @RequestBody RequestCabangBankDTO request) {
        try {
            return iCabangBankService.addCabangBank(httpServletRequest, request);
        } catch (ServiceException e) {
            LOGGER.error("Failed Saving Cabang Bank, {}",e.getMessage());
            return new ResponseEntity(APIErrorBuilder.internalServerError(ServiceException.class, "Failed Saving Cabang Bank, ".concat(e.getMessage()),
                    httpServletRequest.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public CabangBank delete(HttpServletRequest httpServletRequest, @PathVariable Long id) {
        CabangBank result = new CabangBank();
        try {
            result = iCabangBankDAO.findCabang(id);
        } catch (Exception e) {
            LOGGER.error("Failed findCabang {}", e.getMessage());
        }
        if (result != null ){
            LOGGER.info("Success deleted {}", id );
            iCabangBankDAO.deleteById(id);
        }
        return result;
    }
}
