package Commons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

	public void writeFilesTest(final String fileUrlName, final List<String> results) throws IOException {
		/* 写入Txt文件 */
		final File writename = new File(fileUrlName); // 相对路径，如果没有则要建立一个新的output。txt文件
		writename.createNewFile(); // 创建新文件
		final BufferedWriter out = new BufferedWriter(new FileWriter(writename));
		for (final String result : results) {
			out.write(result + "\r\n");
		}
		out.flush(); // 把缓存区内容压入文件
		out.close(); // 最后记得关闭文件
	}

	public List<String> readFilesTest(final String fileUrlName) throws IOException {
		final List<String> results = new ArrayList<String>();
		/* 读入TXT文件 */
		final String pathname = fileUrlName; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
		final File filename = new File(pathname); // 要读取以上路径的input。txt文件
		final InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
		final BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

		String line = "";
		line = br.readLine();
		while (line != null) {
			line = br.readLine(); // 一次读入一行数据
			if (line != null) {
				results.add(line.trim());
			}
		}
		return results;
	}
}
