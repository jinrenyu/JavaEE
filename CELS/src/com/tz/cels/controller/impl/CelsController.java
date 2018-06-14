package com.tz.cels.controller.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import com.tz.cels.controller.Controller;
import com.tz.cels.entity.BaseTerm;
import com.tz.cels.entity.PageBean;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.exceptions.NoTestRecordException;
import com.tz.cels.exceptions.NohistoryException;
import com.tz.cels.service.IBrowserService;
import com.tz.cels.service.IGameService;
import com.tz.cels.service.ITestingService;
import com.tz.cels.service.impl.BrowserServiceImpl;
import com.tz.cels.service.impl.GameServiceImpl;
import com.tz.cels.service.impl.TestingServiceImpl;
import com.tz.cels.util.DateUtil;
import com.tz.cels.util.TimeUtil;
import com.tz.cels.view.ClientUI;

public class CelsController implements Controller {
	private ClientUI ui;
	private IBrowserService browserService;
	private IGameService gameService;
	private ITestingService testingService;

	public CelsController() {
		super();
		this.ui = new ClientUI();
		this.browserService = new BrowserServiceImpl();
		this.gameService = new GameServiceImpl();
		this.testingService = new TestingServiceImpl();

	}

	public CelsController(ClientUI ui, IBrowserService browserService, IGameService gameService,
			ITestingService testingService) {
		super();
		this.ui = ui;
		this.browserService = browserService;
		this.gameService = gameService;
		this.testingService = testingService;
	}

	public static String StringScanner() {
		String i;
		Scanner sc = new Scanner(System.in);
		i = sc.nextLine();
		return i;
	}

