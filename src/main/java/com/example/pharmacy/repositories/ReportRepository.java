package com.example.pharmacy.repositories;


import com.example.pharmacy.entities.Medication;
import com.example.pharmacy.entities.Report;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;

@Repository
public class ReportRepository {


    protected final JdbcOperations jdbcOperations;

    public ReportRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private static final String selectQuery = "SELECT \"id\", \"medication_id\" , \"user_id\", \"status\", \"count\", \"total_cost\", \"date\"" +
            "FROM \"report\" " +
            "ORDER BY \"id\"";

    private static final String insertQuery = "INSERT INTO \"report\"(\"medication_id\" , \"user_id\", \"status\", \"count\", \"total_cost\", \"date\") " +
            "VALUES (?, ?, ?, ?, ?, ?) " +
            "RETURNING \"id\" ";


    public Report[] select() {
        ArrayList<Report> values = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcOperations.queryForRowSet(selectQuery);
        while (sqlRowSet.next()) {
            values.add(new Report(
                    sqlRowSet.getInt(1),
                    sqlRowSet.getInt(2),
                    sqlRowSet.getInt(3),
                    sqlRowSet.getBoolean(4),
                    sqlRowSet.getInt(5),
                    sqlRowSet.getInt(6),
                    sqlRowSet.getString(7)));
        }
        Report[] result = new Report[values.size()];
        result = values.toArray(result);
        return result;
    }

    public void insert(Report entity) {
        Object[] params = new Object[]{entity.getMedication_id(), entity.getUser_id(), entity.getStatus(), entity.getCount(), entity.getTotal_cost(), entity.getDate()};
        int[] types = new int[]{Types.INTEGER, Types.INTEGER, Types.BOOLEAN, Types.INTEGER, Types.INTEGER,Types.VARCHAR,};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(insertQuery, params, types);
    }


}
