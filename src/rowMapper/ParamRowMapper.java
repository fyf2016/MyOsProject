package rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Param;

public class ParamRowMapper implements RowMapper<Param> {

	@Override
	public Param rowMap(ResultSet rs) {
		Param param = new Param();
		try {
			param.setId(rs.getInt(1));
			param.setBufferSize1(rs.getInt(2));
			param.setBufferSize2(rs.getInt(3));
			param.setBufferSize3(rs.getInt(4));
			param.setPutBuffer1Num(rs.getInt(5));
			param.setMoveBuffer2Num(rs.getInt(6));
			param.setMoveBuffer3Num(rs.getInt(7));
			param.setGetBuffer2Num(rs.getInt(8));
			param.setGetBuffer3Num(rs.getInt(9));
			param.setPutSpeed(rs.getInt(10));
			param.setMoveSpeed(rs.getInt(11));
			param.setGetSpeed(rs.getInt(12));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return param;
	}

}
