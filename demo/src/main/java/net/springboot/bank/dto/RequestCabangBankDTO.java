package net.springboot.bank.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class RequestCabangBankDTO implements Serializable {
    private static final long serialVersionUID = -6959361589709713959L;
    private String namaCabang;
    private String alamatCabang;

}
