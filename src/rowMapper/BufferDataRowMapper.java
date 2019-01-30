package rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.BufferData;

public class BufferDataRowMapper implements RowMapper<BufferData> {

	@Override
	public BufferData rowMap(ResultSet rs) {
		BufferData bufferData = new BufferData();
		try {
			bufferData.setId(rs.getInt(1));
			bufferData.setMessage(rs.getString(2));
			bufferData.setBufferContent(rs.getString(3));
			bufferData.setBufferContentNum(rs.getInt(4));
			bufferData.setFreeSpaceNum(rs.getInt(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bufferData;
	}

}
