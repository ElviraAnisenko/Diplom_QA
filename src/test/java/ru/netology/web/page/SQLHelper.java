package ru.netology.web.page;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.BaseResultSetHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.*;

public class SQLHelper {
    private static final QueryRunner runner = new QueryRunner();

    public SQLHelper() {
    }

    private static Connection getConn() throws SQLException {
        // return DriverManager.getConnection("jdbc:mysql://185.119.57.126:3306/app", "app", "pass");
        return DriverManager.getConnection(System.getProperty("db.url"), "app", "pass");
    }

    @SneakyThrows
    public static String getStatusFromPayment() {
        var statusSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return runner.query(conn, statusSQL, new ScalarHandler<String>());

    }

    @SneakyThrows
    public static String getStatusFromPaymentCredit() {
        var statusSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return runner.query(conn, statusSQL, new ScalarHandler<String>());

    }

    @SneakyThrows
    public static Long getNumberRowsFromDBTablePayment() {
        var conn = getConn();
        var request = "SELECT COUNT(*) FROM payment_entity";
        return runner.query(conn, request, new ScalarHandler<Long>());

    }

    @SneakyThrows
    public static Long getNumberRowsFromDBTablePaymentCredit() {
        var conn = getConn();
        var request = "SELECT COUNT(*) FROM credit_request_entity";
        return runner.query(conn, request, new ScalarHandler<Long>());

    }


    @SneakyThrows
    public static void cleanDatabase() {
        var conn = getConn();
        runner.execute(conn, "DELETE FROM credit_request_entity");
        runner.execute(conn, "DELETE FROM payment_entity");
        runner.execute(conn, "DELETE FROM order_entity");
    }


}
