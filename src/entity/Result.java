package entity;

public class Result {
	private int id;
	private String runtime;
	private int bufferDataNum;
	private int putInBufferNum;
	private int getOutBufferNum;
	private int avgBufferNum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public int getBufferDataNum() {
		return bufferDataNum;
	}
	public void setBufferDataNum(int bufferDataNum) {
		this.bufferDataNum = bufferDataNum;
	}
	public int getPutInBufferNum() {
		return putInBufferNum;
	}
	public void setPutInBufferNum(int putInBufferNum) {
		this.putInBufferNum = putInBufferNum;
	}
	public int getGetOutBufferNum() {
		return getOutBufferNum;
	}
	public void setGetOutBufferNum(int getOutBufferNum) {
		this.getOutBufferNum = getOutBufferNum;
	}
	public int getAvgBufferNum() {
		return avgBufferNum;
	}
	public void setAvgBufferNum(int avgBufferNum) {
		this.avgBufferNum = avgBufferNum;
	}
	
	
}