	@Override
	public void action() {
		String a_1_1 = null;
		String a = null;
		String a_1 = null;
		String j = null;
		String next;
		// 输出欢迎界面
		ui.welcome();
		do {
			ui.mainMenu();
			System.out.print("请选择>");
			a = CelsController.StringScanner();
			if (!a.matches("[01234]")) {
				System.out.println("输入有误");
				System.out.println("请重新输入>");
				continue;
				// a = CelsController.StringScanner();
			}
			// sc.close();

			switch (a.charAt(0) - '0') {
			case 1:
				do {
					ui.showBrowserSubMenu();
					System.out.print("请选择>");
					a_1 = CelsController.StringScanner();
					if (!a_1.matches("[012]")) {
						System.out.println("输入有误");
						System.out.println("请重新输入>");
						continue;
						// a_1 = CelsController.StringScanner();
					}
					// sc1.close();
					switch (a_1.charAt(0) - '0') {
					case 1: // 浏览单词
						do {
							Map<Character, Set<Word>> map = new TreeMap<>();
							map = browserService.getFirstMap();
							int n = 0;
							int wnum = 0;
							// 输出单词的首字母及该首字母的单词个数
							Set<Entry<Character, Set<Word>>> entrys = map.entrySet();
							for (Entry<Character, Set<Word>> entry : entrys) {
								n++;
								// 获取key
								Character key = entry.getKey();
								// 获取value
								Set<Word> value = entry.getValue();
								// 输出
								if (n % 5 == 0) {
									System.out.println();
								}
								System.out.print(key + "[");
								System.out.print(value.size() + "] ");
							}
							// 输出各个首字母下的具体单词

							System.out.println("\n请选择你要查看的字母>");
							a_1_1 = CelsController.StringScanner();
							if (!a_1_1.matches("[a-zA-Z]")) {
								System.out.println("输入的不是字母");
								System.out.println("请重新输入>");
								a_1_1 = CelsController.StringScanner();
							}
							Set<Word> set = new TreeSet<>();
							set = map.get(a_1_1.toLowerCase().charAt(0));

							int i = 1;
							do {
								PageBean pb = new PageBean();
								pb = browserService.getPageWords(i, set);
								List<Word> list = new ArrayList<>();
								list = pb.getWdatas();
								for (Word word : list) {
									wnum++;
									System.out.println(
											wnum + ". " + word.getEn() + " => 解释：" + Arrays.toString(word.getCn()));
								}
								if (list.size() < 15) {
									break;
								}

								System.out.println("是否输出下一页【Y or N】");
								next = CelsController.StringScanner();
								i++;
							} while (next.equals("Y") || next.equals("y"));

							break;
						} while (next.equals("Y") || next.equals("y"));
						continue;

					case 2: // 浏览词汇
						do {
							int vnum = 0;
							System.out.println("每页【15】行，共计【29】页，词汇量总数：【435】，返回上一级 0");
							System.out.println("| 1 | 2 | 3 | 4 | ... | 29 |");
							do {
								System.out.println("请选择页码【1~29】");
								j = CelsController.StringScanner();
								if (j.matches("[1-9]|1[0-9]|2[0-9]")) {

									PageBean pb = new PageBean();
									pb = browserService.getPageVocabularies(j.charAt(0) - '0');
									pb.getPageSize();
									pb.getPages();
									List<Vocabulary> list = new ArrayList<>();
									list = pb.getVdatas();
									for (Vocabulary v : list) {
										vnum++;
										if (v.getAcronym() == null) {
											System.out.println(
													vnum + ". " + v.getEn() + " => 解释：" + Arrays.toString(v.getCn()));
										} else {
											System.out.println(vnum + ". " + v.getEn() + " => 解释："
													+ Arrays.toString(v.getCn()) + "缩写：" + v.getAcronym());
										}
									}
									if (list.size() < 15) {
										break;
									}
								} else {
									if (j.equals("0")) {
										break;
									} else {
										System.out.println("输入页码有误");
										System.out.println("请重新输入>");
										continue;
										// j = CelsController.StringScanner();

									}
								}
							} while (true);

							break;
						} while (true);
						break;
					case 0:
						break;
					default:
						break;
					}

				} while (!a_1.equals("0"));
				break;
			case 2:
				do {
					ui.showGameSubMenu();
					System.out.print("请选择>");
					a = CelsController.StringScanner();
					if (!a.matches("[012]")) {
						System.out.println("输入有误");
						System.out.println("请重新输入");
						continue;
					}
					switch (a.charAt(0) - '0') {
					case 1:
						do {
							int count = 0;
							int rcount = 0;
							int ncount = 0;
							long stime = 0;
							long etime = 0;
							System.out.println("是否重上次继续？ Y or N");
							a = CelsController.StringScanner();
							if (!a.matches("[ynYN]")) {
								System.out.println("输入有误");
								System.out.println("请重新输入");
								continue;
							} else if (a.toLowerCase().charAt(0) == 'n') {
								Map<String, String> map = new TreeMap<>();
								try {
									map = gameService.en2cn(true);
									Set<Entry<String, String>> fentrys = map.entrySet();
									Set<Entry<String, String>> entrys = new HashSet<>();
									entrys.addAll(fentrys);

									for (Entry<String, String> entry : entrys) {
										count++;
										// 获取key
										String key = entry.getKey();
										// 获取value
										String value = entry.getValue();
										System.out.print("【退出：e or q】");
										System.out.println("【" + key + "】" + "的中文是：");
										a = CelsController.StringScanner();
										if (!a.matches("[eqEQ]")) {
											// 获取当前时间距离1970.1.1的毫秒数
											stime = System.currentTimeMillis();
											String[] strs = value.split(",");
											boolean flag = false;
											for (String s : strs) {
												if (s.equals(a)) {
													flag = true;
													rcount++;
													System.out.println("✔回答正确，完整的解释是：【" + value + "】");
													break;
												}

											}
											if (flag == false)
												System.out.println("✘回答错误，完整的解释是：【" + value + "】");
											continue;
										} else {
											// 获取当前时间距离1970.1.1的毫秒数
											etime = System.currentTimeMillis();
											break;
										}
									}

									Map<String, String> nmap = new HashMap<>();
									for (Entry<String, String> nentry : entrys) {
										ncount++;
										if (ncount <= count) {
											continue;
										} else {
											// 获取key
											String key = nentry.getKey();
											// 获取value
											String value = nentry.getValue();
											nmap.put(key, value);
										}
									}
									gameService.saveGameHistory(nmap, true);
									System.out.println("保存历史记录成功");
									// 计算百分数
									double rate = (double) rcount / (double) count;
									NumberFormat nFormat = NumberFormat.getPercentInstance();
									String rates = nFormat.format(rate);
									// 计算答题时间
									long ftime = etime - stime;
									String t = TimeUtil.formatTime(ftime);
									// 输出
									System.out.println("本次游戏共回答了【" + count + "】次，正确个数【" + rcount + "】，准确率【 " + rates
											+ "】，共花费时长：【" + t + "】。");
									System.out.println(":) :) :)哎哟！不错哦");
									break;

								} catch (NohistoryException e) {
									e.printStackTrace();
								}
							} else {
								Map<String, String> map = new HashMap<>();
								try {
									map = gameService.en2cn(false);
									Set<Entry<String, String>> entrys = map.entrySet();
									for (Entry<String, String> entry : entrys) {
										// 获取key
										String key = entry.getKey();
										// 获取value
										String value = entry.getValue();
										// 输出
										System.out.print("【退出：e or q】");
										System.out.println("【" + key + "】" + "的中文是：");
										a = CelsController.StringScanner();
										if (!a.matches("[eqEQ]")) {
											// 获取当前时间距离1970.1.1的毫秒数
											stime = System.currentTimeMillis();
											String[] strs = value.split(",");
											boolean flag = false;
											for (String s : strs) {
												if (s.equals(a)) {
													flag = true;
													rcount++;
													System.out.println("✔回答正确，完整的解释是：【" + value + "】");
													break;
												}
											}
											if (flag == false)
												System.out.println("✘回答错误，完整的解释是：【" + value + "】");
											continue;
										} else {
											// 获取当前时间距离1970.1.1的毫秒数
											etime = System.currentTimeMillis();
											break;
										}
									}

								} catch (NohistoryException e) {
									e.printStackTrace();
								}
							}

						} while (!a.equals("0"));

						break;
					case 2:
						do {
							int count = 0;
							int rcount = 0;
							int ncount = 0;
							long stime = 0;
							long etime = 0;
							System.out.println("是否重上次继续？ Y or N");
							a = CelsController.StringScanner();
							if (!a.matches("[ynYN]")) {
								System.out.println("输入有误");
								System.out.println("请重新输入");
								continue;
							} else if (a.toLowerCase().charAt(0) == 'n') {
								Map<String, String> map = new TreeMap<>();
								try {
									map = gameService.cn2en(true);
									Set<Entry<String, String>> fentrys = map.entrySet();
									Set<Entry<String, String>> entrys = new HashSet<>();
									entrys.addAll(fentrys);

									for (Entry<String, String> entry : entrys) {
										count++;
										// 获取key
										String key = entry.getKey();
										// 获取value
										String value = entry.getValue();
										System.out.print("【退出：e or q】");
										System.out.println("【" + key + "】" + "的英文是：");
										a = CelsController.StringScanner();
										if (!a.matches("[eqEQ]")) {
											// 获取当前时间距离1970.1.1的毫秒数
											stime = System.currentTimeMillis();
											String[] strs = value.split(",");
											boolean flag = false;
											for (String s : strs) {
												if (s.equals(a)) {
													flag = true;
													rcount++;
													System.out.println("✔回答正确，完整的解释是：【" + value + "】");
													break;
												}

											}
											if (flag == false)
												System.out.println("✘回答错误，完整的解释是：【" + value + "】");
											continue;
										} else {
											// 获取当前时间距离1970.1.1的毫秒数
											etime = System.currentTimeMillis();
											break;
										}
									}

									Map<String, String> nmap = new HashMap<>();
									for (Entry<String, String> nentry : entrys) {
										ncount++;
										if (ncount <= count) {
											continue;
										} else {
											// 获取key
											String key = nentry.getKey();
											// 获取value
											String value = nentry.getValue();
											nmap.put(key, value);
										}
									}
									gameService.saveGameHistory(nmap, false);
									System.out.println("保存历史记录成功");
									// 计算百分数
									double rate = (double) rcount / (double) count;
									NumberFormat nFormat = NumberFormat.getPercentInstance();
									String rates = nFormat.format(rate);
									// 计算答题时间
									long ftime = etime - stime;
									String t = TimeUtil.formatTime(ftime);
									// 输出
									System.out.println("本次游戏共回答了【" + count + "】次，正确个数【" + rcount + "】，准确率【 " + rates
											+ "】，共花费时长：【" + t + "】。");
									System.out.println(":) :) :)哎哟！不错哦");
									break;

								} catch (NohistoryException e) {
									e.printStackTrace();
								}
							} else {
								Map<String, String> map = new HashMap<>();
								try {
									map = gameService.cn2en(false);
									Set<Entry<String, String>> entrys = map.entrySet();
									for (Entry<String, String> entry : entrys) {
										// 获取key
										String key = entry.getKey();
										// 获取value
										String value = entry.getValue();
										// 输出
										System.out.print("【退出：e or q】");
										System.out.println("【" + key + "】" + "的中文是：");
										a = CelsController.StringScanner();
										// 获取当前时间距离1970.1.1的毫秒数
										stime = System.currentTimeMillis();
										if (!a.matches("[eqEQ]")) {
											String[] strs = value.split(",");
											boolean flag = false;
											for (String s : strs) {
												if (s.equals(a)) {
													flag = true;
													rcount++;
													System.out.println("✔回答正确，完整的解释是：【" + value + "】");
													break;
												}
											}
											if (flag == false)
												System.out.println("✘回答错误，完整的解释是：【" + value + "】");
											continue;
										} else {
											// 获取当前时间距离1970.1.1的毫秒数
											etime = System.currentTimeMillis();
											break;
										}
									}

								} catch (NohistoryException e) {
									e.printStackTrace();
								}
							}

						} while (true);

						break;
					case 0:
						break;
					default:
						break;
					}
				} while (!a.equals("0"));
				break;
			case 3:
				do {
					ui.showTestingSubMenu();
					System.out.print("请选择>");
					a = CelsController.StringScanner();
					if (!a.matches("[012]")) {
						System.out.println("输入有误");
						System.out.println("请重新输入");
						continue;
					}
					switch (a.charAt(0) - '0') {
					case 1:
						int count = 0;
						int rcount = 0;
						long stime = 0;
						long etime = 0;
						System.out.println("请输入要测试的题目的数量[5~100]");
						a = CelsController.StringScanner();
						if (!a.matches("[56789]|[1-9][0-9]|100")) {
							System.out.println("输入有误");
							System.out.println("请重新输入");
							continue;
						}
						// 获取当前时间距离1970.1.1的毫秒数
						stime = System.currentTimeMillis();
						int num;
						if (a.length() == 3) {
							num = 100;
						} else if (a.length() == 2) {
							num = ((a.charAt(0) - '0') * 10 + (a.charAt(1) - '0'));
						} else {
							num = (a.charAt(0) - '0');
						}
						List<BaseTerm> list = new ArrayList<BaseTerm>();
						list = testingService.getTestingData(num);
						TestRecord record = new TestRecord();
						Date date = new Date();
						for (BaseTerm b : list) {
							count++;
							String[] cn = b.getCn();
							String en = b.getEn();
							System.out.print("【退出：e or q】");
							System.out.println("【" + en + "】" + "的中文含义是：");
							a = CelsController.StringScanner();
							if (!a.matches("[eqEQ]")) {

								boolean flag = false;
								for (String s : cn) {
									if (s.equals(a)) {
										rcount++;
										flag = true;
										System.out.println("✔回答正确，完整的解释是：【" + Arrays.toString(cn) + "】");
										break;
									}
								}
								if (flag == false)
									System.out.println("✘回答错误，完整的解释是：【" + Arrays.toString(cn) + "】");
								continue;
							} else {
								break;
							}

						}
						// 获取当前时间距离1970.1.1的毫秒数
						etime = System.currentTimeMillis();
						// 计算百分数
						double rate = (double) rcount / (double) count;
						NumberFormat nFormat = NumberFormat.getPercentInstance();
						String rates = nFormat.format(rate);
						// 计算答题时间
						long ftime = etime - stime;
						String t = TimeUtil.formatTime(ftime);

						record.setCount(count);
						record.setRightcount(rcount);
						record.setDate(date);
						record.setFinishcount(count);
						record.setTime(ftime);
						record.setList(list);
						testingService.saveTestRecord(record);
						System.out.println("保存成功");
						// 输出
						System.out.println(
								"本次游戏共回答了【" + count + "】次，正确个数【" + rcount + "】，准确率【 " + rates + "】，共花费时长：【" + t + "】。");
						break;
					case 2:
						try {
							List<TestRecord> rlist = new ArrayList<>();
							rlist = testingService.reviewTestRecord();
							for (TestRecord tr : rlist) {
								Date ndate = new Date();
								ndate = tr.getDate();
								String formdate = null;
								formdate = DateUtil.formatDate(ndate, "yyyy-MM-dd HH:mm:ss");
								String tmstr = null;
								tmstr = TimeUtil.formatTime(tr.getTime());
								int n = 0;
								n = tr.getCount();
								int m = 0;
								m = tr.getRightcount();
								List<BaseTerm> nlist = new ArrayList<BaseTerm>();
								nlist = tr.getList();
								System.out.println("测试时间：" + formdate + ",测试时长：" + tmstr);
								System.out.println("测试总题数：" + n + ",完成题数：" + n);
								System.out.println("正确个数：" + m + "，错误个数：" + (n - m));
								System.out.println("本次测试数据如下：");
								for (BaseTerm b : nlist) {
									System.out.print(b.getEn() + "    ");

								}
								System.out.println();
								continue;
							}
						} catch (NoTestRecordException e) {
							e.printStackTrace();
						}
						break;
					case 0:
						break;
					}
				} while (!a.equals("0"));
				break;
			case 4:
				do {
					ui.showQuerySubMenu();
					System.out.print("请选择>");
					a = CelsController.StringScanner();
					if (!a.matches("[012]")) {
						System.out.println("输入有误");
						System.out.println("请重新输入");
						continue;
					}
					switch (a.charAt(0) - '0') {
					case 1:
						boolean flag = false;
						do {
							System.out.print("【退出：e or q】");
							System.out.println("请输入你要查询的英文单词和词汇");
							a = CelsController.StringScanner();
							if (!a.matches("[a-zA-Z]+")) {
								System.out.println("输入有误");
								System.out.println("请重新输入");
								continue;
							}
							if (a.matches("[eqEQ]")) {
								break;
							}
							Map<String, String> map = new TreeMap<>();
							try {
								map = gameService.en2cn(true);
								Set<Entry<String, String>> fentrys = map.entrySet();
								Set<Entry<String, String>> entrys = new HashSet<>();
								entrys.addAll(fentrys);

								for (Entry<String, String> entry : entrys) {
									// 获取key
									String key = entry.getKey();
									// 获取value
									String value = entry.getValue();
									if (a.equals(key)) {
										flag = true;
										System.out.println(value);
										break;
									}
								}
								if (flag == false) {
									System.out.println("词库中没有该单词");
									continue;
								}
							} catch (NohistoryException e) {
								e.printStackTrace();
							}
						} while (true);
						break;
					case 2:
						do {
							System.out.print("【退出：e or q】");
							System.out.println("请输入你要查询的中文解释");
							a = CelsController.StringScanner();
							if (a.matches("[eqEQ]")) {
								break;
							}
							Map<String, String> map = new TreeMap<>();
							try {
								map = gameService.cn2en(true);
								Set<Entry<String, String>> fentrys = map.entrySet();
								Set<Entry<String, String>> entrys = new HashSet<>();
								entrys.addAll(fentrys);

								boolean nflag = false;
								for (Entry<String, String> entry : entrys) {
									// 获取key
									String key = entry.getKey();
									// 获取value
									String value = entry.getValue();
									String[] strs = key.split(",");
									for (String s : strs) {
										if (s.equals(a)) {
											nflag = true;
											System.out.println(value);
											break;
										}

									}
								}
								if (nflag == false)
									System.out.println("词库中没有该单词");
								continue;
							} catch (NohistoryException e) {
								e.printStackTrace();
							}
						} while (true);
						break;
					case 0:
						break;
					default:
						break;
					}

				} while (!a.equals("0"));
				break;
			case 0:
				return;
			default:
				break;
			}

		} while (true);

	}

}
