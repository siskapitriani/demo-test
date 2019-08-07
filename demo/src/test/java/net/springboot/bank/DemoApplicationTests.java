package net.springboot.bank;

import net.springboot.bank.DemoApplication;
import net.springboot.bank.dto.RequestCabangBankDTO;
import net.springboot.bank.endpoint.ICabangBankEndPoint;
import net.springboot.bank.model.CabangBank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	private ICabangBankEndPoint iCabangBankEndPoint;

	@Test
	public void testFindById(){

		HttpServletRequest httpServletRequest = null;
		ResponseEntity<CabangBank> kodeCabang = iCabangBankEndPoint.findById(httpServletRequest, 170L);

		assertThat(kodeCabang).isNotNull();
	}

	@Test
	public void testFindAllCabangBank(){
		List<CabangBank> cabangBank = iCabangBankEndPoint.findAllCabangBank();
		assertThat(cabangBank).isNotNull();
	}

	@Test
	public void testUpdateCabangBank(){
		HttpServletRequest httpServletRequest = null;
		RequestCabangBankDTO requestCabangBankDTO =new RequestCabangBankDTO();
		requestCabangBankDTO.setNamaCabang("Pasir Kaliki");
		requestCabangBankDTO.setAlamatCabang("Jl. Pasir Kaliki no. 65 Bandung");
		ResponseEntity<CabangBank> update = iCabangBankEndPoint.update(httpServletRequest,requestCabangBankDTO,16L);
		assertThat(update).isNotNull();
	}

	@Test
	public void testAddCabangBank(){
		HttpServletRequest httpServletRequest = null;
		RequestCabangBankDTO request = new RequestCabangBankDTO();
		request.setNamaCabang("Lembang");
		request.setAlamatCabang("Jl. Lembang no. 1 Bandung");
		ResponseEntity<CabangBank> add = iCabangBankEndPoint.add(httpServletRequest,request);
		assertThat(add).isNotNull();
	}

	@Test
	public void testDeleteCabangBank(){
		HttpServletRequest httpServletRequest = null;
		CabangBank delete = iCabangBankEndPoint.delete(httpServletRequest,172L);
		assertThat(delete).isNotNull();
	}
}
