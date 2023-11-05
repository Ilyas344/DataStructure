package org.example.DAO;


import org.example.DTO.StudentAllExcellent;
import org.example.DTO.StudentAverageScoreByFamily;
import org.example.POJO.ItemRating;
import org.example.POJO.Student;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void addStudent(Student student) {
        TransactionScript.getInstance().addStudent(student);
    }

    /*
- средние оценки по предметам в старших классах (10 и 11)

- список всех отличников старше 14 лет

- среднюю оценку ученика по указанной фамилии (если найдено несколько учеников – нужно вывести список в формате ФИО, учебная группа, средняя оценка.
        */
    @Override
    public double getAverageRating(int group) {
        return TransactionScript.getInstance().getAverageRating(group);
    }

    @Override
    public List<StudentAllExcellent getTopStudents(int age) {
        return TransactionScript.getInstance().getExcellentStudentsOver14();
    }

    @Override
    public List<StudentAverageScoreByFamily> getAverageScore(String family) {
        return TransactionScript.getInstance().getAverageGradeByFamily(family);
    }


    public static final class TransactionScript {
        private final static String URL = "jdbc:postgresql://localhost:5432/students_rating";
        private final static String LOGIN = "postgres";
        private final static String PASS = "postgres";
        private final Connection connection;

        public TransactionScript() {
            try {
                this.connection = DriverManager.getConnection(URL, LOGIN, PASS);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        private static final TransactionScript INSTANCE = new TransactionScript();

        public static TransactionScript getInstance() {
            return INSTANCE;
        }

        public void addStudent(Student student) {
            try {
                connection.setAutoCommit(false);

                PreparedStatement addStudent = connection.prepareStatement(
                        "INSERT INTO students (family, name, age, group_number, total_score) VALUES (?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                addStudent.setString(1, student.getFamily());
                addStudent.setString(2, student.getName());
                addStudent.setInt(3, student.getAge());
                addStudent.setInt(4, student.getGroup());
                addStudent.setInt(5, student.getTotalScore());

                addStudent.execute();

                ResultSet resultSet = addStudent.getGeneratedKeys();

                if (resultSet.next()) {
                    student.setId(resultSet.getInt(1));
                } else {
                    throw new SQLException("Could not get generated student ID");
                }
                System.out.println(student);
                PreparedStatement addRating = connection.prepareStatement(
                        "INSERT INTO ITEM_RATINGS (student_id, item, rating) VALUES (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);

                for (ItemRating itemRating : student.getItemRatings()) {
                    addRating.setInt(1, student.getId());
                    addRating.setString(2, itemRating.getItemId());
                    addRating.setInt(3, itemRating.getRating());

                    addRating.execute();
                }

                connection.commit();
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                throw new RuntimeException(e);
            }

        }

        public double getAverageRating(int group) {
            String sql = "SELECT item, AVG(rating) AS average_rating " +
                    "FROM item_ratings " +
                    "WHERE  student_id IN ( " +
                    "    SELECT id FROM students " +
                    "    WHERE group_number = ? " +
                    "  )" +
                    "GROUP BY item;";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, group);
                ResultSet resultSet = preparedStatement.executeQuery();

                double averageGrades = 0;
                while (resultSet.next()) {
                    averageGrades += resultSet.getDouble("average_rating");
                }

                return averageGrades;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        public List<StudentAllExcellent> getExcellentStudentsOver14() {
            String sql = "SELECT * FROM students " +
                    "WHERE total_score >29  AND age > 14;";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                List<StudentAllExcellent> excellentStudents = new ArrayList<>();
                while (resultSet.next()) {
                    StudentAllExcellent studentDTO = new StudentAllExcellent();


                    studentDTO.setFamily(resultSet.getString("family"));
                    studentDTO.setAge(resultSet.getInt("age"));
                    studentDTO.setName(resultSet.getString("name"));

                    studentDTO.setTotalScore(resultSet.getInt("total_score"));

                    excellentStudents.add(studentDTO);
                }
                return excellentStudents;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public List<StudentAverageScoreByFamily> getAverageGradeByFamily(String family) {
            String sql = "SELECT students.id, family, name, age, group_number, total_score, " +
                    "AVG(rating) AS average_grade " +
                    "FROM students " +
                    "JOIN item_ratings ON students.id = item_ratings.student_id " +
                    "WHERE family = ? " +
                    "GROUP BY students.id;";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, family);
                ResultSet resultSet = preparedStatement.executeQuery();

                List<StudentAverageScoreByFamily> students = new ArrayList<>();
                while (resultSet.next()) {

                    StudentAverageScoreByFamily studentDTO = new StudentAverageScoreByFamily();

                    studentDTO.setFamily(resultSet.getString("family"));
                    studentDTO.setName(resultSet.getString("name"));
                    studentDTO.setGroup(resultSet.getInt("group_number"));
                    students.add(studentDTO);
                }

                return students;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public List<ItemRating> getItemRatingDTO(int id) {
        String sql = "SELECT * FROM ITEM_RATINGS WHERE student_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<ItemRating> itemRating = new ArrayList<>();
            while (resultSet.next()) {
                ItemRating itemRatingDTO = new ItemRating();
                itemRatingDTO.setId(resultSet.getInt("id"));
                itemRatingDTO.setItemId(resultSet.getString("item"));
                itemRatingDTO.setRating(resultSet.getInt("rating"));

                itemRating.add(itemRatingDTO);
            }

            return itemRating;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
}



