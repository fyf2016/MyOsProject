package task;

import task.Common;

import java.lang.invoke.MutableCallSite;

import dao.SetParamDao;
import dao.SetParamDaoImpl;
import entity.BufferData;

/**
 * @auther fyf
 * @date 2018/12/18 - 14:39
 */
public class MoveBuffer implements Runnable{
    
    private boolean flag = true;
    private Common common;
    private char c;
    public MoveBuffer() {

    }
    public MoveBuffer(Common common) {
       
        this.common = common;
    }
    @Override
    public void run() {

            while (Common.flag) {
            
                synchronized (common.buffer1) {
                    while (Common.buffer1.size() == 0) {
                        try {
                        	
                        	Common.BlockedThreadNum++;
                            Common.buffer1.wait();
                            Common.BlockedThreadNum--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    c = Common.buffer1.get(0);
                    Common.buffer1.remove(0);
                    
                    try {
                    	Thread.sleep((long) (Math.random() * 100 * (50-Common.moveSpeed)));
                        Common.buffer1.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    
                    if(common.place==2) {
                    	synchronized (Common.buffer2) {
                            while (Common.buffer2.size() == Common.Buffer2Size) {
                                try {
                                	Common.BlockedThreadNum++;
                                    Common.buffer2.wait();
                                    Common.BlockedThreadNum--;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            
                            BufferData bufferData = new BufferData();
                            SetParamDao setParamDao = new SetParamDaoImpl();
                            
                            bufferData.setType(1);
                            bufferData.setBufferContent(Common.buffer1.toString().replace("[", "").replace("]", ""));
                            bufferData.setBufferContentNum(Common.buffer1.size());
                            bufferData.setFreeSpaceNum(Common.Buffer1Size-Common.buffer1.size());
                           
                            bufferData.setMessage("Move" + Thread.currentThread().getId() + "拿走了" + c);
                     
                            setParamDao.saveMessage(bufferData);
                            Common.getOutBufferNum++;
                            
                            Common.buffer2.add(c);
                            Common.putInBufferNum++;
                            
                            
                            bufferData.setType(2);
                            bufferData.setBufferContent(Common.buffer2.toString().replace("[", "").replace("]", ""));
                            bufferData.setBufferContentNum(Common.buffer2.size());
                            bufferData.setFreeSpaceNum(Common.Buffer2Size-Common.buffer2.size());
                            
                            bufferData.setMessage("Move" + Thread.currentThread().getId() + "放入了" + c);
                            setParamDao.saveMessage(bufferData);
                            

                            try {
                 
                                Thread.sleep((long) (Math.random() * 100 * (50-Common.moveSpeed)));
                                Common.buffer2.notify();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            
                        }
                	}else if(common.place==3) {
                		synchronized (Common.buffer3) {
                            while (Common.buffer3.size() == Common.Buffer3Size) {
                                try {
                                	Common.BlockedThreadNum++;
                                    Common.buffer3.wait();
                                    Common.BlockedThreadNum--;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            
                            BufferData bufferData = new BufferData();
                            SetParamDao setParamDao = new SetParamDaoImpl();
                            bufferData.setType(1);
                            bufferData.setBufferContent(Common.buffer1.toString().replace("[", "").replace("]", ""));
                            bufferData.setBufferContentNum(Common.buffer1.size());
                            bufferData.setFreeSpaceNum(Common.Buffer1Size-Common.buffer1.size());
                          
                            bufferData.setMessage("Move" + Thread.currentThread().getId() + "拿走了" + c);
                            setParamDao.saveMessage(bufferData);
                            
                            
                            Common.getOutBufferNum++;
                            Common.buffer3.add(c);
                            Common.putInBufferNum++;
                            
                            bufferData.setType(3);
                            bufferData.setBufferContent(Common.buffer3.toString().replace("[", "").replace("]", ""));
                            bufferData.setBufferContentNum(Common.buffer3.size());
                            bufferData.setFreeSpaceNum(Common.Buffer3Size-Common.buffer3.size());
                           
                            bufferData.setMessage("Move" + Thread.currentThread().getId() + "放入了" + c);
                            setParamDao.saveMessage(bufferData);
                           

                            try {
                            	Thread.sleep((long) (Math.random() * 100 * (50-Common.moveSpeed)));
                                Common.buffer3.notify();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            
                        }
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
}
