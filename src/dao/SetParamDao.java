package dao;

import java.util.ArrayList;
import java.util.List;

import entity.BufferData;
import entity.Param;
import entity.Result;

public interface SetParamDao {
	public abstract Param selectParamsById(int paramId);
	public abstract void saveMessage(BufferData bufferData);
	public abstract ArrayList<BufferData> queryBufferData(int type);
	public abstract void setParam(Param param);
	public abstract void setResult(Result result);
	public abstract ArrayList<Result> getResult(int id);
}