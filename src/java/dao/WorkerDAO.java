package dao;

import static dao.ConnectionDB.getConnection;
import entity.Worker;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author This PC
 */
public class WorkerDAO implements IWorker {

    private static final String SELECT_ALL_WORKER = "SELECT * FROM workers";
    private static final String INSERT_WORKER_SQL = "INSERT INTO workers values(?, ? , ?);";
    private static final String SELECT_WORKER_BY_ID = "SELECT * FROM workers WHERE id = ?;";

    private static final String DELETE_WORKER_SQL = "DELETE FROM workers where id = ?;";
    private static final String UPDATE_WORKER_SQL = "UPDATE workers SET  name = ? , address = ? ,email = ? WHERE id = ?;";

    private static final String SORT_WORKER_BY_NAME = "SELECT * FROM workers ORDER BY name desc;";

    @Override
    public void insertWorker(Worker worker) throws SQLException {
        try (Connection con = getConnection(); PreparedStatement pstm = con.prepareStatement(INSERT_WORKER_SQL);) {
            
            pstm.setString(1, worker.getName());
            pstm.setString(2, worker.getAddress());
            pstm.setString(3, worker.getEmail());
            
            System.out.println(pstm);
            pstm.executeUpdate();
        }
    }

    @Override
    public boolean updateWorker(Worker worker) throws SQLException {
        boolean isUpdated = false;

        try (Connection con = getConnection(); PreparedStatement pstm = con.prepareStatement(UPDATE_WORKER_SQL);) {
            pstm.setString(1, worker.getName());
            pstm.setString(2, worker.getAddress());
            pstm.setString(3, worker.getEmail());

            pstm.setInt(4, worker.getId());

            isUpdated = pstm.executeUpdate() > 0;
        }
        return isUpdated;

    }

    @Override
    public boolean deleteWorker(int id) throws SQLException {
        boolean isDeleted;
        try (
                Connection con = getConnection(); PreparedStatement pstm = con.prepareStatement(DELETE_WORKER_SQL);) {
            pstm.setInt(1, id);
            isDeleted = pstm.executeUpdate() > 0;
        }
        return isDeleted;
    }

    @Override
    public List<Worker> getAllWorkers() {
        List<Worker> workers = new ArrayList<>();
        try (
                Connection con = getConnection(); PreparedStatement pstm = con.prepareStatement(SELECT_ALL_WORKER);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");

                workers.add(new Worker(id, name, address, email));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workers;
    }

    @Override
    public Worker getWorkerById(int id) {
        Worker worker = null;

        try (
                Connection con = getConnection(); PreparedStatement pstm = con.prepareStatement(SELECT_WORKER_BY_ID);) {

            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                worker = new Worker(id, name, address, email);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return worker;
    }

    @Override
    public List<Worker> sortedWorker() throws SQLException {
        List<Worker> sortedList = new ArrayList<>();

        try (
                Connection con = getConnection(); PreparedStatement pstm = con.prepareStatement(SORT_WORKER_BY_NAME);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                sortedList.add(new Worker(id, name, address, email));
            }
        }
        return sortedList;
    }

}