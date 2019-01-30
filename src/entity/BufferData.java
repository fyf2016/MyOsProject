package entity;

public class BufferData {
	private int id;
	private int type;
	private String message;
	private String bufferContent;
	private int bufferContentNum;
	private int freeSpaceNum;
	private int blockedNum;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getBufferContent() {
		return bufferContent;
	}
	public void setBufferContent(String bufferContent) {
		this.bufferContent = bufferContent;
	}
	public int getBufferContentNum() {
		return bufferContentNum;
	}
	public void setBufferContentNum(int bufferContentNum) {
		this.bufferContentNum = bufferContentNum;
	}
	public int getFreeSpaceNum() {
		return freeSpaceNum;
	}
	public void setFreeSpaceNum(int freeSpaceNum) {
		this.freeSpaceNum = freeSpaceNum;
	}
	public int getBlockedNum() {
		return blockedNum;
	}
	public void setBlockedNum(int blockedNum) {
		this.blockedNum = blockedNum;
	}
	
	
}
