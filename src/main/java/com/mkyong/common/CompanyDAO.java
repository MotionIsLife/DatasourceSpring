package com.mkyong.common;

/**
 * Created by konstantin on 17.06.16.
 */
public interface CompanyDAO {
    public void insert(Company company);
    public Company findCompanyById(int idCom);
}
