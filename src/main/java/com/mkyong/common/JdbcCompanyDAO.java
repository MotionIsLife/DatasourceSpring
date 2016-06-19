package com.mkyong.common;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by konstantin on 17.06.16.
 */
public class JdbcCompanyDAO implements CompanyDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void insert(Company company) {
        String sql = "INSERT INTO Company (name, age, address, salary) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, company.getName());
            ps.setInt(2, company.getAge());
            ps.setString(3, company.getAddress());
            ps.setInt(4, company.getSalary());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.print("Error");
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public Company findCompanyById(int idCom) {
        return null;
    }
}
