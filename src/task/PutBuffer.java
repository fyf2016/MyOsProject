package task;

import dao.SetParamDao;
import dao.SetParamDaoImpl;
import entity.BufferData;
import task.Common;
import util.RandomChar;



/**
 * @auther fyf
 * @date 2018/12/17 - 8:21
 */
public class PutBuffer implements Runnable {

    private boolean flag = true;
    private Common common;
    public PutBuffer() {
    
    }
    public PutBuffer(Common common) {
   
        this.common = common;
    }

    @Override
    public void run() {

            while (Common.flag){
                synchronized (Common.buffer1) {
                    while (Common.buffer1.size()==Common.Buffer1Size) {
                        try {
                        	
                        	Common.BlockedThreadNum++;
                            Common.buffer1.wait();
                            Common.BlockedThreadNum--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    char randomChar = RandomChar.getRandomChar();
                    System.out.println(randomChar);
                    Common.buffer1.add(randomChar);
                    Common.putInBufferNum++;
                    BufferData bufferData = new BufferData();
                    SetParamDao setParamDao = new SetParamDaoImpl();
                    
                    bufferData.setType(1);
                    bufferData.setBufferContent(Common.buffer1.toString().replace("[", "").replace("]", ""));
                    bufferData.setBufferContentNum(Common.buffer1.size());
                    bufferData.setFreeSpaceNum(Common.Buffer1Size-Common.buffer1.size());
                    bufferData.setMessage("Put" + Thread.currentThread().getId() + "放入" + randomChar);
            
                    setParamDao.saveMessage(bufferData);
                    
                    try {
                        Thread.sleep((long) (Math.random() * 100 * (50-Common.putSpeed)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Common.buffer1.notify();
                }
                
                while (Common.pause) {
                	try {
    					Thread.sleep(10);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                }
                
    				

            }
    }
}
