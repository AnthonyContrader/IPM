package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Packet;

public class PacketDAO {

	private final String QUERY_ALL = "SELECT * FROM packet";
	private final String QUERY_CREATE = "INSERT INTO packet (name, description) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM packet WHERE id_pack=?";
	private final String QUERY_UPDATE = "UPDATE packet SET name=?, description=? WHERE id_pack=?";
	private final String QUERY_DELETE = "DELETE FROM packet WHERE id_pack=?";

	public PacketDAO() {

	}

	public List<Packet> getAll() {
		List<Packet> packetsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			
			Packet packet;
			
			while (resultSet.next()) {
				packet = new Packet (
							resultSet.getString("name"),
							resultSet.getString("description")
						);
				
				packet.setId_pack( resultSet.getInt("id_pack") );
				
				packetsList.add(packet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return packetsList;
	}

	public boolean insert(Packet packetToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, packetToInsert.getName());
			preparedStatement.setString(2, packetToInsert.getDescription());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Packet read(int packetToRead) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, packetToRead);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			Packet packet = new Packet(
					resultSet.getString("name"),
					resultSet.getString("description")
					);
			
			packet.setId_pack( resultSet.getInt("id_pack") );
			
			return packet;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Packet packetToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		if (packetToUpdate.getId_pack() == 0)
			return false;

		Packet packetRead = read(packetToUpdate.getId_pack());
		if (!packetRead.equals(packetToUpdate)) {
			try {
				if (packetToUpdate.getName() == null || packetToUpdate.getName().isEmpty()) {
					packetToUpdate.setName(packetRead.getName());
				}

				if (packetToUpdate.getDescription() == null || packetToUpdate.getDescription().isEmpty()) {
					packetToUpdate.setDescription(packetRead.getDescription());
				}

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, packetToUpdate.getName());
				preparedStatement.setString(2, packetToUpdate.getDescription());
				preparedStatement.setInt(3, packetToUpdate.getId_pack());
				
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int packetToDeleteId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, packetToDeleteId);
			
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		
		return false;
	}


}
