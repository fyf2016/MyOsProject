package rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Result;

public class ResultRowMapper implements RowMapper<Result>{

	@Override
	public Result rowMap(ResultSet rs) {
		Result result = new Result();
		try {
			result.setRuntime(rs.getString(1));
			result.setBufferDataNum(rs.getInt(2));
			result.setPutInBufferNum(rs.getInt(3));
			result.setGetOutBufferNum(rs.getInt(4));
			result.setAvgBufferNum(rs.getInt(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
