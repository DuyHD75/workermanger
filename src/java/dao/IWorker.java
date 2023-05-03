
package dao;

import entity.Worker;
import java.sql.SQLException;
import java.util.List;



public interface IWorker {

    public void insertWorker(Worker worker) throws SQLException;

    public boolean updateWorker(Worker worker) throws SQLException;

    public boolean deleteWorker(int id) throws SQLException;

    public List<Worker> getAllWorkers();

    public Worker getWorkerById(int id);

    public List<Worker> sortedWorker() throws SQLException;
}
