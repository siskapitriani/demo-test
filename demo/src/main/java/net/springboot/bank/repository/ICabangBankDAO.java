package net.springboot.bank.repository;

import net.springboot.bank.exception.DAOException;
import net.springboot.bank.model.CabangBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICabangBankDAO extends JpaRepository<CabangBank, Long> {
    @Query (value ="SELECT * FROM cabang_bank WHERE kode_cabang = ?1 " , nativeQuery = true)
    CabangBank findCabang (Long kodeBank) throws DAOException;
}
