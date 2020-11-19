package com.ubot.application.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 1095307 待更正:不要第一行
 */
public class UpdateCSV {

	public static void main(String[] args) throws IOException {
		try {
			InputStreamReader isr = new InputStreamReader(
					new FileInputStream("C://Users//1095307//Desktop//csvInfo//mware.csv"));
			BufferedReader bufferedReader = new BufferedReader(isr);
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter("C://Users//1095307//Desktop//csvInfo//mware_outPut.csv"));
			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				String item[] = line.split(",");
				String[] dataArray = { item[0].trim(), item[1].trim(), item[2].trim() };
				if (item[0] != null && item[2] != null) {
					if (item[0] != null) {
						System.out.println("安");
						dataArray[0].replace(dataArray[0].substring(0, dataArray[0].length()), "EAIHUB_CARD");
					}
					System.out.println(item[0]);
//					System.out.println(item[1]);
					if (item[1].equals("9010") || item[1].equals("F204") || item[1].equals("I016")) {
						bufferedWriter.write("\'" + dataArray[0] + "\'" + "," + "\'" + dataArray[1] + "\'" + "," + "\'"
								+ dataArray[2] + "\'" + "\n");
						System.out.println("指定代碼寫入成功");
					} else {
						bufferedWriter.write("\'" + dataArray[0] + "\'" + "," + "\'" + dataArray[1] + "\'" + "," + "\'"
								+ dataArray[2].replace(dataArray[2].substring(0, dataArray[2].length()),
										"很抱歉，資料查詢失敗，請稍後再試，或來電信用卡客服查詢！")
								+ "\'" + "\n");
					}

				} else {
					System.out.println("log error:錯誤銀行為空");
				}
			}
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
