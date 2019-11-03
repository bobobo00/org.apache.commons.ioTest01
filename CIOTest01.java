package cn.io.commons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.EmptyFileFilter;

public class CIOTest01 {
	public static void main(String[] args) throws IOException {
		//文件大小
		long len=FileUtils.sizeOf(new File("E:\\workspace-java\\IO流技术\\src\\cn\\io\\commons\\CIOTest01.java"));
		System.out.println(len);
		//目录大小
		len=FileUtils.sizeOf(new File("E:\\workspace-java\\IO流技术\\src\\cn\\io\\study01"));
		System.out.println(len);
		//获取目录序列
		Collection<File> files=FileUtils.listFiles(new File("E:\\workspace-java\\IO流技术\\src\\cn\\io\\study01"), 
				EmptyFileFilter.NOT_EMPTY, null);//过滤器：指定规定文件，指定规定子目录
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		//读取文件
		String msg=FileUtils.readFileToString(new File("aaa.txt"),"GBK");
		System.out.println(msg);
		byte[] datas=FileUtils.readFileToByteArray(new File("aaa.txt"));
		System.out.println(datas.length);	
		//逐行读取
		List<String> list=FileUtils.readLines(new File("aaa.txt"),"gbk");
		for(String str:list) {
			System.out.print(str);
		}
		LineIterator li=FileUtils.lineIterator(new File("aaa.txt"),"gbk");
		while(li.hasNext()) {
			System.out.print(li.nextLine());
		}
		//写出内容
		FileUtils.write(new File("aaa.txt"), "尚学堂","gbk",true);
		FileUtils.writeStringToFile(new File("aaa.txt"), "辛苦\r\n", "gbk",true);
		FileUtils.writeByteArrayToFile(new File("aaa.txt"), "幸福".getBytes("gbk"),true);
	    //写出列表
		List<String> lists=new ArrayList<>();
		lists.add("qqq哈哈哈");
		lists.add("qqqq凄凄切切");
		lists.add("wwww呜呜呜呜");
		
		FileUtils.writeLines(new File("aaa.txt"), "gbk",lists,",,,,",true);
		
	
	}

}
