package com.example.pharmacy.repositories;

import com.example.pharmacy.entities.Medication;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;

@Repository
public class MedicationRepository {

    protected final JdbcOperations jdbcOperations;

    public MedicationRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private static final String selectQuery = "SELECT \"id\", \"name\" , \"price\", \"count\", \"main_activity_ingredient\", \"code_product\", \"type_id\"" +
            "FROM \"medication\" " +
            "ORDER BY \"id\"";

    private static final String selectByIdQuery = "SELECT \"id\", \"name\" , \"price\", \"count\", \"main_activity_ingredient\", \"code_product\", \"type_id\"" +
            "FROM \"medication\" " +
            "WHERE \"id\" = ?";

    private static final String updateQuery = "UPDATE \"medication\" " +
            "SET \"count\" = ? " +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\"";

    public Medication[] select() {
        ArrayList<Medication> values = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcOperations.queryForRowSet(selectQuery);
        while (sqlRowSet.next()) {
            values.add(new Medication(
                    sqlRowSet.getInt(1),
                    sqlRowSet.getString(2),
                    sqlRowSet.getInt(3),
                    sqlRowSet.getInt(4),
                    sqlRowSet.getString(5),
                    sqlRowSet.getString(6),
                    sqlRowSet.getString(7)));
        }
        Medication[] result = new Medication[values.size()];
        result = values.toArray(result);
        return result;
    }

    public Medication select(Integer id) {
        Object[] params = new Object[]{id};
        int[] types = new int[]{Types.INTEGER};
        SqlRowSet sqlrowSet = jdbcOperations.queryForRowSet(selectByIdQuery, params, types);
        if (!sqlrowSet.next()) {
            return null;
        }
        return new Medication(
                sqlrowSet.getInt(1),
                sqlrowSet.getString(2),
                sqlrowSet.getInt(3),
                sqlrowSet.getInt(4),
                sqlrowSet.getString(5),
                sqlrowSet.getString(6),
                sqlrowSet.getString(7));
    }

    public void update(Integer id, Integer count) {
        Object[] params = new Object[] {count, id };
        int[] types = new int[] {Types.INTEGER, Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(updateQuery, params, types);
    }
}
