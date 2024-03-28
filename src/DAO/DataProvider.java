package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProvider {

    private static DataProvider instance = null;

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=CHNONGSAN;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    private Connection connection;

    // Phương thức khởi tạo private để ngăn chặn việc tạo instance từ bên ngoài.
    private DataProvider() {
        try {
            
            // Kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức getInstance để lấy thể hiện duy nhất của lớp DataProvider
    public static synchronized DataProvider getInstance() {
        if (instance == null) {
            instance = new DataProvider();
        }
        return instance;
    }

    // Thực hiện truy vấn SQL thông thường
    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Gọi stored procedure không trả về kết quả
    public void callStoredProcedure(String procedureName) {
        try {
            CallableStatement callableStatement = connection.prepareCall("{call " + procedureName + "}");
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Gọi stored procedure với nhiều tham số đầu vào
    public void callStoredProcedureWithParameters(String procedureName, Object... parameters) {
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("{call ").append(procedureName).append("(");
            for (int i = 0; i < parameters.length; i++) {
                if (i > 0) {
                    sqlBuilder.append(", ");
                }
                sqlBuilder.append("?");
            }
            sqlBuilder.append(")}");

            CallableStatement callableStatement = connection.prepareCall(sqlBuilder.toString());
            for (int i = 0; i < parameters.length; i++) {
                callableStatement.setObject(i + 1, parameters[i]);
            }

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
