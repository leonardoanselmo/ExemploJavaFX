package model.sqlite;

import model.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoSQLite extends SQLiteBase {

    public VeiculoSQLite(){

        open();

        try {
            PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Veiculos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "marca TEXT,"+
                    "modelo TEXT,"+
                    "hp INTEGER);");

            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void create(Veiculo v){

        open();

        try {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Veiculos VALUES(?,?,?,?);" );

            stm.setString(2,v.getMarca());
            stm.setString(3,v.getModelo());
            stm.setInt(4,v.getHp());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public List<Veiculo> all(){
        ArrayList<Veiculo> result = new ArrayList<>();

        open();

        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Veiculos ORDER BY id ASC;" );

            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Veiculo v = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("hp"));

                result.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return result;
    }

    public void update(Veiculo v){

        open();

        try {
            PreparedStatement stm = conn.prepareStatement("UPDATE Veiculos SET " +
                    "marca = ?, modelo = ?, hp = ? WHERE id = ?;");

            stm.setString(1,v.getMarca());
            stm.setString(2,v.getModelo());
            stm.setInt(3,v.getHp());
            stm.setInt(4,v.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void delete(Veiculo v){

        open();

        try {
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Veiculos WHERE id = ?;");

            stm.setInt(1,v.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public Veiculo find(int pk){

        Veiculo result = null;

        open();

        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Veiculos WHERE id = ?;" );

            stm.setInt(1,pk);

            ResultSet rs = stm.executeQuery();

            if (rs.next()){
                Veiculo v = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("hp"));

                result = v;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return result;

    }


}
