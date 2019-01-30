package task;


import java.util.ArrayList;

import entity.Param;

/**
 * @auther fyf
 * @date 2018/12/19 - 22:21
 */
public class Common {
	
    public static int putBuffer1Num = 3;
    public static int moveBuffer2Num = 1;
    public static int moveBuffer3Num = 1;
    public static int getBuffer2Num = 2;
    public static int getBuffer3Num = 2;

    public static int Buffer1Size = 3;
    public static int Buffer2Size = 5;
    public static int Buffer3Size = 4;

    public static int putSpeed = 40;
    public static int moveSpeed = 40;
    public static int getSpeed = 40;
    
    
    public int place = 0;
    public static int BlockedThreadNum = 0;
    public static boolean flag = true;
    public static boolean pause = false;
    
    public static int putInBufferNum=0;
    public static int getOutBufferNum=0;
    
    public static long startTime;
    public static long endTime;
 

    public static ArrayList<Character> buffer1 = new ArrayList<>(); //buffer
    public static ArrayList<Character> buffer2 = new ArrayList<>();
    public static ArrayList<Character> buffer3 = new ArrayList<>();
    public Common(){
    	
    }
    public Common(Param param){
    	
    	Buffer1Size = param.getBufferSize1();
    	Buffer2Size = param.getBufferSize2();
    	Buffer3Size = param.getBufferSize3();
    	
    	putBuffer1Num = param.getPutBuffer1Num();
    	moveBuffer2Num = param.getMoveBuffer2Num();
    	moveBuffer3Num = param.getGetBuffer3Num();
    	getBuffer2Num = param.getGetBuffer2Num();
    	getBuffer3Num = param.getGetBuffer3Num();
    	
    	putSpeed = param.getPutSpeed();
    	moveSpeed = param.getMoveSpeed();
    	getSpeed = param.getGetSpeed();
	}
    public static void setParams(Param param) {
    	startTime = System.currentTimeMillis();
    	Buffer1Size = param.getBufferSize1();
    	Buffer2Size = param.getBufferSize2();
    	Buffer3Size = param.getBufferSize3();
    	
    	putBuffer1Num = param.getPutBuffer1Num();
    	moveBuffer2Num = param.getMoveBuffer2Num();
    	moveBuffer3Num = param.getGetBuffer3Num();
    	getBuffer2Num = param.getGetBuffer2Num();
    	getBuffer3Num = param.getGetBuffer3Num();
   
    	putSpeed = param.getPutSpeed();
    	moveSpeed = param.getMoveSpeed();
    	getSpeed = param.getGetSpeed();
    }
    
    public static char removeRandomChar(ArrayList<Character> charBuffer) {
        char removeChar = charBuffer.remove((int) (Math.random() * charBuffer.size()));
        return removeChar;
    }
    public static void  setCharBuffer(ArrayList<Character> charBuffer, char c) {
            charBuffer.add(c);
    }
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
    
}
