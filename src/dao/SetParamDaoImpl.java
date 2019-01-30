package dao;


import java.util.ArrayList;
import java.util.List;

import entity.BufferData;
import entity.Param;
import entity.Result;
import rowMapper.BufferDataRowMapper;
import rowMapper.ParamRowMapper;
import rowMapper.ResultRowMapper;
import util.JDBCTemplate;

public class SetParamDaoImpl implements SetParamDao{


	private static final String GET_RESULT = "select * from result where rs_id=?";
	private static final String SET_RESULT = "update result set Runtime=?,BufferDataNum=?,putInBufferNum=?,getOutBufferNum=?,AvgBufferNum=? where rs_id=1";
	private static final String SET_PARAM = "update param set buffer1Size=?,buffer2Size=?,buffer3Size=?,putBuffer1Num=?,moveBuffer2Num=?,moveBuffer3Num=?,getBuffer2Num=?,getBuffer3Num=?,putSpeed=?,moveSpeed=?,getSpeed=? where p_id=1";
	private static final String SELECT_PARAM = "select * from param where p_id=?";

	@Override
	public Param selectParamsById(int paramId) {
		JDBCTemplate<Param> jdbcTemplate = new JDBCTemplate<Param>();
	
		Param queryForObject = jdbcTemplate.queryForObject(SELECT_PARAM, new ParamRowMapper(), paramId);
		return queryForObject;
	}

	@Override
	public void saveMessage(BufferData bufferData) {
		JDBCTemplate<BufferData> jdbcTemplate = new JDBCTemplate<BufferData>();
		String sql = "";
		String args = "";
		if(bufferData.getType()==1) {
			sql ="INSERT into buffer1 (Message,Data,ContentNum,FreeSpaceNum) values(?,?,?,?)";
		
		}else if(bufferData.getType()==2) {
			sql = "insert into buffer2 (Message,Data,ContentNum,FreeSpaceNum) values(?,?,?,?)";
		}else if(bufferData.getType()==3) {
			sql = "insert into buffer3 (Message,Data,ContentNum,FreeSpaceNum) values(?,?,?,?)";
		}
		jdbcTemplate.update(sql, bufferData.getMessage(),bufferData.getBufferContent(),bufferData.getBufferContentNum(),bufferData.getFreeSpaceNum());
	}

	@Override
	public ArrayList<BufferData> queryBufferData(int type) {
		JDBCTemplate<BufferData> jdbcTemplate = new JDBCTemplate<BufferData>();
		String sql = "";
		if(type==1) {
			sql = "select * from buffer1";
		}else if(type==2) {
			sql = "select * from buffer2";
		}else if(type==3) {
			sql = "select * from buffer3";
		}
		ArrayList<BufferData> list = (ArrayList)jdbcTemplate.queryAll(sql, new BufferDataRowMapper());
		return list;
	}

	@Override
	public void setParam(Param param) {
		JDBCTemplate<Param> jdbcTemplate = new JDBCTemplate<Param>();
		jdbcTemplate.update(SET_PARAM, param.getBufferSize1(),param.getBufferSize2(),param.getBufferSize3(),param.getPutBuffer1Num(),param.getMoveBuffer2Num()
				,param.getMoveBuffer3Num(),param.getGetBuffer2Num(),param.getGetBuffer3Num(),param.getPutSpeed(),param.getMoveSpeed(),param.getGetSpeed());
		
	}

	@Override
	public void setResult(Result result) {
		JDBCTemplate<Result> jdbcTemplate = new JDBCTemplate<Result>();
		boolean update = jdbcTemplate.update(SET_RESULT, result.getRuntime(),result.getBufferDataNum(),result.getPutInBufferNum(),
				result.getGetOutBufferNum(),result.getAvgBufferNum());
		
	}

	@Override
	public ArrayList<Result> getResult(int id) {
		JDBCTemplate<Result> jdbcTemplate = new JDBCTemplate<Result>();
		jdbcTemplate.queryForObject(GET_RESULT, new ResultRowMapper(), id);
		return null;
	}
	

}
