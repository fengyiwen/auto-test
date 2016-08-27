package com.auto.data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by andy on 15/11/24.
 */
public class DataImportor {

    private final static Pattern pattern = Pattern.compile("\\d$");

    public static final String[] DEFAULT_TABLES = new String[]{
            "city"
    };

    /**
     * @param url
     * @param user
     * @param password
     * @return
     */
    public static Connection getDataSource(String url, String user, String password) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public static void main(String[] args) throws Exception {
        Connection target = getDataSource("jdbc:mysql://localhost:3307/atzuchedb", "root", "123456");
        Connection source = getDataSource("jdbc:mysql://atzuchedbsalvecrm.mysql.rds.aliyuncs.com/atzuchedb", "atdb_admin_2015", "_UURCnjms_qGQ0xhouIHhDE_qCHR-015");
        List<String> tableNames = getTableNames(source);
        for(String tableName:tableNames){
            int count = getRowCount(source,tableName);
            if(count>100){
                System.out.println(tableName);
            }
        }
//        transDataToSameTable(source, target, "city");
    }

    public static List<String> getTableNames(Connection con) throws SQLException {
        List<String> tableNames = new ArrayList<String>();
        DatabaseMetaData dbmd = con.getMetaData();
        ResultSet rs = dbmd.getTables(null, null, null, new String[]{"table"});
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if (tableName.contains("bak")) {
//                System.out.println("ignore table is : "+tableName);
            } else if (pattern.matcher(tableName).find()) {
//                System.out.println("match ending with digit table is : "+tableName);
            } else {

                tableNames.add(tableName);
            }
        }
        return tableNames;
    }

    /**
     *
     * @param source
     * @param target
     * @param table
     * @throws SQLException
     */
    public static void transDataToSameTable(Connection source, Connection target, String table) throws SQLException {
        int count = getRowCount(source, table);
        if (count < 30) {
            System.out.println("count<30,and insert data");
            String getDataSql = "select * from " + table;
            Statement sst = source.createStatement();
            ResultSet srs = sst.executeQuery(getDataSql);
            Statement tst = target.createStatement();
            ResultSet trs = tst.executeQuery("select * from " + table + " limit 1");
            Map<String,String> sourceColumnMap = getColumnNames(srs);
            Map<String,String> targetColumnMap = getColumnNames(trs);

            List<String> targetColumns = new ArrayList<String>(targetColumnMap.keySet());

            String sql = buildInsertSql(table, targetColumns);
            System.out.println("sql is "+sql);
            PreparedStatement pst = target.prepareStatement(sql);
            while(srs.next()) {
                for (int i = 0; i < targetColumns.size(); i++) {
                    if(sourceColumnMap.containsKey(targetColumns.get(i))) {
                        pst.setString(i + 1, srs.getString(targetColumns.get(i)));
                    }else{
                        String type = targetColumnMap.get(targetColumns.get(i));
                        if(type.equals("TINYINT")||type.equals("INT")){
                            pst.setInt(i + 1, 0);
                        }else if(type.equals("TIMESTAMP")){
                            Date date = new Date();
                            pst.setTimestamp(i + 1, new Timestamp(date.getTime()));
                        }
                        else {
                            pst.setString(i + 1, "");
                        }
                    }
                }
                pst.execute();
            }
            pst.close();
            sst.close();
            tst.close();
        }
    }

    /**
     *
     * @param table
     * @param columns
     * @return
     */
    public static String buildInsertSql(String table, List<String> columns) {
        StringBuilder builder = new StringBuilder("insert into ").append(table).append("(");
        int columnCount = columns.size();
        for (int i = 0; i < columnCount; i++) {
            builder.append(columns.get(i));
            if(i<columnCount-1) {
                builder.append(",");
            }
        }
        builder.append(") values(");
        for(int i=0;i<columnCount;i++){
            builder.append("?");
            if(i<columnCount-1){
                builder.append(",");
            }
        }
        builder.append(")");
        return builder.toString();
    }

    /**
     *
     * @param source
     * @param table
     * @return
     * @throws SQLException
     */
    public static int getRowCount(Connection source, String table) throws SQLException {
        String sql = "select count(*) from " + table;
        Statement st = source.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }



    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Map<String,String> getColumnNames(ResultSet rs) throws SQLException {
        Map<String,String> columnMap = new HashMap<String, String>();
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        String[] columnArrays = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnMap.put(resultSetMetaData.getColumnLabel(i),resultSetMetaData.getColumnTypeName(i));
        }
        return columnMap;
    }


}
