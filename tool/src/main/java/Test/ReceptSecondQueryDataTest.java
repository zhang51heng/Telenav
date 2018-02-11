package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.json.JSONObject;

public class ReceptSecondQueryDataTest {
	public static void main(final String args[]) {
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
			int i = 0;
			/* 读入TXT文件 */
			final String pathname = "/Users/hengzhang/Documents/soft/jmeter/groupcreateby1m.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
			final File filename = new File(pathname); // 要读取以上路径的input。txt文件
			final InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
			final BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

			/* 写入Txt文件 */
			final File writename = new File("/Users/hengzhang/Documents/soft/jmeter/second_query_meetupId.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
			writename.createNewFile(); // 创建新文件
			final BufferedWriter out = new BufferedWriter(new FileWriter(writename));

			String line = "";
			line = br.readLine();
			while (line != null) {
				System.out.println(i++ / 10);
				line = br.readLine(); // 一次读入一行数据
				if (line != null) {
					final JSONObject jo = new JSONObject(line);
					//					final String userId = (String) jo.get("user_id");
					final String groupId = (String) jo.get("group_id");

					/* 读入TXT文件 */
					final String pathname1 = "/Users/hengzhang/Documents/soft/jmeter/host.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
					final File filename1 = new File(pathname1); // 要读取以上路径的input。txt文件
					final InputStreamReader reader1 = new InputStreamReader(new FileInputStream(filename1)); // 建立一个输入流对象reader
					final BufferedReader br1 = new BufferedReader(reader1); // 建立一个对象，它把文件内容转成计算机能读懂的语言
					String line1 = "";
					line1 = br1.readLine();
					//					System.out.println(line1);
					while (line1 != null) {
						line1 = br1.readLine(); // 一次读入一行数据
						if (line1 != null) {
							final JSONObject jo1 = new JSONObject(line1);
							final String groupId1 = (String) jo1.get("group_id");
							//							System.out.println(groupId1);
							//							System.out.println(groupId);
							final String meetupId = (String) jo1.get("meetup_id");
							if (groupId.equals(groupId1)) {
								out.write(meetupId + "\r\n"); // \r\n即为换行
							}
						}
					}
					br1.close();
					reader1.close();
				}
			}
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
		}
		catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
