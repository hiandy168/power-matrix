package com.matrix.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.io.IOException;
import java.awt.image.BufferedImage;


/**
 * @descriptions 二维码生成工具  
 *
 * @author Yangcl 
 * @home https://github.com/PowerYangcl
 * @date 2017年3月7日 下午10:11:55
 * @version 1.0.1
 */
public class QrcodeUtil {
	
	public static final QrcodeUtil getInstance(){
		return Holder.instance; 
	}
	
	private QrcodeUtil() {
	}
	private static class Holder{
		private static final QrcodeUtil instance = new QrcodeUtil();
	}
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	/**
	 * @descriptions 将二维码写入到一个文件中 
	 *
	 * @param content
	 * @param path
	 * @param width
	 * @param height
	 * @date 2017年3月7日 下午10:56:11
	 * @author Yangcl 
	 * @version 1.0.0.1
	 */
	public void drawPic(String content , String path , int width , int height){
		//二维码的图片格式
        String format = "jpg"; 
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>(); 
        //内容所使用编码 
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
        try {
        	BitMatrix bitMatrix = new MultiFormatWriter().encode(content , BarcodeFormat.QR_CODE, width, height, hints); 
        	//生成二维码 
        	File outputFile = new File(path);  
        	QrcodeUtil.getInstance().writeToFile(bitMatrix, format, outputFile); 
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}
	
	private void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
		BufferedImage image = this.toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format " + format + " to " + file);
		}
	}
	
	private void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
		BufferedImage image = this.toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}
	
	
	private BufferedImage toBufferedImage(BitMatrix matrix){
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height , BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}
	
	public static void main(String[] args) throws Exception { 
        //二维码源地址
    	String text = "www.baidu.com"; 
    	//二维码宽高设置
        int width = 300; 
        int height = 300; 
        //二维码的图片格式
        String format = "jpg"; 
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>(); 
        //内容所使用编码 
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
        
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text , BarcodeFormat.QR_CODE, width, height, hints); 
        //生成二维码 
        File outputFile = new File("D:\\vmware"+File.separator+"ins.jpg"); 
        QrcodeUtil.getInstance().writeToFile(bitMatrix, format, outputFile); 
    } 
	
}








































