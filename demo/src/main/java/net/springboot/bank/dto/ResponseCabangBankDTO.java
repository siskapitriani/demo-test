package net.springboot.bank.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@ToString
@Getter
@Setter
public class ResponseCabangBankDTO implements Serializable {
    private static final long serialVersionUID = 1387689230266870365L;
    private Long kodeCabang;
    private String namaCabang;

    public ResponseCabangBankDTO(Long kodeCabang, String namaCabang) {
        this.kodeCabang = kodeCabang;
        this.namaCabang = namaCabang;
    }

    public ResponseCabangBankDTO() {
    }
}
