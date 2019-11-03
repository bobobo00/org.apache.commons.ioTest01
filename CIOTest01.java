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
		//�ļ���С
		long len=FileUtils.sizeOf(new File("E:\\workspace-java\\IO������\\src\\cn\\io\\commons\\CIOTest01.java"));
		System.out.println(len);
		//Ŀ¼��С
		len=FileUtils.sizeOf(new File("E:\\workspace-java\\IO������\\src\\cn\\io\\study01"));
		System.out.println(len);
		//��ȡĿ¼����
		Collection<File> files=FileUtils.listFiles(new File("E:\\workspace-java\\IO������\\src\\cn\\io\\study01"), 
				EmptyFileFilter.NOT_EMPTY, null);//��������ָ���涨�ļ���ָ���涨��Ŀ¼
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		//��ȡ�ļ�
		String msg=FileUtils.readFileToString(new File("aaa.txt"),"GBK");
		System.out.println(msg);
		byte[] datas=FileUtils.readFileToByteArray(new File("aaa.txt"));
		System.out.println(datas.length);	
		//���ж�ȡ
		List<String> list=FileUtils.readLines(new File("aaa.txt"),"gbk");
		for(String str:list) {
			System.out.print(str);
		}
		LineIterator li=FileUtils.lineIterator(new File("aaa.txt"),"gbk");
		while(li.hasNext()) {
			System.out.print(li.nextLine());
		}
		//д������
		FileUtils.write(new File("aaa.txt"), "��ѧ��","gbk",true);
		FileUtils.writeStringToFile(new File("aaa.txt"), "����\r\n", "gbk",true);
		FileUtils.writeByteArrayToFile(new File("aaa.txt"), "�Ҹ�".getBytes("gbk"),true);
	    //д���б�
		List<String> lists=new ArrayList<>();
		lists.add("qqq������");
		lists.add("qqqq��������");
		lists.add("wwww��������");
		
		FileUtils.writeLines(new File("aaa.txt"), "gbk",lists,",,,,",true);
		
	
	}

}
