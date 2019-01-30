package task;

import dao.SetParamDao;
import dao.SetParamDaoImpl;
import entity.BufferData;
import task.Common;

/**
 * @auther fyf
 * @date 2018/12/18 - 15:21
 */
public class GetBuffer implements Runnable{
 
    private boolean flag = true;
    private Common common;
    char c;
    public GetBuffer() {
    }
    public GetBuffer(Common common) {
       
        this.common = common;
    }
    @Override
    public void run() {
    	
            while (Common.flag) {
           
            	if(common.place==2) {
            		 synchronized (Common.buffer2) {
                         while (Common.buffer2.size() == 0) {
                             try {
                             	 Common.BlockedThreadNum++;
                                 Common.buffer2.wait();
                                 Common.BlockedThreadNum--;
                             } catch (InterruptedException e) {
                                 e.printStackTrace();
                             }
                         }
                         c = Common.buffer2.get(0);
                         Common.buffer2.remove(0);
                         Common.getOutBufferNum++;
                         BufferData bufferData = new BufferData();
                         SetParamDao setParamDao = new SetParamDaoImpl();
                         bufferData.setType(2);
                         
                         bufferData.setBufferContent(Common.buffer2.toString().replace("[", "").replace("]", ""));
                         bufferData.setBufferContentNum(Common.buffer2.size());
                         bufferData.setFreeSpaceNum(Common.Buffer2Size-Common.buffer2.size());
          
                        
                         bufferData.setMessage("Get" + Thread.currentThread().getId() + "拿走了" + c);
                         setParamDao.saveMessage(bufferData);
                         
                         
                         
                         try {
                        	 Thread.sleep((long) (Math.random() * 100 * (50-Common.getSpeed)));
                             Common.buffer2.notify();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         
                     }
            	}else if(common.place==3) {
            		synchronized (Common.buffer3) {
                        while (Common.buffer3.size() <= 0) {
                            try {
                            	Common.BlockedThreadNum++;
                                Common.buffer3.wait();
                                Common.BlockedThreadNum--;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        c = Common.buffer3.get(0);
                        Common.buffer3.remove(0);
                        Common.getOutBufferNum++;
                        
                        BufferData bufferData = new BufferData();
                        SetParamDao setParamDao = new SetParamDaoImpl();
                        bufferData.setType(3);
                        
                        bufferData.setBufferContent(Common.buffer3.toString().replace("[", "").replace("]", ""));
                        bufferData.setBufferContentNum(Common.buffer3.size());
                        bufferData.setFreeSpaceNum(Common.Buffer3Size-Common.buffer3.size());
                       
                        
                        bufferData.setMessage("Get" + Thread.currentThread().getId() + "拿走了" + c);
                        setParamDao.saveMessage(bufferData);
                        
                       
                        try {
                        	 Thread.sleep((long) (Math.random() * 100 * (50-Common.getSpeed)));
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
