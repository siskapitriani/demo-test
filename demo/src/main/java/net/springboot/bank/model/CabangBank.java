package net.springboot.bank.model;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@Entity
@Table (name = "cabang_bank")
public class CabangBank implements Serializable {

    private static final long serialVersionUID = -1242274569489772011L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kode_cabang", nullable = false, unique = true)
    private Long kodeCabang;

    @Column (name = "nama_cabang")
    private  String namaCabang;

    @Column (name = "alamat_cabang")
    private String alamatCabang;

}
