package com.mec.about_file.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileProcess {
	public static final int DEFAULT_BUFFER_SIZE = 1 << 22;
	
	public static boolean fileCopy(String src, String tag) {
	    /**
	     * @param: [src, tag]
	     * @return: boolean
	     * @date: 2018/11/21
	     * @Description: 
	     */
		File in = new File(src);
		if(!in.exists()) {
			return false;
		}
		File out = new File(tag);
		return fileCopy(in, out);
	}
	
	public static boolean fileCopy(File srcFile, File tagFile) {
	    /**
	     * @param: [srcFile, tagFile]
	     * @return: boolean
	     * @date: 2018/11/21
	     * @Description: 
	     */
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel inFileChannel = null;
		FileChannel outFileChannel = null;
		int restSize = (int) srcFile.length();
		
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(tagFile);
			
			inFileChannel = fis.getChannel();
			outFileChannel = fos.getChannel();
			
			inFileChannel.transferTo(0, restSize, outFileChannel);
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) { }
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) { }
			}
		}
		
		
		return true;
	}
}
