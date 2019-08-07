package net.springboot.bank.endpoint;

import net.springboot.bank.dto.RequestCabangBankDTO;
import net.springboot.bank.model.CabangBank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/cabang")
public interface ICabangBankEndPoint {
    @GetMapping("/findAll")
    List<CabangBank> findAllCabangBank ();

    @GetMapping("/findbyid/{id}")
    ResponseEntity<CabangBank> findById (HttpServletRequest httpServletRequest, @PathVariable Long id);

    @PutMapping("/update/{id}")
    ResponseEntity<CabangBank> update (HttpServletRequest httpServletRequest, @RequestBody RequestCabangBankDTO requestCabangBankDTO, @PathVariable Long id) ;

    @PostMapping("/add")
    ResponseEntity<CabangBank> add (HttpServletRequest httpServletRequest,@RequestBody RequestCabangBankDTO request);

    @DeleteMapping("/delete/{id}")
    CabangBank delete (HttpServletRequest httpServletRequest, @PathVariable Long id);
}
