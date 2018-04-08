package ru.oblap.todolist.data;
import ru.oblap.todolist.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO extends DAO{

    public List<Task> getAll() {
        Connection connection = openConnection();
        String sql = "SELECT * FROM task";
        List<Task> tasks = new ArrayList<>();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setDescription(rs.getString("description"));
                task.setDone(rs.getBoolean("done"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return tasks;
    }

    public boolean updateDone(Task task) {
        boolean result = false;
        Connection connection = openConnection();
        String sql = "UPDATE task SET done = TRUE WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,task.getId());
            result = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return result;
    }

    public boolean create(Task task) {
        boolean result = false;
        Connection connection = openConnection();
        String sql = "INSERT INTO task(description, done) value (?, ?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, task.getDescription());
            stmt.setBoolean(2, task.isDone());
            result = stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Ошибка : " + e.getMessage());
        }
        return result;
    }

}
