package org.example.database;

import org.example.ADMIN;
import java.sql.*;
import java.util.List;
import java.util.Objects;

public class SqlExecutor {
    private final Connection connection;

    public SqlExecutor(Connection connection){
        this.connection = connection;
    }

    // тип индекс значение
    public Long insert(String sql, List<SqlData> sqlData) {
        try (var preparedStm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            sqlData.forEach(data -> {
                try {
                    switch (data.type()){
                        case STRING: {
                            if (data.value() == null){
                                preparedStm.setNull(data.index(),JDBCType.VARCHAR.getVendorTypeNumber());
                            }else{
                                preparedStm.setString(data.index(), (String) data.value());
                            }
                            break;
                        }
                        case INTEGER: {
                            if (data.value() == null) {
                                preparedStm.setNull(data.index(), JDBCType.INTEGER.getVendorTypeNumber());
                            } else {
                                preparedStm.setInt(data.index(), (Integer) data.value());
                            }
                            break;
                        }
                        case BOOLEAN: {
                            if (data.value() == null){
                                preparedStm.setNull(data.index(),JDBCType.BOOLEAN.getVendorTypeNumber());
                            }else{
                                preparedStm.setBoolean(data.index(),(Boolean)data.value());
                            }
                            break;
                        }
                    }
                }catch (SQLException e){
                    throw new SqlRuntimeException(e);
                }

            });
            preparedStm.executeUpdate();
            var keys = preparedStm.getGeneratedKeys();
            keys.next();
            return keys.getLong(1);
        }catch (SQLException e){
            throw new SqlRuntimeException(e);
        }
    }





//    public Long insert(String sql, ADMIN admin) throws SQLException {
//        try (var preparedStm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            preparedStm.setString(1, admin.getName());
//            preparedStm.executeUpdate();
//            var keys = preparedStm.getGeneratedKeys();
//            keys.next();
//            return keys.getLong(1);
//        }
//    }
}
// insert and update and delete