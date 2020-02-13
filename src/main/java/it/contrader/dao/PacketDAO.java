package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Packet;

public class PacketDAO implements DAO<Packet> {
	private final String QUERY_ALL = "SELECT * FROM packet";
	private final String QUERY_CREATE = "INSERT INTO packet (name, description, oskey) VALUES (?,?, ?)";
	private final String QUERY_READ = "SELECT * FROM packet WHERE id_pack=?";
	private final String QUERY_UPDATE = "UPDATE packet SET name=?, description=?, oskey=? WHERE id_pack=?";
	private final String QUERY_DELETE = "DELETE FROM packet WHERE id_pack=?";
	private final String QUERY_FIND = "SELECT * FROM packet WHERE name=?";
	private final String QUERY_OS = "SELECT packet.*, ostype.name, ostype.comm FROM packet JOIN ostype ON packet.oskey = ostype.id AND packet.id_pack = ?";
	
	// Empty Constructor
	public PacketDAO() {}
	
	public boolean insert(Packet packetToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, packetToInsert.getName() );
			preparedStatement.setString(2, packetToInsert.getDescription() );
			preparedStatement.setString(3, packetToInsert.getOsKey() );
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Packet read(int packetId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, packetId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			Packet readPacket = new Packet (
					resultSet.getString("name"),
					resultSet.getString("description"),
					resultSet.getString("oskey")
					);
			
			readPacket.setId_pack(
					resultSet.getInt("id_pack")
					);
			
			return readPacket;
			
		} catch(SQLException e) {
			return null;
		}
	}
	
	public boolean update(Packet packetToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if (packetToUpdate.getId_pack() == 0)
			return false;
		
		Packet packetRead = read( packetToUpdate.getId_pack() );
		
		if ( !packetRead.equals(packetToUpdate) ) {
			try {
				if ( packetToUpdate.getName() == null || packetToUpdate.getName().equals(""))
					packetToUpdate.setName( packetRead.getName() );
				
				if ( packetToUpdate.getDescription() == null || packetToUpdate.getDescription().contentEquals(""))
					packetToUpdate.setDescription( packetRead.getDescription() );
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, packetToUpdate.getName() );
				preparedStatement.setString(2, packetToUpdate.getDescription() );
				preparedStatement.setString(3, packetToUpdate.getOsKey() );
				preparedStatement.setInt(4, packetToUpdate.getId_pack() );
				
				int updateResult = preparedStatement.executeUpdate();
				
				if (updateResult > 0)
					return true;
				else
					return false;
				
			} catch (SQLException e) {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean delete(int packetIdToDelete) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, packetIdToDelete);
			int deleteResult = preparedStatement.executeUpdate();
			
			if (deleteResult != 0)
				return true;
			
		} catch (SQLException e) {
			return false;
		}
		
		return false;
	}
	
	public List<Packet> getAll() {
		Connection connection = ConnectionSingleton.getInstance();
		List<Packet> packetsList = new ArrayList<Packet>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			
			Packet packet;
			
			while ( resultSet.next() ) {
				int packId = resultSet.getInt("id_pack");
				
				packet = new Packet (
						resultSet.getString("name"),
						resultSet.getString("description"),
						resultSet.getString("oskey")
						);
				
				packet.setId_pack(packId);
				
				packetsList.add(packet);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return packetsList;
	}
	
	public Packet findByName(String packetToFind) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND);
			preparedStatement.setString(1, packetToFind);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while ( resultSet.next() )
				return new Packet(
					resultSet.getInt("id_pack"),
					resultSet.getString("name"),
					resultSet.getString("description"),
					resultSet.getString("oskey")
					);
			
			
		} catch (SQLException e) {
		}
		
		return null;
	}
}
